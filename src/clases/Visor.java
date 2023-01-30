package clases;

import java.util.ArrayList;

public class Visor {
	
	public static void mostrarLibros(ArrayList<Libro> libros) {
		for (Libro libro : libros) {
			System.out.println(libro);
		}
	}

}
