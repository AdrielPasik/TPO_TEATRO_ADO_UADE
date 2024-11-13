package view;

import controller.TeatroAdminController;
import controller.TeatroUserController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private static Menu instance;
    private TeatroUserController teatroUserController;
    private TeatroAdminController teatroAdminController;

    private Menu() {
        teatroUserController = new TeatroUserController();
        teatroAdminController = new TeatroAdminController();
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
                    \n1. Usuario
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
                    \n1. Ver funciones disponibles
                    2. Ver Asientos disponibles
                    3. Seleccionar entrada
                    4. Pagar
                    5. Volver
                    """);

            int opcion = pedirOpcion(scanner, 1, 5);

            switch (opcion) {
                case 1 -> verFuncionesDisponibles();
                case 2 -> asientosDisponible();
                case 3 -> seleccionarEntrada();
                case 4 -> pagar();
                case 5 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuAdmin() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("""
                    \n1. Agregar función
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
        System.out.println("Mostrando lista de funciones disponibles...");

        List<FuncionView> a =  teatroUserController.mostrarFunciones();

        System.out.println(a);

    }

    private void asientosDisponible() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa id de la funcion:");
        int idFuncionn = scanner.nextInt();
        System.out.println("Lista de asientos disponibles...");
        List<AsientoView> asientosLibres =  teatroUserController.mostrarAsientosLibres(idFuncionn);
        for (AsientoView asiento : asientosLibres) {
            System.out.println(asiento);
        }
    }

    private void seleccionarEntrada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id de la funcion que desea comprar:");
        int idFuncionn = scanner.nextInt();
        System.out.print("Ingrese el id del asiento desea comprar:");
        int idAsiento = scanner.nextInt();

        while (!teatroUserController.seleccionarEntrada(idFuncionn, idAsiento)){
            System.out.println("El asiento no existe o ya esta seleccionado/ocupado");
            System.out.print("Ingrese el id de la funcion que desea comprar:");
            idFuncionn = scanner.nextInt();
            System.out.print("Ingrese el id del asiento desea comprar:");
            idAsiento = scanner.nextInt();
        }
        System.out.println("Asiento seleccionado");
    }

    private void pagar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su DNI: ");
        int dni = scanner.nextInt();
        System.out.println("Eliga su medio de pago");
        System.out.println("""
                    1. EFECTIVO
                    2. DEBITO
                    3. CREDITO
                    """);
        int idMedioPago = pedirOpcion(scanner, 1, 3);

        int cantCuotas = 0;
        if(idMedioPago == 3){
            System.out.print("Eliga la cantidad de cuotas (2,3,6) :");
            cantCuotas = scanner.nextInt();
            }

        System.out.println("------------Tiket Generado---------------");
        System.out.println(teatroUserController.generarTicket(dni,idMedioPago,cantCuotas));
        System.out.println("-----------------------------------------");
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
        scanner.nextLine();

        // Pedir la fecha y hora de la función
        LocalDateTime fechaHora = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        do {
            System.out.print("Ingrese la fecha y hora de la función (formato: dd/MM/yyyy HH:mm): ");
            String fechaHoraStr = scanner.nextLine();
            try {
                fechaHora = LocalDateTime.parse(fechaHoraStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha y hora incorrecto. Intente de nuevo.");
            }
        } while (fechaHora == null);

        double precio;
        do {
            System.out.print("Ingrese el precio de la función: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Debe ingresar un número válido.");
                scanner.next(); // Limpiar entrada inválida
            }
            precio = scanner.nextDouble();
        } while (precio <= 0);

        teatroAdminController.addFuncion(fechaHora,duracion,precio,nombre);

        System.out.println("Función agregada con éxito.");
    }

    private void mostrarTicketsVendidos() {
        System.out.println("---------------------Tickets vendidos-------------------");
        System.out.println(teatroAdminController.getListaTicket());
    }

    private void asignarGrupoFuncion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(teatroAdminController.getListaFuncion());
        System.out.print("Ingrese el id de la función: ");
        int idFuncion = scanner.nextInt();

        System.out.println(teatroAdminController.getListaGrupos());

        System.out.print("Ingrese el id del grupo: ");
        int idGrupo = scanner.nextInt();

        teatroAdminController.asignarGrupoAFuncion(idGrupo,idFuncion);

        System.out.println("Grupo asignado con éxito.");
    }
}


