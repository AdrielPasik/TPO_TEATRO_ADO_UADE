package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asiento {

    private int idAsiento;
    private Zona tipoZona;
    private boolean libre;

    public void ocupar(){
        this.libre = false;
    }


}
