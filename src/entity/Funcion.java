package entity;

import interfaz.Facturable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Funcion implements Facturable {

    private int id;
    private LocalDateTime fechaHora;
    private String nombre;
    private int duracionMin;
    private double precio;
    private List<Lugar> listaLugar;

    @Override
    public double getCosto() {
        return this.precio;
    }
}
