package entity;

import interfaz.Facturable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Ticket {

    private List<Facturable> entradas;
    private MedioDePago medioDePago;
}
