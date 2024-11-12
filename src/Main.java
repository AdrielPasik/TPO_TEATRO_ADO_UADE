import entity.TeatroHandler;
import view.Menu;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        cargarDatos();
        Menu.getInstance().mostrarMenuPrincipal();
    }

    public static void cargarDatos(){
        TeatroHandler.getInstance().addFuncion(new Date(),"54545",45454,454545,"afafaf");
    }
}