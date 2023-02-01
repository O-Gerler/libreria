package clases;

import java.util.Scanner;

public class GestorSocios {

	public static void run(Scanner scan) {
		int opcion;
		GestorBBDD gestorBBDD = new GestorBBDD();
		do {
			Menu.mostrarMenuSocios();
			opcion = seleccionarOpcion(scan);
			switch(opcion) {
			case Menu.INSERTAR_SOCIOS:
				insertarSocio(scan, gestorBBDD);
				break;
			case Menu.ELIMINAR_SOCIOS:
				eliminarSocio(scan, gestorBBDD);
				break;
			case Menu.MODIFICAR_SOCIOS:
				modificarSocio(scan, gestorBBDD);
				break;
			case Menu.VER_SOCIOS:
				verSocios(gestorBBDD);
				break;
			case Menu.SOCIOS_SALIR:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion invalida!");
			}
		} while (opcion == Menu.SOCIOS_SALIR);
	}

	private static void modificarSocio(Scanner scan, GestorBBDD gestorBBDD) {
		gestorBBDD.conectar();
		int id = FormularioDeDatos.pedirIDSocio(scan);
		Socio socio = gestorBBDD.getSocios(id);
		socio = FormularioDeDatos.modificarSocio(socio, scan);
		gestorBBDD.modificarSocio(socio);
		gestorBBDD.cerrar();
	}

	private static void verSocios(GestorBBDD gestorBBDD) {
		gestorBBDD.conectar();
		Visor.mostrarSocios(gestorBBDD.getTodosLosSocios());
		gestorBBDD.cerrar();
	}

	private static void eliminarSocio(Scanner scan, GestorBBDD gestorBBDD) {
		gestorBBDD.conectar();
		int id = FormularioDeDatos.pedirIDSocio(scan);
		gestorBBDD.eliminarSocio(id);
		gestorBBDD.cerrar();
	}

	private static void insertarSocio(Scanner scan, GestorBBDD gestorBBDD) {
		gestorBBDD.conectar();
		Socio socio = FormularioDeDatos.pedirDatosSocio(scan);
		gestorBBDD.insertarSocios(socio);
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
