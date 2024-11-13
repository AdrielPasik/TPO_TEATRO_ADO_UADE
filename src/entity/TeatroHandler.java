package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeatroHandler {

    private static TeatroHandler instance;
    private Teatro teatro;
    private List<ItemFactura> cache;
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
        this.cache = new ArrayList<>();
    }

    public void agregarGrupo(String nombre, String detalle){
        this.teatro.agregarGrupo(new Grupo(getNextIdGrupo(), nombre, detalle));
    }

    public void asignarGrupoAFuncion(int idGrupo, int idFuncion){
        Grupo grupo = teatro.getGrupoById(idGrupo);
        Funcion funcion = teatro.getFuncionByid(idFuncion);
        funcion.setGrupo(grupo);

    }

    public void addFuncion(LocalDateTime horaInicio, int duracion, double precio, String nombre){
        Funcion f = new Funcion(this.getNextIdFuncion(),horaInicio,nombre,duracion,precio,new ArrayList<>(),null);
        this.setAsientoFuncion(f);
        teatro.agregarFuncion(f);
    }

    public boolean selecionarEntrada(int idFuncion, int idAsiento){

        boolean resultado;
        for(ItemFactura item: this.cache){
            if (item.getFuncion().getId() == idFuncion && item.getIdAsiento() == idAsiento) {
                resultado = false;
                break;
            }
        }
        Funcion funcion = this.getFuncionByid(idFuncion);
        resultado = funcion.estaLibre(idAsiento);

        this.cache.add(new ItemFactura(idAsiento, funcion));

        return resultado;
    }

    public List<Asiento> asientosLibres(){
        return teatro.getAsientosDesocupados();
    }

    public void setAsientoFuncion(Funcion funcion) {
        List<Asiento> asientos = new ArrayList<>();
        int idAsiento = 0; // Para dar un identificador único a cada asiento.
        int totalAsientos = 18; // Total de asientos a asignar.
        // Definimos cuántos asientos queremos por cada zona.
        int asientosPorZona = totalAsientos / 6; // Dividimos el total en las 6 zonas disponibles.

        // Creamos y asignamos asientos para cada zona.
        for (int i = 0; i < asientosPorZona; i++) {
            asientos.add(new Asiento(idAsiento++, new Platea(), true));
            asientos.add(new Asiento(idAsiento++, new Cazuela(), true));
            asientos.add(new Asiento(idAsiento++, new PalcoAlto(), true));
            asientos.add(new Asiento(idAsiento++, new PalcoBajo(), true));
            asientos.add(new Asiento(idAsiento++, new Paraiso(), true));
            asientos.add(new Asiento(idAsiento++, new Tertulia(), true));
        }
        // Asignamos los asientos creados a la función.
        funcion.setAsientos(asientos);
    }

   public Ticket generarTicket(int DNIComprador, int idMediopago, int cantCuota) {
        
        MedioDePago medioDePago = null;

        switch (idMediopago) {
            case 1 -> medioDePago = new Efectivo();
            case 2 -> medioDePago = new Debito();
            case 3 -> medioDePago = new Credito(cantCuota);
            default -> {
            }
        }

       Ticket ticket = new Ticket(DNIComprador, medioDePago, this.cache);

       //Ocupar Asientos
       for (ItemFactura item : this.cache) {
           this.ocuparAsiento(item.getFuncion().getId(), item.getIdAsiento());
       }

       this.cache.clear();

        return ticket;
    }

    public void ocuparAsiento(int idFuncion, int idAsiento){
        Funcion funcion = teatro.getFuncionByid(idFuncion);
        funcion.ocuparAsiento(idAsiento);
    }

    public List<Funcion> getFunciones(){
        return teatro.getFunciones();
    }

    public List<Ticket> getTickets() {
        return null;
    }

    private int getNextIdGrupo(){
        return grupoContador++;
    }

    private int getNextIdFuncion(){
        return funcionContador++;
    }

    public List<Grupo> getGrupos() {
        return teatro.getGrupos();
    }

    public Funcion getFuncionByid(int idFuncion) {
        return teatro.getFuncionByid(idFuncion);
    }
}
