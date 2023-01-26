package clases;

import java.sql.PreparedStatement;

public class GestorBBDD extends Conector {

	public void insertarLibro(Libro libro) {
		try {
			PreparedStatement pst = super.connection
					.prepareStatement("INSERT INTO libros (titulo,autor,num_pag) VALUES (?,?,?)");
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getAutor());
			pst.setInt(3, libro.getNumPaginas());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarLibro(int id) {
		try {
			PreparedStatement pst = super.connection
					.prepareStatement("DELETE FROM libros WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
