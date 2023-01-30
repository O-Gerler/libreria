package clases;

import java.util.Scanner;

public class GestorLibros {

	public void run(Scanner scan) {
		int opcion;
		
		do {
			Menu.mostrarMenuLibros();
			opcion = seleccionarOpcion(scan);

			switch (opcion) {
			case Menu.INSERTAR_LIBRO:
				System.out.println("Insertar libro");
				break;
			case Menu.ELIMINAR_LIBRO:
				System.out.println("Eliminar libro");
				break;
			case Menu.VER_LIBROS:
				System.out.println("Ver libros");
				break;
			case Menu.LIBROS_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion != Menu.LIBROS_SALIR);
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
