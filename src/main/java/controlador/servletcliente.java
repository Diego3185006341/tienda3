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

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class servletcliente
 */
@WebServlet("/servletcliente")
public class servletcliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletcliente() {
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
		ClientesDTO cldto;
		ClientesDAO cldao;
		ClientesDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("doc"));
		u=request.getParameter("usu");
		c=request.getParameter("cla");
		r=request.getParameter("rol");
		e=request.getParameter("est");
		
		cldto=new ClientesDTO(d, u, c, r, e);
		cldao=new ClientesDAO();
		res=cldao.insertarusuario(cldto);
		if(res.equals("r")) {
			JOptionPane.showMessageDialog(null, "Cliente registrdo");
			response.sendRedirect("Clientes.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Cliente no registrado");
			response.sendRedirect("Clientes.jsp");
		}
		
			
		}
		
		if(request.getParameter("btncon")!=null){
		//Acci�n para 	 consultar
		 int doc;
		 
		 d=Integer.parseInt(request.getParameter("doc"));
		 cldto=new ClientesDTO(d);
		 cldao=new ClientesDAO();
		 recdatos=cldao.consultarcliente(cldto);
		 
		 doc=recdatos.getCedula_cliente();
		 u=recdatos.getDireccion_cliente();
		 c=recdatos.getEmail_cliente();
		 r=recdatos.getNombre_cliente();
		 e=recdatos.getTelefono_cliente();
		 
		 response.sendRedirect("Clientes.jsp?do="+doc+"&&us="+u+"&&cl="+c+"&&ro="+r+"&&es="+e);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		if(request.getParameter("btnact")!=null) {
			//Acci�n para consultar un usuraio
		  boolean dat;
		  d=Integer.parseInt(request.getParameter("doc"));
		  u=request.getParameter("usu");
		  c=request.getParameter("cla");
		  r=request.getParameter("rol");
		  e=request.getParameter("est");
		  cldto=new ClientesDTO(d, u, c, r, e);
		  cldao=new ClientesDAO();
		  dat=cldao.actualizar(cldto);
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
			d=Integer.parseInt(request.getParameter("doc"));
			 cldto=new ClientesDTO(d);
			 cldao=new ClientesDAO();
			 y=cldao.eliminar(cldto);
			 if(y>0) {
			    JOptionPane.showMessageDialog(null, "El usuario fue eliminado");
			    response.sendRedirect("usuario.jsp");
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "El usuario NO fue eliminado");
				 response.sendRedirect("usuario.jsp");
			 }
			
			
			
		}
		
		ArrayList<ClientesDTO> lista=new ArrayList<ClientesDTO>();
		cldao=new ClientesDAO();
		lista=cldao.consultar();
		 try ( PrintWriter out = response.getWriter()) {
		 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
		 }
		
	}

}
