package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Teatro {

    private String nombre;
    private String ubicacion;
    private List<Grupo> grupos;
    private List<Funcion> funciones;
    private List<Ticket> ticketsVendidos;

    public void agregarGrupo(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public void agregarFuncion(Funcion funcion) {
        this.funciones.add(funcion);
    }


}
