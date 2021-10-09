package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;
public class ProveedoresDAO {

	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ProveedoresDTO pvdo;
	
public String insertarproveedores(ProveedoresDTO pdo) {
		
		int x;
		String dat="";
		try {
			   pvdo=consultarproveedores(pdo);
			if(pvdo==null) {
				ps=cnn.prepareStatement("INSERT INTO Proveedores VALUES(?,?,?,?,?)");
				ps.setInt(1, pdo.getnitproveedor());
				ps.setString(2, pdo.getciudad_proveedor());
				ps.setString(3, pdo.getdireccion_proveedor());
				ps.setString(4, pdo.getnombre_proveedor());
				ps.setString(5, pdo.gettelefono_proveedor());
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


	public  ProveedoresDTO consultarproveedores(ProveedoresDTO pdo) {
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
		ps.setInt(1, pdo.getnitproveedor());
		rs=ps.executeQuery();
		if(rs.next()) {
		   pvdo=new ProveedoresDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return pvdo;
	}



	public int eliminar(ProveedoresDTO pdo) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=? ");
		ps.setInt(1, pdo.getnitproveedor());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(ProveedoresDTO pdo) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE provedores SET ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? WHERE nitproveedor=?");
		    ps.setInt(1, pdo.getnitproveedor());
		    ps.setString(2, pdo.getciudad_proveedor());
		    ps.setString(3, pdo.getdireccion_proveedor());
		    ps.setString(4, pdo.getnombre_proveedor());
		    ps.setString(5, pdo.gettelefono_proveedor());
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
	public ArrayList<ProveedoresDTO> consultar(){
		ArrayList<ProveedoresDTO> lista=new  ArrayList<ProveedoresDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedor");
			rs=ps.executeQuery();
			while(rs.next()) {
				pvdo=new ProveedoresDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   lista.add(pvdo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
