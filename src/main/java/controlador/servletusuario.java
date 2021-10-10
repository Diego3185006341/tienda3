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
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		if(request.getSession(false) == null) {
	       response.sendRedirect("index.jsp");
	       return ;
	    }
		
		
		String email_usuario,nombre_usuario,password,usuario;
		int cedula_usuario;
		String res = null;
		UsuarioDTO usdto;
		UsuarioDAO usdao;
		UsuarioDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
			
			if(request.getParameter("cedula")!="" 
					&& request.getParameter("usuario")!=""
					&& request.getParameter("password")!=""
					&& request.getParameter("email")!=""
					&& request.getParameter("nombre")!="") {
				
				cedula_usuario=Integer.parseInt(request.getParameter("cedula"));
				email_usuario=request.getParameter("email");
				nombre_usuario=request.getParameter("nombre");
				password=request.getParameter("password");
				usuario=request.getParameter("usuario");
				
				usdto=new UsuarioDTO(cedula_usuario, email_usuario, nombre_usuario, password, usuario);
				usdao=new UsuarioDAO();
				res=usdao.insertarusuario(usdto);
				
				if(res.equals("r")) {
					request.setAttribute("mensaje_success", "Usuario registrado correctamente!");
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
				}
				else {
					request.setAttribute("mensaje_error", "Usuario no registrado");
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
				}
				
			}else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("usuario.jsp").forward(request, response);
			}
		
		
		
			
		}
		
		if(request.getParameter("btncon")!=null){
		//Acciï¿½n para 	 consultar
		 int doc;
		 
		 if(request.getParameter("cedula")!="") {
			 
			 cedula_usuario=Integer.parseInt(request.getParameter("cedula"));
			 usdto=new UsuarioDTO(cedula_usuario);
			 usdao=new UsuarioDAO();
			 recdatos=usdao.consultarusuario(usdto);
			 
			 
			 if(recdatos!=null) {
				 
				 doc=recdatos.getCedula_usuario();
				 
				 email_usuario=recdatos.getEmail_usuario();
				 nombre_usuario=recdatos.getNombre_usuario();
				 password=recdatos.getPassword();
				 usuario=recdatos.getUsuario();
				 
				 response.sendRedirect("usuario.jsp?do="+doc+"&&us="+email_usuario+"&&cl="+nombre_usuario+"&&ro="+password+"&&es="+usuario);

			 }else {
				 request.setAttribute("mensaje_warning", "No existen datos para el número de cédula ingresado.");
				 request.getRequestDispatcher("usuario.jsp").forward(request, response);
			 }
			 
			 
		 }else {
			 request.setAttribute("mensaje_warning", "Ingrese un número de cédula para consultar.");
			 request.getRequestDispatcher("usuario.jsp").forward(request, response);

		 }
		 
		 	
			
		}
		
	
		
		if(request.getParameter("btnact")!=null) {
			//Acciï¿½n para consultar un usuraio
		  boolean dat;
		  
		  if(request.getParameter("cedula")!="") {
				cedula_usuario=Integer.parseInt(request.getParameter("cedula"));
				email_usuario=request.getParameter("email");
				nombre_usuario=request.getParameter("nombre");
				password=request.getParameter("password");
				usuario=request.getParameter("usuario");
				usdto=new UsuarioDTO(cedula_usuario, email_usuario, nombre_usuario, password, usuario);
				usdao=new UsuarioDAO();
				dat=usdao.actualizar(usdto);
				if(dat==true) {
					request.setAttribute("mensaje_success", "Usuario actualizado correctamente!");
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
				}
				else {
					request.setAttribute("mensaje_error", "Usuario no actualizado");
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
				
				}
				
		  }else {
			  
			request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
			request.getRequestDispatcher("usuario.jsp").forward(request, response);
			  
		  }
		  
			
			
		}
		
		if(request.getParameter("btneli")!=null) {
			//Acciï¿½n para eliminar
			int y;
			
			if(request.getParameter("cedula")!="") {
				 cedula_usuario=Integer.parseInt(request.getParameter("cedula"));
				 usdto=new UsuarioDTO(cedula_usuario);
				 usdao=new UsuarioDAO();
				 y=usdao.eliminar(usdto);
				 if(y>0) {
				    request.setAttribute("mensaje_success", "Usuario eliminado correctamente!");
					request.getRequestDispatcher("usuario.jsp").forward(request, response);
					 
				 }
				 else {
					 request.setAttribute("mensaje_error", "El usuario NO fue eliminado");
					 request.getRequestDispatcher("usuario.jsp").forward(request, response);
				 }
			}else {
				
				request.setAttribute("mensaje_warning", "Ingrese un número de cédula para eliminar.");
				 request.getRequestDispatcher("usuario.jsp").forward(request, response);
				
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
