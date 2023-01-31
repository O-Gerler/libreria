package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorLibros {

	public void run(Scanner scan) {
		int opcion;
		Libro libro = null;
		GestorBBDD gestorBBDD = new GestorBBDD();
		
		do {
			Menu.mostrarMenuLibros();
			opcion = seleccionarOpcion(scan);

			switch (opcion) {
			case Menu.INSERTAR_LIBRO:
				insertarLibro(scan, gestorBBDD);
				break;
			case Menu.ELIMINAR_LIBRO:
				eliminarLibro(scan, gestorBBDD);
				break;
			case Menu.VER_LIBROS:
				verLibros(gestorBBDD);
				break;
			case Menu.LIBROS_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion incorrecta!");
			}

		} while (opcion != Menu.LIBROS_SALIR);
	}

	private void verLibros(GestorBBDD gestorBBDD) {
		gestorBBDD.conectar();
		ArrayList<Libro> libros = gestorBBDD.getTodosLosLibros();
		Visor.mostrarLibros(libros);
	}

	private void eliminarLibro(Scanner scan, GestorBBDD gestorBBDD) {
		int id = FormularioDeDatos.pedirIDLibro(scan);
		gestorBBDD.conectar();
		gestorBBDD.eliminarLibro(id);
		gestorBBDD.cerrar();
	}

	private void insertarLibro(Scanner scan, GestorBBDD gestorBBDD) {
		Libro libro;
		libro = FormularioDeDatos.pedirDatosLibro(scan);
		gestorBBDD.conectar();
		gestorBBDD.insertarLibro(libro);
		gestorBBDD.cerrar();
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
