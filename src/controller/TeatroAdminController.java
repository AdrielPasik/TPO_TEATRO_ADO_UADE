package controller;

import entity.Grupo;
import entity.Ticket;
import entity.TeatroHandler;

import java.time.LocalDateTime;
import java.util.Date;
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

    /*public void mostrarListaGrupos() {
        List<Grupo> grupos = TeatroHandler.getInstance().getGrupos();
        if (grupos.isEmpty()) {
            view.mostrarMensaje("No hay grupos disponibles.");
        } else {
            for (Grupo grupo : grupos) {
                view.mostrarGrupo(grupo);
            }
        }
    }*/

    public void mostrarListaTicket() {
        List<Ticket> tickets = TeatroHandler.getInstance().getTickets();
        if (tickets.isEmpty()) {
            //view.mostrarMensaje("No hay tickets disponibles.");
        } else {
            for (Ticket ticket : tickets) {
                //view.mostrarTicket(ticket);
            }
        }
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
