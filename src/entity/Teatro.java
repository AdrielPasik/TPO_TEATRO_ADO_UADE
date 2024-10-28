package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Teatro {

    private String nombre;
    private String ubicacion;
    private List<Grupo> gurpos;
    private List<Funcion> funciones;
    private List<Ticket> ticketsVendidos;
}
