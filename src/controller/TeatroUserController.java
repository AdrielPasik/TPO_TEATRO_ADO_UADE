package controller;

import entity.*;
import entity.TeatroHandler;
import view.AsientoView;
import view.FuncionView;
import view.TicketView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeatroUserController {

    public TeatroUserController() {
    }

    public List<FuncionView> mostrarFunciones() {
        List<FuncionView> funcionesView = new ArrayList<FuncionView>();
        List<Funcion> funciones = TeatroHandler.getInstance().getFunciones();
        for (Funcion funcion : funciones) {
            funcionesView.add(FuncionView.map(funcion));
        }
        return funcionesView;
    }

    public List<AsientoView> mostrarAsientosLibres(int idFuncion) {
        List<AsientoView> asientosView = new ArrayList<>();
        Funcion funcion = TeatroHandler.getInstance().getFuncionByid(idFuncion);
        List<Asiento> asientosLibres = funcion.asientoLibre();

        for (Asiento asiento : asientosLibres) {
            asientosView.add(AsientoView.map(asiento));
        }

        return asientosView;
    }

    public boolean seleccionarEntrada(int idFuncion, int idAsiento) {
        return TeatroHandler.getInstance().selecionarEntrada(idFuncion, idAsiento);
    }

    public TicketView generarTicket(int DNIComprador, int idMedioPago, int cantCuota) {
        Ticket ticket = TeatroHandler.getInstance().generarTicket(DNIComprador, idMedioPago, cantCuota);
        return TicketView.map(ticket);
    }

}
