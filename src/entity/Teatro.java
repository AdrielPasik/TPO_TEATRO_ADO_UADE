package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Teatro {

    private String nombre;
    private String ubicacion;
    private List<Grupo> grupos;
    private List<Funcion> funciones;
    private List<Ticket> ticketsVendidos;
    private List<Asiento> asientos;

    public void agregarGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public void agregarFuncion(Funcion funcion) {
        this.funciones.add(funcion);
    }

    public int cantidadAsientosDisponibles(){
        int c = 0;
        for(Asiento asiento: this.asientos){
            if (asiento.isLibre()){
                c++;
            }
        }
        return c;
    }

    public Asiento getAsientoById(int id){
        for(Asiento asiento: this.asientos){
            if(asiento.getIdAsiento() == id){
                return asiento;
            }
        }
        return null;
    }
    public List<Asiento> getAsientosDesocupados(){
        List<Asiento> asientos = new ArrayList<>();
        for(Asiento asiento: this.asientos){
            if(asiento.isLibre()){
                asientos.add(asiento);
            }
        }
        return asientos;
    }

    public Grupo getGrupoById(int id){
        for (int i = 0; i<grupos.size();i++){
            if(grupos.get(i).getId() == id){
                return grupos.get(i);
            }
        }
        return null;
    }

    public Funcion getFuncionByid(int id){
        for (int i = 0; i<funciones.size();i++){
            if(grupos.get(i).getId() == id){
                return funciones.get(i);
            }
        }
        return null;
    }

}
