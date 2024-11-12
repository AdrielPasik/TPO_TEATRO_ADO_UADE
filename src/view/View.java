package view;

public class View {

    private static View instance;

    private View() {

    }

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
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

