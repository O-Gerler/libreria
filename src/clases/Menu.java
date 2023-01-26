package clases;

public class Menu {
	public static void mostrarMenuPrincipal() {
		final int GESTIONAR_LIBROS = 1;
		final int GESTIONAR_SOCIOS = 2;
		final int GESTIONAR_PRESTAMOS = 3;
		
		System.out.println("---------------MENU-PRINCIPAL---------------");
		System.out.println(GESTIONAR_LIBROS  + ".- Gestionar libros");
		System.out.println(GESTIONAR_SOCIOS  + ".- Gestionar socios");
		System.out.println(GESTIONAR_PRESTAMOS  + ".- Gestionar prestamos");
	}
	
	public static void mostrarMenuLibros() {
		final int INSERTAR_LIBRO = 1;
		final int ELIMINAR_LIBRO = 2;
		final int VER_LIBROS = 3;
		
		System.out.println("---------------MENU-LIBROS---------------");
		System.out.println(INSERTAR_LIBRO  + ".- Insertar libro");
		System.out.println(ELIMINAR_LIBRO  + ".- Eliminar libro");
		System.out.println(VER_LIBROS  + ".- Ver libros");
	}
	
	public static void mostrarMenuSocios() {
		final int VER_SOCIOS = 1;
		
		System.out.println("---------------MENU-SOCIOS---------------");
		System.out.println(VER_SOCIOS  + ".- Ver socios");
	}
}
