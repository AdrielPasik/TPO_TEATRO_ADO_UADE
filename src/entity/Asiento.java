package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Asiento {

    private int idAsiento;
    private TipoZona tipoZona;
    private boolean libre;

    public void ocupar(){
        this.libre = false;
    }


}
