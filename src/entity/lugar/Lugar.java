package entity.lugar;

import interfaz.Facturable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public abstract class Lugar implements Facturable {

    private int id;
    private boolean ocupado;
    private double precio;
    private Facturable facturable;


}
