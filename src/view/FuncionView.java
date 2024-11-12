package view;

import entity.Asiento;
import entity.Funcion;
import entity.Grupo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FuncionView {
    private int id;
    private String fechaHora;
    private String nombre;
    private int duracionMin;
    private double precio;
    private Grupo grupo;


    public static FuncionView map(Funcion f){
        return new FuncionView(f.getId(),f.getFechaHora(),f.getNombre(),f.getDuracionMin(),f.getPrecio(),f.getGrupo());
    }

    @Override
    public String toString() {
        return "FuncionView{" +
                "id=" + id +
                ", fechaHora='" + fechaHora + '\'' +
                ", nombre='" + nombre + '\'' +
                ", duracionMin=" + duracionMin +
                ", precio=" + precio +
                ", grupo=" + grupo +
                '}';
    }

}
