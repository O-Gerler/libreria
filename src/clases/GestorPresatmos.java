package clases;

import java.util.Scanner;

public class GestorPresatmos {
	
	public void run(Scanner scan) {
		int opcion;
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		do {
			Menu.mostrarMenuLibros();
			opcion = seleccionarOpcion(scan);

			switch (opcion) {
			case Menu.REALIZAR_PRESTAMO:
				System.out.println("Insertar prestamo");
				break;
			case Menu.ELIMINAR_PRESTAMO:
				System.out.println("Eliminar prestamo");
				break;
			//case Menu.MODIFICAR_LIBRO:
				/*no esta*/
			//	break;
			case Menu.VER_PRESTAMO:
				System.out.println("Ver prestamos");
				break;
			case Menu.PRESTAMOS_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion != Menu.PRESTAMOS_SALIR);
	}
	
	private static int seleccionarOpcion(Scanner scan) {
		int opcion;
		
		try {
			System.out.print("Introduce la opcion: ");
			opcion = Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			opcion = -1;
		}
		
		return opcion;
	}
}
