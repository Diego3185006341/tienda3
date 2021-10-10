package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import com.opencsv.CSVReader;

import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class servletproductos
 */
@WebServlet("/servletproductos")
public class servletproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletproductos() {
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
		String r;
		int d,c;
		double u,e,a;
		String res;
		ProductosDTO pdto;
		ProductosDAO pdao;
		ProductosDTO recdatos;
		
		if(request.getParameter("btnins")!=null) {
		d=Integer.parseInt(request.getParameter("codigo_producto"));
		u=Double.parseDouble(request.getParameter("ivacompra"));
		c=Integer.parseInt(request.getParameter("nit_proveedor"));
		r=request.getParameter("nombre_producto");
		e=Double.parseDouble(request.getParameter("precio_compra"));
		a=Double.parseDouble(request.getParameter("precio_venta"));
		pdto=new ProductosDTO(d, u, c, r, e,a);
		pdao=new ProductosDAO();
		res=pdao.insertarProductos(pdto);
		if(res.equals("r")) {
			JOptionPane.showMessageDialog(null, "Proveedor registrado");
			response.sendRedirect("productos.jsp");
		}
		else {
			JOptionPane.showMessageDialog(null, "Proveedor no registrado");
			response.sendRedirect("productos.jsp");
		}
		
			
		}
		
		if(request.getParameter("btncon")!=null){
		//Acci�n para 	 consultar
		 int doc;
		 
		 d=Integer.parseInt(request.getParameter("codigo_producto"));
		 pdto=new ProductosDTO(d);
		 pdao=new ProductosDAO();
		 recdatos=pdao.consultarProductos(pdto);
		 
		 doc=recdatos.getCodigo_productos();
		 u=recdatos.getIvacompra();
		 c=recdatos.getNitproveedor();
		 r=recdatos.getNombre_producto();
		 e=recdatos.getPrecio_compra();
		 a=recdatos.getPrecio_venta();
		 
		 
		 response.sendRedirect("productos.jsp?do="+doc+"&&us="+u+"&&cl="+c+"&&ro="+r+"&&es="+e+"&&av="+a);
			
			
		}
	
		
		
		if(request.getParameter("btnact")!=null) {
			//Acci�n para actualizar un usuraio
		  boolean dat;
		  d=Integer.parseInt(request.getParameter("codigo_producto"));
		  u=Double.parseDouble(request.getParameter("ivacompra"));
		  c=Integer.parseInt(request.getParameter("nit_proveedor"));
		  r=request.getParameter("nombre_producto");
		  e=Double.parseDouble(request.getParameter("precio_compra"));
		  a=Double.parseDouble(request.getParameter("precio_venta"));
		  pdto=new ProductosDTO(d, u, c, r, e,a);
		  pdao=new ProductosDAO();
		  dat=pdao.actualizar(pdto);
			if(dat==true) {
				JOptionPane.showMessageDialog(null, "El Proveedor se actualizo");
				response.sendRedirect("productos.jsp");
			}
		  
			else {
				JOptionPane.showMessageDialog(null, "El Proveedor no se actualizo");
			     response.sendRedirect("productos.jsp");
			
			}
			
			
		}
		
		if(request.getParameter("btneli")!=null) {
			//Acci�n para eliminar
			int y;
			d=Integer.parseInt(request.getParameter("codigo_productos"));
			 pdto=new ProductosDTO(d);
			 pdao=new ProductosDAO();
			 y=pdao.eliminar(pdto);
			 if(y>0) {
			    JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");
			    response.sendRedirect("productos.jsp");
				 
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "El proveedor NO fue eliminado");
				 response.sendRedirect("productos.jsp");
			 }
			
			
			
		}
		if(request.getParameter("btn_archivo")!=null) {
				
	        
	        Part filePart = request.getPart("file"); 
	        InputStream fileContent = filePart.getInputStream();

	        Reader in = new InputStreamReader(fileContent);

	        CSVReader reader;
	        Iterator<String[]> iterator;

	        try {

	            reader = new CSVReader(new InputStreamReader(fileContent));
	            iterator = reader.iterator();

	            String[] row = iterator.next();

	            Map<Object, String> map = new HashMap<>();
	            for(int i = 0; i < row.length; i++){
	                map.put(i, row[i]);
	                
	                JOptionPane.showMessageDialog(null, row[i]);

	                //Do rest of the code

	            }

	        }catch(Exception e1) {
	        	JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
	        }

	        in.close();
			
		}
		
		ArrayList<ProductosDTO> lista=new ArrayList<ProductosDTO>();
		pdao=new ProductosDAO();
		lista=pdao.consultar();
		 try ( PrintWriter out = response.getWriter()) {
		 out.println("<select> <option> " + request.getContextPath() + "</option></select>");
		 }
	}

}
