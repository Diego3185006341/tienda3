package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class VentasDAO {
	static Conexion con = new Conexion();
	static Connection cnn = con.conexiondb();
	static PreparedStatement ps;
	static ResultSet rs;
	static ClientesDTO cldo;

	public int consultarconsecutivo() {

		int consecutivo = 0;

		try {
			ps = cnn.prepareStatement("SELECT COUNT(codigo_venta) AS cantidad FROM ventas");
			rs = ps.executeQuery();
			if (rs.next()) {
				consecutivo = rs.getInt(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		consecutivo = consecutivo + 1;

		return consecutivo;
	}

	public int insertarventa(VentasDTO ventaDTO) {

		int codigoventa = -1;
		
		try {
			
				ps = cnn.prepareStatement("INSERT INTO ventas (`cedula_cliente`,`cedula_usuario`,`ivaventa`,`total_venta`,`valor_venta`) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ventaDTO.getCedula_cliente());
				ps.setInt(2, ventaDTO.getCedula_usuario());
				ps.setDouble(3, ventaDTO.getIvaventa());
				ps.setDouble(4, ventaDTO.getTotal_venta());
				ps.setDouble(5, ventaDTO.getValor_venta());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                {
                	codigoventa = rs.getInt(1);
                }
                
				
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar" + e);

		}

		return codigoventa;
	}
	
	
	
	public int insertarventadetalle(VentasDetalleDTO ventadetalleDTO) {

		int codigodetalleventa = -1;
		
		try {
			
				ps = cnn.prepareStatement("INSERT INTO detalle_ventas (`cantidad_producto`,`codigo_producto`,`codigo_venta`,`valor_total`,`valor_venta`) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, ventadetalleDTO.getCantidad_producto());
				ps.setInt(2, ventadetalleDTO.getCodigo_producto());
				ps.setInt(3, ventadetalleDTO.getCodigo_venta());
				ps.setDouble(4, ventadetalleDTO.getValor_total());
				ps.setDouble(5, ventadetalleDTO.getValor_venta());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
                if(rs.next())
                {
                    codigodetalleventa = rs.getInt(1);
                }
                
				
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar" + e);

		}

		return codigodetalleventa;
	}
	
	
		
	public static ArrayList<VentasReporteDTO> reporteventas(){
		ArrayList<VentasReporteDTO> lista=new  ArrayList<VentasReporteDTO>();
		VentasReporteDTO ventareporte;
		try {
			ps=cnn.prepareStatement("SELECT DISTINCT v.cedula_cliente, c.nombre_cliente, SUM(v.total_venta) FROM ventas AS v INNER JOIN clientes AS c ON c.cedula_cliente = v.cedula_cliente GROUP BY v.cedula_cliente ORDER BY v.cedula_cliente");
			rs=ps.executeQuery();
			while(rs.next()) {
				ventareporte=new VentasReporteDTO(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			   lista.add(ventareporte);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	public static Double totalventas() {

		Double totalventas = (double) 0;

		try {
			ps = cnn.prepareStatement("SELECT SUM(total_venta) AS total_ventas FROM ventas");
			rs = ps.executeQuery();
			if (rs.next()) {
				totalventas = rs.getDouble(1);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}


		return totalventas;
	}

}
