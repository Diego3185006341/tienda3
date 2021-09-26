package controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	static Connection cnn;

	public static Connection conexiondb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
				try {
					cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","diego785");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Conexion ok");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	return cnn;	
	}
		

}
