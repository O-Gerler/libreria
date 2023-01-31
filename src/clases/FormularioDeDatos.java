package clases;

import java.util.Scanner;

public class FormularioDeDatos {
	
	private static int pedirNumPaginasLibro(Scanner scan) {
		System.out.println("Introduce el numero de paginas del libro");
		int numPaginas = Integer.parseInt(scan.nextLine());
		return numPaginas;
	}

	private static String pedirAutorLibro(Scanner scan) {
		System.out.println("Introduce el autor de el libro");
		String autor = scan.nextLine();
		return autor;
	}

	private static String pedirTituloLibro(Scanner scan) {
		System.out.println("Introduce el titulo de el libro");
		String titulo = scan.nextLine();
		return titulo;
	}

	public static Libro pedirDatosLibro(Scanner scan) {
		String titulo = pedirTituloLibro(scan);
		String autor = pedirAutorLibro(scan);
		int numPaginas = pedirNumPaginasLibro(scan);
		
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNumPaginas(numPaginas);
		
		return libro;
	}

	public static Libro modificarDatosLibro(Libro libro, Scanner scan) {
		System.out.println("Datos actuales:");
		System.out.println(libro);
		
		String titulo = pedirTituloLibro(scan);
		String autor = pedirAutorLibro(scan);
		int numPaginas = pedirNumPaginasLibro(scan);
		
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNumPaginas(numPaginas);
		
		return libro;
	}
	
	public static int pedirIDLibro(Scanner scan) {
		System.out.println("Introduce el ID del libro");
		int id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
	
	/*------------------------------PEDIR DATOS SOCIOS---------------------------*/
	public static Socios pedirDatosSocio(Scanner scan) {
		System.out.println("Nombre del socio: ");
		String nombre = scan.nextLine();
		System.out.println("Apellido del socio: ");
		String apellido = scan.nextLine();
		System.out.println("Direccion del socio: ");
		String direccion = scan.nextLine();
		System.out.println("Poblacion del socio: ");
		String poblacion = scan.nextLine();
		System.out.println("Provincia del socio: ");
		String provincia = scan.nextLine();
		System.out.println("DNI del socio: ");
		String dni = scan.nextLine();
		
		
		Socios socio = new Socios();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		return socio;
	}
}
