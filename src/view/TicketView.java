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

    // Método para mapear un Ticket a un TicketView
    public static TicketView map(Ticket ticket) {
        return new TicketView(ticket.getDNIComprador(), ticket.getMedioDePago(), ticket.getItemFacturas());
    }

    @Override
    public String toString() {

        return "TicketView{" +
                "DNIComprador=" + DNIComprador +
                ", medioDePago=" + medioDePago +
                ", itemFacturas=" + itemFacturas +
                '}';
    }
}
