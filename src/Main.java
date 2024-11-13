import entity.TeatroHandler;
import view.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        cargarDatos();
        Menu.getInstance().mostrarMenuPrincipal();
    }

    public static void cargarDatos(){
        String fechaStr = "2024-11-13 14:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime fecha = LocalDateTime.parse(fechaStr, formatter);
        //agregar funciones
        TeatroHandler.getInstance().addFuncion(fecha, 120, 1000, "El Chaplin");
        //agregar grupos
        TeatroHandler.getInstance().agregarGrupo("Los pibes", "Detalle");
        TeatroHandler.getInstance().asignarGrupoAFuncion(0,0);
    }
}