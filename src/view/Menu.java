package view;

import java.util.Scanner;

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

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    1. Usuario
                    2. Administrador
                    3. Cerrar sesión
                    """);

            int opcion = pedirOpcion(scanner, 1, 3);

            switch (opcion) {
                case 1 -> mostrarMenuUsuario();
                case 2 -> mostrarMenuAdmin();
                case 3 -> {
                    System.out.println("Cerrando sesión...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    1. Ver funciones disponibles
                    2. Comprar entrada
                    3. Volver
                    """);

            int opcion = pedirOpcion(scanner, 1, 3);

            switch (opcion) {
                case 1 -> verFuncionesDisponibles();
                case 2 -> comprarEntrada();
                case 3 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuAdmin() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    1. Agregar función
                    2. Mostrar tickets vendidos
                    3. Asignar grupo a función
                    4. Volver
                    """);

            int opcion = pedirOpcion(scanner, 1, 4);

            switch (opcion) {
                case 1 -> agregarFuncion();
                case 2 -> mostrarTicketsVendidos();
                case 3 -> asignarGrupoFuncion();
                case 4 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private int pedirOpcion(Scanner scanner, int min, int max) {
        int opcion = -1;
        do {
            try {
                System.out.print("Ingrese una opción: ");
                opcion = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar buffer
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    private void verFuncionesDisponibles() {
        // Llamada al controlador para obtener las funciones disponibles
        // Ejemplo: TeatroController.getInstance().listarFunciones();

        System.out.println("Mostrando lista de funciones disponibles...");
        // Aquí se mostrarían las funciones disponibles
    }

    private void comprarEntrada() {
        // Llamada al controlador para comprar entrada
        // Ejemplo: TeatroController.getInstance().comprarEntrada();

        System.out.println("Proceso de compra de entrada...");
        // Aquí se implementaría el flujo de compra
    }

    private void agregarFuncion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la función: ");
        String nombre = scanner.nextLine();

        int duracion;
        do {
            System.out.print("Ingrese la duración de la función (minutos): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                scanner.next(); // Limpiar entrada inválida
            }
            duracion = scanner.nextInt();
        } while (duracion <= 0);

        System.out.print("Ingrese el nombre del grupo asignado a la función: ");
        String grupo = scanner.next();

        // Llamada al controlador para agregar la función
        // Ejemplo: TeatroController.getInstance().agregarFuncion(nombre, duracion, grupo);

        System.out.println("Función agregada con éxito.");
    }

    private void mostrarTicketsVendidos() {
        // Llamada al controlador para mostrar los tickets vendidos
        // Ejemplo: TeatroController.getInstance().mostrarTicketsVendidos();

        System.out.println("Mostrando tickets vendidos...");
    }

    private void asignarGrupoFuncion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la función: ");
        String nombreFuncion = scanner.nextLine();

        System.out.print("Ingrese el nombre del grupo: ");
        String nombreGrupo = scanner.nextLine();

        // Llamada al controlador para asignar el grupo a la función
        // Ejemplo: TeatroController.getInstance().asignarGrupo(nombreFuncion, nombreGrupo);

        System.out.println("Grupo asignado con éxito.");
    }
}


