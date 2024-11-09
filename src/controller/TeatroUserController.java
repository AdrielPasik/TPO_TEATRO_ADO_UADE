package controller;

import entity.*;
import handler.TeatroHandler;
import view.View;

import java.util.List;

public class TeatroUserController {
    private View view;


    public TeatroUserController(View view) {
        this.view = view;
    }

    public void mostrarFunciones() {
        // Suponemos que TeatroHandler tiene un método getFunciones()
        List<Funcion> funciones = TeatroHandler.getInstance().getFunciones();
        view.mostrarFunciones(funciones);
    }

    public void comprarEntrada(int idFuncion, int idAsiento) {
        TeatroHandler.getInstance().ocuparAsiento(idAsiento);
        view.mostrarMensaje("Entrada comprada con éxito para la función " + idFuncion);
    }

    public void mostrarAsientosLibres(int idFuncion) {
        List<Asiento> asientosLibres = TeatroHandler.getInstance().asientosLibres(idFuncion);//hace falta ingresar la funcion para ver los asientos disponiblesd e cada funcion? porque en en handler/Teatro no lo pide el metodo como parametro
        view.mostrarAsientos(asientosLibres);
    }
}
