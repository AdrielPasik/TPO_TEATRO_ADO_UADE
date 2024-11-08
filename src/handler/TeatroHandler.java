package handler;

import entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeatroHandler {

    private static TeatroHandler instance;
    private Teatro teatro;
    private static int grupoContador = 0;
    private static int funcionContador = 0;

    public static TeatroHandler getInstance() {
        if (instance == null) {
            instance = new TeatroHandler();
        }
        return instance;
    }

    private TeatroHandler() {
        this.teatro = new Teatro("TEATRO COLON", "AV.CORRIENTES 2433, CABA", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
    }

    public void agregarGrupo(String nombre, String detalle){
        this.teatro.agregarGrupo(new Grupo(getNextIdGrupo(), nombre, detalle));
    }

    public void asignarGrupoAFuncion(int idGrupo, int idFuncion){

    }

    public void addFuncion(Date fecha, String horaInicio, int duracion, double precio,String nombre){
        Funcion f = new Funcion(this.getNextIdFuncion(),horaInicio,nombre,duracion,precio,new ArrayList<>());
        teatro.agregarFuncion(f);
    }

    public List<Asiento> asientosLibres(){
        return teatro.getAsientosDesocupados();
    }

    public void ocuparAsiento(int idAsiento){
        teatro.getAsientoById(idAsiento).ocupar();
    }

    public void setAsientoFuncion(Funcion funcion) {
        for(int i = 0; i<20;i++){
            //PODEMOS IMPLEMENTAR PROTOTYPE O HACER VARIOS BUCLES. HAY QUE DECIDIR
        }
    }



    private int getNextIdGrupo(){
        return grupoContador++;
    }

    private int getNextIdFuncion(){
        return funcionContador++;
    }
}
