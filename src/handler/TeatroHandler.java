package handler;

import entity.Grupo;
import entity.Teatro;

import java.util.ArrayList;

public class TeatroHandler {

    private static TeatroHandler instance;
    private Teatro teatro;
    private static int grupoContador = 0;

    public static TeatroHandler getInstance() {
        if (instance == null) {
            instance = new TeatroHandler();
        }
        return instance;
    }

    private TeatroHandler() {
        this.teatro = new Teatro("TEATRO COLON", "AV.CORRIENTES 2433, CABA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public void addGrupo(String nombre, String detalle){
        this.teatro.getGurpos().add(new Grupo(getNextIdGrupo(),nombre, detalle));
    }

    //public void addFuncion

    private int getNextIdGrupo(){
        return grupoContador++;
    }
}
