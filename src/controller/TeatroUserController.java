package controller;

import entity.*;
import entity.TeatroHandler;
import view.FuncionView;

import java.util.ArrayList;
import java.util.List;

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

    /*public void comprarEntrada(int DNIComprador, MedioDePago medioDePago, int idFuncion, int idAsiento) {
    TeatroHandler handler = TeatroHandler.getInstance();
    handler.ocuparAsiento(idFuncion, idAsiento);
    Ticket ticket = handler.generarTicket(DNIComprador, medioDePago, idFuncion, idAsiento);
    }*/

    /*public void mostrarAsientosLibres(int idFuncion) {
        List<Asiento> asientosLibres = TeatroHandler.getInstance().asientosLibres(idFuncion);//hace falta ingresar la funcion para ver los asientos disponiblesd e cada funcion? porque en en handler/Teatro no lo pide el metodo como parametro
        //view.mostrarAsientos(asientosLibres);
    }*/

}
