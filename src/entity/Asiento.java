package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Asiento {

    private int idAsiento;
    private Zona tipoZona;
    private boolean libre;

    public void ocupar(){
        this.libre = false;
    }

    public double costo(double precioFuncion){
        return this.tipoZona.calcularPrecio(precioFuncion);
    }

}
