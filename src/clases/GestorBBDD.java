package clases;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void modificarLibro(Libro libro) {
		String st = "UPDATE libros SET titulo = ? , autor = ?, num_pag = ? WHERE libros.id = ?";
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			pst.setString(1, libro.getTitulo());
			pst.setString(2, libro.getTitulo());
			pst.setInt(3, libro.getNumPaginas());
			pst.setInt(4, libro.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void modificarSocio(Socio socio) {
		String st = "UPDATE socios SET nombre=?,apellido=?,direccion=?,poblacion=?,provincia=?,dni=? WHERE socios.id = ?; ";
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			pst.setString(1, socio.getNombre());
			pst.setString(2, socio.getApellido());
			pst.setString(3, socio.getDireccion());
			pst.setString(4, socio.getPoblacion());
			pst.setString(5, socio.getProvincia());
			pst.setString(6, socio.getDni());
			pst.setInt(7, socio.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*------------------------------------------PRESTAMOS----------------------------------------*/
	public ArrayList<Prestamos> getPrestamos() {
		ArrayList<Prestamos> prestamos = null;
		String st = "SELECT * FROM prestamos";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			ResultSet rs = pst.executeQuery();
			
			prestamos = new ArrayList<>();
			
			while(rs.next()) {
				Prestamos prestamo = new Prestamos();
				prestamo.setIdLibro(rs.getInt("id_libro"));
				prestamo.setIdSocio(rs.getInt("id_socio"));
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getInt("devuelto") == 1 ? true : false);
				prestamos.add(prestamo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prestamos;
	}
	
	public Prestamos getPrestamo(Prestamos prestamo) {
		String st = "SELECT * FROM PRESTAMOS WHERE id_libro=? AND id_socio=? AND fecha=?";
		Prestamos prest = new Prestamos();
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			pst.setInt(1, prestamo.getIdLibro());
			pst.setInt(2, prestamo.getIdSocio());
			pst.setDate(3, (Date) prestamo.getFecha());
			ResultSet rs = pst.executeQuery();
			rs.next();
			prest.setIdLibro(rs.getInt("id_libro"));
			prest.setIdSocio(rs.getInt("id_socio"));
			prest.setFecha(rs.getDate("fecha"));
			prest.setDevuelto(rs.getInt("devuelto") == 1 ? true : false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prest;
	}
	
	public void insertarPrestamo(Prestamos prestamo) {
		String st = "INSERT INTO socios VALUES (?,?,?,?)";
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			pst.setInt(1, prestamo.getIdLibro());
			pst.setInt(2, prestamo.getIdSocio());
			pst.setDate(3, (java.sql.Date) prestamo.getFecha());
			pst.setInt(4, prestamo.isDevuelto() ? 1 : 0);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean eliminarLibro(Prestamos prestamo) {
		ArrayList<Prestamos> prestamos = getPrestamos();
		
		String st = "DELETE FROM PRESTAMOS WHERE id_libro=? AND id_socio=? AND fecha=?";
		
		try {
			PreparedStatement pst = super.connection.prepareStatement(st);
			pst.setInt(1, prestamo.getIdLibro());
			pst.setInt(2, prestamo.getIdSocio());
			pst.setDate(3, (Date) prestamo.getFecha());
			return pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
