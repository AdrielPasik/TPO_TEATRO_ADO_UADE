package entity;

import interfaz.MedioDePago;
import interfaz.Facturable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Ticket {

    private int DNIComprador;
    private List<Facturable> entradas;
    private MedioDePago medioDePago;

}
