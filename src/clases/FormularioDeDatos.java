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
}
