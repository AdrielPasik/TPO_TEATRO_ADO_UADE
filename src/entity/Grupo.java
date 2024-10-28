package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grupo {
    private int id;
    private String nombre;
    private String descripcion;
}
