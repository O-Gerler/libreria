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
			PreparedStatement pst = super.connection.prepareStatement("SELECT * FROM libros WHERE id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
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
	
	public void insertarSocios(Socio socio) {
		try {
			PreparedStatement pst = super.connection
					.prepareStatement("INSERT INTO socios (nombre,apellido,direccion,poblacion,provincia,dni) "
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
	
	public void eliminarSocio(int id) {
		try {
			PreparedStatement pst = super.connection.prepareStatement("DELETE FROM socios WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Socio getSocios(int id) {
		
		Socio socio = null;
		
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT * FROM socios WHERE id=?");
			pst.setInt(1, id);
			ResultSet rSet = pst.executeQuery();
			rSet.next();
			socio = new Socio();
			socio.setId(rSet.getInt("id"));
			socio.setNombre(rSet.getString("nombre"));
			socio.setApellido(rSet.getString("apellido"));
			socio.setDireccion(rSet.getString("direccion"));
			socio.setPoblacion(rSet.getString("poblacion"));
			socio.setProvincia(rSet.getString("provincia"));
			socio.setDni(rSet.getString("dni"));
			rSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return socio;
	}
	
	public ArrayList<Socio> getTodosLosSocios() {
		ArrayList<Socio> socios = new ArrayList<>();
			
		try {
			PreparedStatement pst = super.connection.prepareStatement("SELECT * FROM socios");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				socios.add(getSocios(rs.getInt("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return socios;
	}
}
