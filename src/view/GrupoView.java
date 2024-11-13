package view;

import entity.Grupo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GrupoView {
    private int id;
    private String nombre;
    private String descripcion;


    public static GrupoView map(Grupo grupo) {
        if (grupo == null) {
            return null;
        }
        return new GrupoView(grupo.getId(), grupo.getNombre(), grupo.getDescripcion());
    }

    @Override
    public String toString() {
        return
                "\nid=" + id +
                ", nombre : '" + nombre + '\'' +
                ", descripcion :'" + descripcion + '\'' +
                '}';
    }
}
