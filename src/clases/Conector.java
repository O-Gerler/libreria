package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public void conectar() {
		final String HOST = "jdbc:mysql://localhost/biblioteca2";
		final String USER = "root";
		final String PASSWORD = "";
		
		try {
			Class.forName("com.jdbc.mysql.Driver");
			connection = DriverManager.getConnection(HOST,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
