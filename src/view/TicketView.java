package view;

import entity.ItemFactura;
import entity.MedioDePago;
import entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TicketView {

    private int DNIComprador;
    private MedioDePago medioDePago;
    private List<ItemFactura> itemFacturas;
    private double total;

    public static TicketView map(Ticket ticket) {
        return new TicketView(ticket.getDNIComprador(), ticket.getMedioDePago(), ticket.getItemFacturas(), ticket.getTotal());
    }

    @Override
    public String toString() {

        return
                "DNIComprador : " + DNIComprador +
                ", medioDePago : " + medioDePago.getClass().getName().substring(7) +
                ", \nitemFacturas : " + itemFacturas +
                ", \ntotal : " + total;
    }
}
