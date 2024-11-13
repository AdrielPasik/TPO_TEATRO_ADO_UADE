package controller;

import entity.Funcion;
import entity.Grupo;
import entity.Ticket;
import entity.TeatroHandler;
import view.FuncionView;
import view.GrupoView;
import view.TicketView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeatroAdminController {

    public TeatroAdminController() {
    }

    public void addFuncion(LocalDateTime fechaHora, int duracion, double precio, String nombre) {
        TeatroHandler.getInstance().addFuncion(fechaHora, duracion, precio, nombre);
    }

    public void addGrupo(String nombre, String detalle) {
        TeatroHandler.getInstance().agregarGrupo(nombre, detalle);
    }

    public void asignarGrupoAFuncion(int idGrupo, int idFuncion) {
        TeatroHandler.getInstance().asignarGrupoAFuncion(idGrupo, idFuncion);
    }

    public List<GrupoView> getListaGrupos() {
        List<Grupo> grupos = TeatroHandler.getInstance().getGrupos();
        List<GrupoView> grupoVIews = new ArrayList<>();
        for (Grupo grupo : grupos) {
            grupoVIews.add(GrupoView.map(grupo));
        }
        return grupoVIews;
    }

    public List<FuncionView> getListaFuncion() {
        List<Funcion> funciones = TeatroHandler.getInstance().getFunciones();
        List<FuncionView> funcionViews = new ArrayList<>();
        for (Funcion funcion : funciones) {
            funcionViews.add(FuncionView.map(funcion));
        }
        return funcionViews;
    }

    public List<TicketView> getListaTicket() {
        List<TicketView> ticketView = new ArrayList<>();
        List<Ticket> tickets = TeatroHandler.getInstance().getTickets();
        for (Ticket ticket : tickets) {
            ticketView.add(TicketView.map(ticket));
        }
        return ticketView;
    }

    /*public void modificarFuncion(int idFuncion, String fechaHora, String nombre, int duracionMin, double precio) {
        boolean exito = TeatroHandler.getInstance().modificarFuncion(idFuncion, fechaHora, nombre, duracionMin, precio);
        if (exito) {
            view.mostrarMensaje("Función modificada con éxito.");
        } else {
            view.mostrarMensaje("No se pudo modificar la función. Verifique el ID.");
        }
    }*/

    /*public void eliminarFuncion(int idFuncion) {
        boolean exito = TeatroHandler.getInstance().eliminarFuncion(idFuncion);
        if (exito) {
            view.mostrarMensaje("Función eliminada con éxito.");
        } else {
            view.mostrarMensaje("No se pudo eliminar la función. Verifique el ID.");
        }
    }*/

}
