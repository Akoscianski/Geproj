package utils.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBase {
	public Connection getConnection(){
		Connection con = null;
		String connect = "jdbc:oracle:thin:Geproj/passwd@localhost";
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			con = DriverManager.getConnection(connect);
		} catch (SQLException e) {
			System.out.println("Erreur lors de la connection à la BD.");
			e.printStackTrace();
		}
		return con;
	}
}
