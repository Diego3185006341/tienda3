package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;


public class UsuarioDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	UsuarioDTO usu;

	public String insertarusuario(UsuarioDTO us) {
		
		int x;
		String dat="";
		try {
			usu=consultarusuario(us);
			if(usu==null) {
				ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
				ps.setInt(1, us.getCedula_usuario());
				ps.setString(2, us.getEmail_usuario());
				ps.setString(3, us.getNombre_usuario());
				ps.setString(4, us.getPassword());
				ps.setString(5, us.getUsuario());
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


	public  UsuarioDTO consultarusuario(UsuarioDTO us) {
		
	try {
		ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
		ps.setInt(1, us.getCedula_usuario());
		rs=ps.executeQuery();
		if(rs.next()) {
		   usu=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}	
		
	return usu;
	}



	public int eliminar(UsuarioDTO us) {
		
		int x=0;
	  try {
		ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=? ");
		ps.setInt(1, us.getCedula_usuario());
		x=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	 return x; 	
	}
		

	public boolean actualizar(UsuarioDTO us) {
		boolean dat=false;
		int x;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario=?,nombre_usuario=?,password=?,usuario=? WHERE cedula_usuario=?");
			ps.setInt(5, us.getCedula_usuario());
			ps.setString(1, us.getEmail_usuario());
		    ps.setString(2, us.getNombre_usuario());
		    ps.setString(3, us.getPassword());
		    ps.setString(4, us.getUsuario());
		  
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
	public ArrayList<UsuarioDTO> consultar(){
		ArrayList<UsuarioDTO> lista=new  ArrayList<UsuarioDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios");
			rs=ps.executeQuery();
			while(rs.next()) {
				usu=new UsuarioDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   lista.add(usu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	public UsuarioDTO iniciarSesion(String numusuario, String clave) {
		UsuarioDTO dto = null;
		
		
		try {
			cnn = Conexion.conexiondb();
			String sql = "SELECT U.cedula_usuario, U.usuario, U.password FROM usuarios U WHERE U.usuario = ? AND U.password = ?";
			ps = cnn.prepareStatement(sql);
			ps.setString(1, numusuario);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new UsuarioDTO(0);
				dto.setCedula_usuario(rs.getInt("cedula_usuario"));
				dto.setUsuario(rs.getString("usuario"));
				dto.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (ps != null) {
					ps.close();
				}
				
				if (cnn != null) {
					cnn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

}
