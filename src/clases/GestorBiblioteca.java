package clases;

import java.util.Scanner;

public class GestorBiblioteca {

	public void run() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			Menu.mostrarMenuPrincipal();
			opcion = seleccionarOpcion(scan);

			switch (opcion) {
			case Menu.GESTIONAR_LIBROS:
				System.out.println("Gestionar libros");
				break;
			case Menu.GESTIONAR_SOCIOS:
				System.out.println("Gestionar sociso");
				break;
			case Menu.GESTIONAR_PRESTAMOS:
				System.out.println("Gestionar prestamos");
				break;
			case Menu.GESTIONAR_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion != Menu.GESTIONAR_SALIR);
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
