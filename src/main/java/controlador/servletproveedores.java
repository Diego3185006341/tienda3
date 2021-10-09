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

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class servletproveedores
 */
@WebServlet("/servletproveedores")
public class servletproveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletproveedores() {
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

		String u,c,r,e;
		int d;
		String res;
		ProveedoresDTO pvdto;
		ProveedoresDAO pvdao;
		ProveedoresDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("nitproveedor"));
		u=request.getParameter("ciudad_proveedor");
		c=request.getParameter("direccion_proveedor");
		r=request.getParameter("nombre_proveedor");
		e=request.getParameter("telefono_proveedor");
		
		pvdto=new ProveedoresDTO(d, u, c, r, e);
		pvdao=new ProveedoresDAO();
		res=pvdao.insertarproveedores(pvdto);
		if(res.equals("r")) {
			JOptionPane.showMessageDialog(null, "Proveedor registrado");
			response.sendRedirect("proveedores.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Proveedor no registrado");
			response.sendRedirect("proveedores.jsp");
		}
		
			
		}
		
		if(request.getParameter("btncon")!=null){
		//Acci�n para 	 consultar
		 int doc;
		 
		 d=Integer.parseInt(request.getParameter("nitproveedor"));
		 pvdto=new ProveedoresDTO(d);
		 pvdao=new ProveedoresDAO();
		 recdatos=pvdao.consultarproveedores(pvdto);
		 
		 doc=recdatos.getnitproveedor();
		 u=recdatos.getciudad_proveedor();
		 c=recdatos.getdireccion_proveedor();
		 r=recdatos.getnombre_proveedor();
		 e=recdatos.gettelefono_proveedor();
		 
		 response.sendRedirect("proveedores.jsp?do="+doc+"&&us="+u+"&&cl="+c+"&&ro="+r+"&&es="+e);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		if(request.getParameter("btnact")!=null) {
			//Acci�n para consultar un usuraio
		  boolean dat;
		  d=Integer.parseInt(request.getParameter("nitproveedor"));
		  u=request.getParameter("ciudad_proveedor");
		  c=request.getParameter("direccion_proveedor");
		  r=request.getParameter("nombre_proveedor");
		  e=request.getParameter("telefono_proveedor");
		  pvdto=new ProveedoresDTO(d, u, c, r, e);
		  pvdao=new ProveedoresDAO();
		  dat=pvdao.actualizar(pvdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El Proveedor se actualizo");
				response.sendRedirect("proveedores.jsp");
			}
		  
			else {
				JOptionPane.showMessageDialog(null, "El Proveedor no se actualizo");
			     response.sendRedirect("proveedores.jsp");
			
			}
			
			
		}
		
		if(request.getParameter("btneli")!=null) {
			//Acci�n para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("nitproveedor"));
			 pvdto=new ProveedoresDTO(d);
			 pvdao=new ProveedoresDAO();
			 y=pvdao.eliminar(pvdto);
			 if(y>0) {
			    JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
			    response.sendRedirect("Proveedor.jsp");
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "El proveedor NO fue eliminado");
				 response.sendRedirect("Proveedor.jsp");
			 }
			
			
			
		}
		
		ArrayList<ProveedoresDTO> lista=new ArrayList<ProveedoresDTO>();
		pvdao=new ProveedoresDAO();
		lista=pvdao.consultar();
		 try ( PrintWriter out = response.getWriter()) {
		 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
		 }
	}

}
