package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Funcion {

    private int id;
    private String fechaHora;
    private String nombre;
    private int duracionMin;
    private double precio;
    private List<Asiento> asientos;
    private Grupo grupo;

    public double getCosto() {
        return this.precio;
    }

    public void ocuparAsiento(int idAsiento) {
        this.asientos.get(idAsiento).ocupar();
    }

    public List<Asiento> asientoLibre(){
        List<Asiento> asientos = new ArrayList<>();
        for(Asiento asiento: this.asientos){
            if(asiento.isLibre()){
                asientos.add(asiento);
            }
        }
        return asientos;
    }

    public Asiento obtenerAsiento(int idAsiento){
        for(Asiento asiento: this.asientos){
            if(asiento.getIdAsiento() == idAsiento){
                return asiento;
            }
        }
        return null;
    }

    public boolean estaLibre(int idAsiento){
        boolean estaLibre = false;
        if(this.obtenerAsiento(idAsiento) != null && this.obtenerAsiento(idAsiento).isLibre()){
            estaLibre = true;
        }
        return estaLibre;
    }

}
