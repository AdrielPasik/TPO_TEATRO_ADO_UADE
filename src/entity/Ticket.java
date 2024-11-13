package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class Ticket {

    private int DNIComprador;
    private MedioDePago medioDePago;
    private List<ItemFactura> itemFacturas;
    private double total;

    public Ticket(int DNIComprador, MedioDePago medioDePago, List<ItemFactura> itemFacturas) {
        this.DNIComprador = DNIComprador;
        this.medioDePago = medioDePago;
        this.itemFacturas = itemFacturas;

    }

    private double calcularTotal(){
        double total = 0;
        for (ItemFactura item : itemFacturas) {
            total += item.getFuncion().getPrecio() ;
        }
        return 0;
    }
}
