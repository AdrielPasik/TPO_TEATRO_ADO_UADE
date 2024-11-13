package entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemFactura {

    private int idAsiento;
    private Funcion funcion;

    @Override
    public String toString() {
        return
                "\nFuncion : " + funcion.getNombre() +
                ", Horario inicio : " + funcion.getFechaHora()+
                ", idAsiento : " + idAsiento ;
    }
}
