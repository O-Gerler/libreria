package clases;

import java.util.Scanner;

public class GestorLibros {

	public void run(Scanner scan) {
		int opcion;
		Libro libro = null;
		GestorBBDD gestorBBDD = null;
		
		do {
			Menu.mostrarMenuLibros();
			opcion = seleccionarOpcion(scan);

			switch (opcion) {
			case Menu.INSERTAR_LIBRO:
				System.out.println("Insertar libro");
				libro = FormularioDeDatos.pedirDatosLibro(scan);
				gestorBBDD = new GestorBBDD();
				gestorBBDD.conectar();
				gestorBBDD.insertarLibro(libro);
				gestorBBDD.cerrar();
				break;
			case Menu.ELIMINAR_LIBRO:
				System.out.println("Eliminar libro");
				int id = FormularioDeDatos.pedirIDLibro(scan);
				gestorBBDD.conectar();
				gestorBBDD.eliminarLibro(id);
				gestorBBDD.cerrar();
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
