package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import controlador.Conexion;
import modelo.UsuarioDTO;

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
				ps=cnn.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?)");
				ps.setInt(1, us.getDocumento());
				ps.setString(2, us.getNomusuario());
				ps.setString(3, us.getClave());
				ps.setString(4, us.getRol());
				ps.setString(5, us.getEstado());
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
		ps=cnn.prepareStatement("SELECT * FROM usuario WHERE documento=?");
		ps.setInt(1, us.getDocumento());
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
		ps=cnn.prepareStatement("DELETE FROM usuario WHERE documento=? ");
		ps.setInt(1, us.getDocumento());
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
			ps=cnn.prepareStatement("UPDATE usuario SET nomusuario=?,clave=?,rol=?,estado=? WHERE documento=?");
		    ps.setString(1, us.getNomusuario());
		    ps.setString(2, us.getClave());
		    ps.setString(3, us.getRol());
		    ps.setString(4, us.getEstado());
		    ps.setInt(5, us.getDocumento());
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
			ps=cnn.prepareStatement("SELECT * FROM usuario");
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
			String sql = "SELECT U.documento, U.nomusuario, U.clave FROM usuario U WHERE U.nomusuario = ? AND U.clave = ?";
			ps = cnn.prepareStatement(sql);
			ps.setString(1, numusuario);
			ps.setString(2, clave);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new UsuarioDTO(0);
				dto.setDocumento(rs.getInt("documento"));
				dto.setNomusuario(rs.getString("nomusuario"));
				dto.setClave(rs.getString("clave"));
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
