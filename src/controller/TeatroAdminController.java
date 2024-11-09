package controller;

import handler.TeatroHandler;
import view.View;

import java.util.Date;

public class TeatroAdminController {

    private View view;

    public TeatroAdminController(View view) {
        this.view = view;
    }

    public void addFuncion(Date fecha, String horaInicio, int duracion, double precio, String nombre) {
        TeatroHandler.getInstance().addFuncion(fecha, horaInicio, duracion, precio, nombre);
        view.mostrarMensaje("Función añadida con éxito: " + nombre);
    }

    public void addGrupo(String nombre, String detalle) {
        TeatroHandler.getInstance().agregarGrupo(nombre, detalle);
        view.mostrarMensaje("Grupo añadido con éxito: " + nombre);
    }

    public void asignarGrupoAFuncion(int idGrupo, int idFuncion) {
        TeatroHandler.getInstance().asignarGrupoAFuncion(idGrupo, idFuncion);
        view.mostrarMensaje("Grupo asignado a la función con éxito.");
    }

    public void mostrarListaTicket() {
    }
}
