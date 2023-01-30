package clases;

import java.util.Scanner;

public class FormularioDeDatos {

	public static Libro pedirDatosLibro(Scanner scan) {
		System.out.println("Introduce el titulo de el libro");
		String titulo = scan.nextLine();
		System.out.println("Introduce el autor de el libro");
		String autor = scan.nextLine();
		System.out.println("Introduce el numero de paginas del libro");
		int numPaginas = Integer.parseInt(scan.nextLine());
		
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setAutor(autor);
		libro.setNumPaginas(numPaginas);
		
		return libro;
	}
}
