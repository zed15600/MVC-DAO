package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DataSourceMySQL {
	// Atributos
	private static final String DB="Universidad";                       // Nombre de la DataBase
	private static final String URL ="jdbc:mysql://localhost:3306/"+DB; // URL de la conexion
	private static final String USERNAME ="root";                       // Nombre del usuario 
	private static final String PASSWORD ="1234";                       // Contraseña de la DataBase
	private static Connection con = null;
	
	// Constructor
	private DataSourceMySQL(){}
	
	// Obtener la conexion
	public static Connection getConexion() {
		
		if( con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
			}catch(SQLException e) {
				System.out.println(e);
			}catch(ClassNotFoundException ex) {
				Logger.getLogger(DataSourceMySQL.class.getName()).log(Level.SEVERE, null, ex);;
			}
			return con;
		}else {
			return con;
		}
	}
	
	
	// Ejecutar consultas
	
	
}
