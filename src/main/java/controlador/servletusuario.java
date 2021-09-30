package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class servletusuario
 */
@WebServlet("/servletusuario")
public class servletusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String u,c,r,e;
		int d;
		String res;
		UsuarioDTO usdto;
		UsuarioDAO usdao;
		UsuarioDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("cedula"));
		u=request.getParameter("email");
		c=request.getParameter("nombre");
		r=request.getParameter("password");
		e=request.getParameter("usuario");
		
		usdto=new UsuarioDTO(d, u, c, r, e);
		usdao=new UsuarioDAO();
		res=usdao.insertarusuario(usdto);
		if(res.equals("r")) {
			JOptionPane.showMessageDialog(null, "Usuario registrdo");
			response.sendRedirect("usuario.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Usuario no registrado");
			response.sendRedirect("usuario.jsp");
		}
		
			
		}
		
		if(request.getParameter("btncon")!=null){
		//Acci�n para 	 consultar
		 int doc;
		 
		 d=Integer.parseInt(request.getParameter("cedula"));
		 usdto=new UsuarioDTO(d);
		 usdao=new UsuarioDAO();
		 recdatos=usdao.consultarusuario(usdto);
		 
		 doc=recdatos.getCedula_usuario();
		 u=recdatos.getEmail_usuario();
		 c=recdatos.getNombre_usuario();
		 r=recdatos.getPassword();
		 e=recdatos.getUsuario();
		 
		 response.sendRedirect("clientes.jsp?do="+doc+"&&us="+u+"&&cl="+c+"&&ro="+r+"&&es="+e);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		if(request.getParameter("btnact")!=null) {
			//Acci�n para consultar un usuraio
		  boolean dat;
		  d=Integer.parseInt(request.getParameter("cedula"));
		  u=request.getParameter("email");
		  c=request.getParameter("nombre");
		  r=request.getParameter("password");
		  e=request.getParameter("usuario");
		  usdto=new UsuarioDTO(d, u, c, r, e);
		  usdao=new UsuarioDAO();
		  dat=usdao.actualizar(usdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El usuario se actualizo");
				response.sendRedirect("usuario.jsp");
			}
		  
			else {
				JOptionPane.showMessageDialog(null, "El usuario no se actualizo");
			     response.sendRedirect("usuario.jsp");
			
			}
			
			
		}
		
		if(request.getParameter("btneli")!=null) {
			//Acci�n para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("cedula"));
			 usdto=new UsuarioDTO(d);
			 usdao=new UsuarioDAO();
			 y=usdao.eliminar(usdto);
			 if(y>0) {
			    JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
			    response.sendRedirect("usuario.jsp");
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "El usuario NO fue eliminado");
				 response.sendRedirect("usuario.jsp");
			 }
			
			
			
		}
		
		ArrayList<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
		usdao=new UsuarioDAO();
		lista=usdao.consultar();
		 try ( PrintWriter out = response.getWriter()) {
		 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
		 }
		
		
		
		
		
		
	}

}
