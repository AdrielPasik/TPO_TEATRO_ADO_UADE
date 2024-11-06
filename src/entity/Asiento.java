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
    private boolean disponible;
    public void ocupar(){
        this.libre = false;
    }


}
