package com.agendacontactos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Agenda de Contactos ---");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    System.out.println("Contacto agregado.");
                    break;
                case 2:
                    agenda.mostrarContactos();
                    break;
                case 3:
                    System.out.print("Nombre a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    Contacto contactoEncontrado = agenda.buscarContacto(nombreBusqueda);
                    if (contactoEncontrado != null) {
                        System.out.println("Contacto encontrado: " + contactoEncontrado);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    if (agenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}