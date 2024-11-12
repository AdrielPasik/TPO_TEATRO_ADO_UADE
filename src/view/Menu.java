package view;

public class Menu {

    private static Menu instance;

    private Menu() {

    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }



    // pattern matching
    /*public void mostrarMenu() {
        Opcion opcion = pedirOpcion();
        if (opcion == Opcion.DAR_DE_ALTA_ESPECTACULO) {
            darDeAltaEspectaculo();
        } else if (opcion == Opcion.BLAH) {
            // TODO
        } else if (opcion == Opcion.SALIR) {
            return;
        }
    }*/
}

