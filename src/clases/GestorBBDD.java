package clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			PreparedStatement pst = super.connection.prepareStatement("DELETE FROM libros WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Libro getLibro(int id) {
		
		Libro libro = null;
		
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT FROM libros WHERE id=?");
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
	
	public ArrayList<Libro> getTodosLosLibros() {
		ArrayList<Libro> libros = new ArrayList<>();
			
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT * FROM libros");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				libros.add(getLibro(rs.getInt("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return libros;
	}
	
	/*-------------------------SOCIOS-------------------------*/
	
	public void insertarSocios(Socios socio) {
		try {
			PreparedStatement pst = super.connection
					.prepareStatement("INSERT INTO libros (nombre,apellido,direccion,poblacion,provincia,dni) "
							+ "VALUES (?,?,?,?,?,?)");
			pst.setString(1, socio.getNombre());
			pst.setString(2, socio.getApellido());
			pst.setString(1, socio.getDireccion());
			pst.setString(2, socio.getPoblacion());
			pst.setString(1, socio.getProvincia());
			pst.setString(2, socio.getDni());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarLibro(int id) {
		try {
			PreparedStatement pst = super.connection.prepareStatement("DELETE FROM libros WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Libro getLibro(int id) {
		
		Libro libro = null;
		
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT FROM libros WHERE id=?");
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
	
	public ArrayList<Libro> getTodosLosLibros() {
		ArrayList<Libro> libros = new ArrayList<>();
			
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT * FROM libros");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				libros.add(getLibro(rs.getInt("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return libros;
	}
}
