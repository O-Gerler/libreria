package clases;

public class Menu {
	public static void mostrarMenuPrincipal() {
		final int GESTIONAR_LIBROS = 1;
		final int GESTIONAR_SOCIOS = 1;
		final int GESTIONAR_PRESTAMOS = 1;
		
		System.out.println("---------------MENU-PRINCIPAL---------------");
		System.out.println(GESTIONAR_LIBROS  + ".- Gestionar libros");
		System.out.println(GESTIONAR_SOCIOS  + ".- Gestionar socios");
		System.out.println(GESTIONAR_PRESTAMOS  + ".- Gestionar prestamos");
	}
}
