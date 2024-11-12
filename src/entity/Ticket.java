package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Ticket {

    private int DNIComprador;
    private MedioDePago medioDePago;
    private int idFuncion; 
    private int idAsiento;
}
