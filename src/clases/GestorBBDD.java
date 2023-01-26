package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public Libro getLibro(int id) {
		
		Libro libro = null;
		
		try {
			PreparedStatement pst = super.connection
					.prepareStatement("SELECT FROM libros WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			libro = new Libro();
			libro.setId(rs.getInt("id"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setAutor(rs.getString("autor"));
			libro.setNumPaginas(rs.getInt("num_pag"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return libro;
	}
}
