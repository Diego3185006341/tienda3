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
					//cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","diego785");
					//cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ventas","user_ventas","yisaw4D8MA");
					cnn=DriverManager.getConnection("jdbc:mysql://TIENDAGENERICAGRUPOS4052.czo3ixoe3xoe.us-east-1.rds.amazonaws.com:3306/Equipo_05_Grupo40?useSSL=false","admin","1234567890");
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//JOptionPane.showMessageDialog(null, "Conexion ok");
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	return cnn;	
	}
		

}
