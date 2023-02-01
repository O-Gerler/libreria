package clases;

public class Menu {
	
	static final int GESTIONAR_LIBROS = 1;
	static final int GESTIONAR_SOCIOS = 2;
	static final int GESTIONAR_PRESTAMOS = 3;
	static final int GESTIONAR_SALIR = 0;
	
	static final int INSERTAR_LIBRO = 1;
	static final int ELIMINAR_LIBRO = 2;
	static final int MODIFICAR_LIBRO = 3;
	static final int VER_LIBROS = 4;
	static final int LIBROS_SALIR = 0;
	
	static final int INSERTAR_SOCIOS = 1;
	static final int ELIMINAR_SOCIOS = 2;
	static final int MODIFICAR_SOCIOS = 3;
	static final int VER_SOCIOS = 4;
	static final int SOCIOS_SALIR = 0;
	
	static final int REALIZAR_PRESTAMO = 1;
	static final int PRESTAMOS_SALIR = 1;
	
	public static void mostrarMenuPrincipal() {
		
		
		System.out.println("---------------MENU-PRINCIPAL---------------");
		System.out.println(GESTIONAR_LIBROS  + ".- Gestionar libros");
		System.out.println(GESTIONAR_SOCIOS  + ".- Gestionar socios");
		System.out.println(GESTIONAR_PRESTAMOS  + ".- Gestionar prestamos");
		System.out.println(GESTIONAR_SALIR + ".-Salir ");
	}
	
	public static void mostrarMenuLibros() {
		
		
		System.out.println("---------------MENU-LIBROS---------------");
		System.out.println(INSERTAR_LIBRO  + ".- Insertar libro");
		System.out.println(ELIMINAR_LIBRO  + ".- Eliminar libro");
		System.out.println(MODIFICAR_LIBRO  + ".- Modificar libro");
		System.out.println(VER_LIBROS  + ".- Ver libros");
		System.out.println(LIBROS_SALIR + ".-Salir ");
	}
	
	public static void mostrarMenuSocios() {
		
		
		System.out.println("---------------MENU-SOCIOS---------------");
		System.out.println(INSERTAR_SOCIOS  + ".- Insertar socios");
		System.out.println(ELIMINAR_SOCIOS  + ".- Eliminar socios");
		System.out.println(MODIFICAR_SOCIOS  + ".- Modificar socios");
		System.out.println(VER_SOCIOS  + ".- Ver socios");
		System.out.println(SOCIOS_SALIR + ".-Salir ");
	}
	
	public static void mostrarMenuPrestamos() {
		
		
		System.out.println("---------------MENU-PRESTAMOS---------------");
		System.out.println(REALIZAR_PRESTAMO  + ".- Realizar prestamo");
		System.out.println(PRESTAMOS_SALIR + ".-Salir ");
	}
}
