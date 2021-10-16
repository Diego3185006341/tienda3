package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ClientesDTO;
import modelo.ClientesDAO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.VentasDAO;

/**
 * Servlet implementation class servletventas
 */
@WebServlet("/servletventas")
public class servletventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletventas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int cantidad1 = 0, cantidad2, cantidad3, cedula = 0, consecutivo, codigo1 = 0;
		String nombre = "", nombre_producto = "";
		double precio_venta=0,vr_total1 = 0;
		ClientesDTO cldto;
		ClientesDAO cldao;
		ClientesDTO recdatos;
		VentasDAO vendao;
		vendao = new VentasDAO();
		consecutivo = vendao.consultarconsecutivo();
		
		ProductosDTO resdato;
		ProductosDAO pdao;
		ProductosDTO pdto;

		if (request.getParameter("cedula") != null) {

			cedula = Integer.parseInt(request.getParameter("cedula"));

		}
		if (request.getParameter("consultar_cliente") != null) {

			cldto = new ClientesDTO(cedula);
			cldao = new ClientesDAO();
			recdatos = cldao.consultarcliente(cldto);

			if (recdatos != null) {
				nombre = recdatos.getNombre_cliente();

			} else {

				nombre = "cliente no existe";

			}

		}
		if (request.getParameter("consultarp1") != null) {

			codigo1 = Integer.parseInt(request.getParameter("codigo_producto1"));

			resdato = new ProductosDTO(codigo1);
			pdao = new ProductosDAO();
			pdto = pdao.consultarProductos(resdato);
			if (pdto != null) {
			nombre_producto = pdto.getNombre_producto();
			cantidad1=Integer.parseInt(request.getParameter("cantidad1"));	
			precio_venta=pdto.getPrecio_venta();
			vr_total1=cantidad1*precio_venta;
			
			}

		}
		response.sendRedirect("ventas.jsp?nombre=" + nombre + "&cedula=" + cedula + "&consecut=" + consecutivo
				+ "&nombre_producto1=" + nombre_producto+"&vr_total1="+vr_total1+"&codigo1="+codigo1+"&cantidad1="+cantidad1);
	
		
	}

}
