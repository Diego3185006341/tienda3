package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;
public class ClientesDAO {

	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ClientesDTO cdo;
	
public String insertarusuario(ClientesDTO cdo) {
		
		int x;
		String dat="";
		try {
			cdo=consultarcliente(cdo);
			if(cdo==null) {
				ps=cnn.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
				ps.setInt(1, cdo.getCedula_cliente());
				ps.setString(2, cdo.getDireccion_cliente());
				ps.setString(3, cdo.getEmail_cliente());
				ps.setString(4, cdo.getNombre_cliente());
				ps.setString(5, cdo.getTelefono_cliente());
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


	public  ClientesDTO consultarcliente(ClientesDTO cdo) {
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
		ps.setInt(1, cdo.getCedula_cliente());
		rs=ps.executeQuery();
		if(rs.next()) {
		   cdo=new ClientesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return cdo;
	}



	public int eliminar(ClientesDTO cdo) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=? ");
		ps.setInt(1, cdo.getCedula_cliente());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(ClientesDTO cdo) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET direccion_cliente=?,email_cliente=?nombre_cliente=?,telefono_cliente=? WHERE cedula_cliente=?");
		    ps.setString(1, cdo.getDireccion_cliente());
		    ps.setString(2, cdo.getEmail_cliente());
		    ps.setString(3, cdo.getNombre_cliente());
		    ps.setString(4, cdo.getTelefono_cliente());
		    ps.setInt(5, cdo.getCedula_cliente());
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
	public ArrayList<ClientesDTO> consultar(){
		ArrayList<ClientesDTO> lista=new  ArrayList<ClientesDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
			while(rs.next()) {
				cdo=new ClientesDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   lista.add(cdo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
}
