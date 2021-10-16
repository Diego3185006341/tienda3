package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class VentasDAO {
	static Conexion con=new Conexion();
	static Connection cnn=con.conexiondb();
	static PreparedStatement ps;
	static ResultSet rs;
	static ClientesDTO cldo;
public  int consultarconsecutivo() {
		
		int consecutivo = 0;
		
	try {
		ps=cnn.prepareStatement("SELECT COUNT(codigo_venta) AS cantidad FROM ventas");		
		rs=ps.executeQuery();
		if(rs.next()) {
		   consecutivo=rs.getInt(1);
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	

	consecutivo = consecutivo + 1;
		
	return consecutivo;
	}
	
	
	
	
}
