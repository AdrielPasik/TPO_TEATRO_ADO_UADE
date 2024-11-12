package entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemFactura {

    private int idAsiento;
    private Funcion funcion;
}
