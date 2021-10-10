package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;
public class ProductosDAO {
	static Conexion con=new Conexion();
	static Connection cnn=con.conexiondb();
	static PreparedStatement ps;
	static ResultSet rs;
	static ProductosDTO pdtos;
	
public String insertarProductos(ProductosDTO pdo) {
		
		int x;
		String dat="";
		try {
			   pdtos=consultarProductos(pdo);
			if(pdtos==null) {
				ps=cnn.prepareStatement("INSERT INTO productos VALUES(?,?,?,?,?,?)");
				ps.setInt(1, pdo.getCodigo_productos());
				ps.setDouble(2, pdo.getIvacompra());
				ps.setInt(3, pdo.getNitproveedor());
				ps.setString(4, pdo.getNombre_producto());
				ps.setDouble(5, pdo.getPrecio_compra());
				ps.setDouble(6, pdo.getPrecio_venta());
				x=ps.executeUpdate();
					if(x>0) {
						dat="r";
					}
			}
				else {
				dat="nr";
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al insertar"+e);
			
		}
		
		
		return dat;
	}


	public  ProductosDTO consultarProductos(ProductosDTO pdo) {
		ProductosDTO pdtos = null;
	try {
		ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
		ps.setInt(1, pdo.getCodigo_productos());
		rs=ps.executeQuery();
		if(rs.next()) {
		   pdtos=new ProductosDTO(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getDouble(5),rs.getDouble(6));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return pdtos;
	}



	public int eliminar(ProductosDTO pdo) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM productos WHERE codigo_producto=? ");
		ps.setInt(1, pdo.getCodigo_productos());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(ProductosDTO pdo) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE productos SET ivacompra=?,nitproveedor=?,nombre_producto=?,precio_compra=?,precio_venta=? WHERE codigo_producto=?");
			   ps.setInt(6, pdo.getCodigo_productos());
			ps.setDouble(1, pdo.getIvacompra());
		    ps.setInt(2, pdo.getNitproveedor());
		    ps.setString(3, pdo.getNombre_producto());
		    ps.setDouble(4, pdo.getPrecio_compra());
		    ps.setDouble(5, pdo.getPrecio_venta());
		    x=ps.executeUpdate();
		    if(x>0) {
		    	dat=true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dat;	
	}
	public static ArrayList<ProductosDTO> consultar(){
		ArrayList<ProductosDTO> lista=new  ArrayList<ProductosDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos");
			rs=ps.executeQuery();
			while(rs.next()) {
				pdtos=new ProductosDTO(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getDouble(5),rs.getDouble(6));
			   lista.add(pdtos);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
