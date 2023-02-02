package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	private static String pedirDNISocio(Scanner scan) {
		System.out.println("DNI del socio: ");
		String dni = scan.nextLine();
		return dni;
	}

	private static String pedirProvinciaSocio(Scanner scan) {
		System.out.println("Provincia del socio: ");
		String provincia = scan.nextLine();
		return provincia;
	}

	private static String pedirPoblacionSocio(Scanner scan) {
		System.out.println("Poblacion del socio: ");
		String poblacion = scan.nextLine();
		return poblacion;
	}

	private static String pedirDireccionSocio(Scanner scan) {
		System.out.println("Direccion del socio: ");
		String direccion = scan.nextLine();
		return direccion;
	}

	private static String pedirApellidoSocio(Scanner scan) {
		System.out.println("Apellido del socio: ");
		String apellido = scan.nextLine();
		return apellido;
	}

	private static String pedirNombreSocio(Scanner scan) {
		System.out.println("Nombre del socio: ");
		String nombre = scan.nextLine();
		return nombre;
	}
	
	public static Socio pedirDatosSocio(Scanner scan) {
		String nombre = pedirNombreSocio(scan);
		String apellido = pedirApellidoSocio(scan);
		String direccion = pedirDireccionSocio(scan);
		String poblacion = pedirPoblacionSocio(scan);
		String provincia = pedirProvinciaSocio(scan);
		String dni = pedirDNISocio(scan);
		
		
		Socio socio = new Socio();
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		return socio;
	}
	
	public static Socio modificarSocio(Socio socio, Scanner scan) {
		System.out.println("Datos actuales: ");
		System.out.println(socio);
		
		String nombre = pedirNombreSocio(scan);
		String apellido = pedirApellidoSocio(scan);
		String direccion = pedirDireccionSocio(scan);
		String poblacion = pedirPoblacionSocio(scan);
		String provincia = pedirProvinciaSocio(scan);
		String dni = pedirDNISocio(scan);
		
		socio.setNombre(nombre);
		socio.setApellido(apellido);
		socio.setDireccion(direccion);
		socio.setPoblacion(poblacion);
		socio.setProvincia(provincia);
		socio.setDni(dni);
		
		return socio;
	}
	
	public static int pedirIDSocio(Scanner scan) {
		System.out.println("Introduce el ID del socio");
		int id = Integer.parseInt(scan.nextLine());
		
		return id;
	}
	
	/*--------------------------------------PRESTAMOS-------------------------------------------------*/
	private static Date pedirFecha(Scanner scan) {
		System.out.print("Introduce la fecha (yyyy/mm/dd): ");
		Date fecha = null;
		try {
			fecha = new SimpleDateFormat("yyyy/MM/dd").parse(scan.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}

	private static int pedirIdSocio(Scanner scan) {
		System.out.print("Introduce el id de socio: ");
		int idSocio = Integer.parseInt(scan.nextLine());
		return idSocio;
	}

	private static int pedirIdLibro(Scanner scan) {
		System.out.print("Introduce el id de libro: ");
		int idLibro = Integer.parseInt(scan.nextLine());
		return idLibro;
	}
	
	public static Prestamos pedirDatosPrestamos(Scanner scan) {
		int idLibro = pedirIdLibro(scan);
		int idSocio = pedirIdSocio(scan);
		Date fecha = pedirFecha(scan);
		
		Prestamos prestamo = new Prestamos();
		
		prestamo.setIdLibro(idLibro);
		prestamo.setIdSocio(idSocio);
		prestamo.setFecha(fecha);
		
		return prestamo;
	}


	public static boolean existePrestamo(Prestamos prestamo, GestorBBDD gestorBBDD) {
		
		ArrayList<Prestamos> prestamos = gestorBBDD.getPrestamos();
		
		for (Prestamos prest : prestamos) {
			if (prest.getIdLibro() == prestamo.getIdLibro() 
					&& prest.getIdSocio() == prestamo.getIdSocio() 
					&& prest.getFecha().equals(prestamo.getFecha())) {
				return true;
			}
		}
		
		
		return false;
	}
}
