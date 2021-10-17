package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ClientesDTO;
import modelo.ClientesDAO;
import modelo.ProductosDAO;
import modelo.ProductosDTO;
import modelo.UsuarioDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;
import modelo.VentasDetalleDTO;

/**
 * Servlet implementation class servletventas
 */
@WebServlet("/servletventas")
public class servletventas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String mensaje_error, mensaje_success, mensaje_warning;

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
		int cantidad1 = 0, cantidad2 = 0, cantidad3 = 0, cedula = 0, consecutivo, codigo1 = 0, codigo2 = 0, codigo3 = 0;
		String cliente = "", nombre_producto1 = "", nombre_producto2 = "", nombre_producto3 = "";
		double precio_venta1 = 0, precio_venta2 = 0, precio_venta3 = 0, vr_total1 = 0, vr_total2 = 0, vr_total3 = 0;
		double totalventa = 0, totaliva = 0, total_con_iva = 0;

		mensaje_error = "";
		mensaje_success = "";
		mensaje_warning = "";

		VentasDAO vendao;
		vendao = new VentasDAO();
		consecutivo = vendao.consultarconsecutivo();

		ProductosDTO resdato;
		ProductosDAO pdao;
		ProductosDTO pdto;

		VentasDTO venta;
		VentasDetalleDTO ventasDetalle1;
		VentasDetalleDTO ventasDetalle2;
		VentasDetalleDTO ventasDetalle3;
		VentasDAO ventasDAO;

		UsuarioDTO usuario;

		if (request.getParameter("cedula") != null) {

			cedula = Integer.parseInt(request.getParameter("cedula"));
			cliente = consultarCliente(cedula);

		}

		if (request.getParameter("codigo_producto1") != null && request.getParameter("codigo_producto1") != ""
				&& request.getParameter("codigo_producto1") != "0") {
			try {
				codigo1 = Integer.parseInt(request.getParameter("codigo_producto1"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("codigo_producto2") != null && request.getParameter("codigo_producto2") != ""
				&& request.getParameter("codigo_producto2") != "0") {
			try {
				codigo2 = Integer.parseInt(request.getParameter("codigo_producto2"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("codigo_producto3") != null && request.getParameter("codigo_producto3") != ""
				&& request.getParameter("codigo_producto3") != "0") {
			try {
				codigo3 = Integer.parseInt(request.getParameter("codigo_producto3"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (request.getParameter("cantidad1") != null && request.getParameter("cantidad1") != "") {
			try {
				cantidad1 = Integer.parseInt(request.getParameter("cantidad1"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("cantidad2") != null && request.getParameter("cantidad2") != "") {
			try {
				cantidad2 = Integer.parseInt(request.getParameter("cantidad2"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("cantidad3") != null && request.getParameter("cantidad3") != "") {
			try {
				cantidad3 = Integer.parseInt(request.getParameter("cantidad3"));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// if (request.getParameter("consultarp") != null) {

		if (codigo1 > 0) {

			resdato = new ProductosDTO(codigo1);
			pdao = new ProductosDAO();
			pdto = pdao.consultarProductos(resdato);
			if (pdto != null) {
				nombre_producto1 = pdto.getNombre_producto();
				precio_venta1 = pdto.getPrecio_venta();

			} else {

				mensaje_warning = mensaje_warning + "\nProducto con codigo " + request.getParameter("codigo_producto1")
						+ " no existe!, verifica.";

			}
		}

		if (codigo2 > 0) {

			resdato = new ProductosDTO(codigo2);
			pdao = new ProductosDAO();
			pdto = pdao.consultarProductos(resdato);
			if (pdto != null) {
				nombre_producto2 = pdto.getNombre_producto();
				precio_venta2 = pdto.getPrecio_venta();

			} else {

				mensaje_warning = mensaje_warning + "\nProducto con codigo " + request.getParameter("codigo_producto2")
						+ " no existe!, verifica.";

			}
		}

		if (codigo3 > 0) {

			resdato = new ProductosDTO(codigo3);
			pdao = new ProductosDAO();
			pdto = pdao.consultarProductos(resdato);
			if (pdto != null) {
				nombre_producto3 = pdto.getNombre_producto();
				precio_venta3 = pdto.getPrecio_venta();

			} else {

				mensaje_warning = mensaje_warning + "\nProducto con codigo " + request.getParameter("codigo_producto3")
						+ " no existe!, verifica.";

			}
		}

		// }

		vr_total1 = cantidad1 * precio_venta1;
		vr_total2 = cantidad2 * precio_venta2;
		vr_total3 = cantidad3 * precio_venta3;

		totalventa = vr_total1 + vr_total2 + vr_total3;
		totaliva = totalventa * 0.19;
		total_con_iva = totalventa + totaliva;

		if (request.getParameter("btnconfirm") != null) {
			HttpSession sesion = request.getSession();
			usuario = (UsuarioDTO) sesion.getAttribute("usuario");

			// guardar venta en base de datos
			ventasDAO = new VentasDAO();

			if (true) { // TODO:validar codigos de producto
				venta = new VentasDTO(0, cedula, usuario.getCedula_usuario(), totaliva, totalventa, total_con_iva);

				int codigoventa = ventasDAO.insertarventa(venta);
				venta.setCodigo_venta(codigoventa);

				if (codigoventa > 0) {

					if (codigo1 > 0) {
						ventasDetalle1 = new VentasDetalleDTO(0, cantidad1, codigo1, codigoventa, vr_total1,
								precio_venta1);
						int codigoventadetalle1 = ventasDAO.insertarventadetalle(ventasDetalle1);
						ventasDetalle1.setCodigo_detalle_venta(codigoventadetalle1);
					}

					if (codigo2 > 0) {
						ventasDetalle2 = new VentasDetalleDTO(0, cantidad2, codigo2, codigoventa, vr_total2,
								precio_venta2);
						int codigoventadetalle2 = ventasDAO.insertarventadetalle(ventasDetalle2);
						ventasDetalle2.setCodigo_detalle_venta(codigoventadetalle2);
					}

					if (codigo3 > 0) {
						ventasDetalle3 = new VentasDetalleDTO(0, cantidad3, codigo3, codigoventa, vr_total3,
								precio_venta3);
						int codigoventadetalle3 = ventasDAO.insertarventadetalle(ventasDetalle3);
						ventasDetalle3.setCodigo_detalle_venta(codigoventadetalle3);
					}

					mensaje_success = "\"Venta registrada correctamente!\"";

				}

			}

			// TODO: msg error

		}

		response.sendRedirect("ventas.jsp?cliente=" + cliente + "&cedula=" + cedula + "&consecut=" + consecutivo
				+ "&nombre_producto1=" + nombre_producto1 + "&vr_total1=" + vr_total1
				+ (codigo1 > 0 ? "&codigo1=" + codigo1 : "") + "&cantidad1=" + cantidad1 + "&nombre_producto2="
				+ nombre_producto2 + "&vr_total2=" + vr_total2 + (codigo2 > 0 ? "&codigo2=" + codigo2 : "")
				+ "&cantidad2=" + cantidad2 + "&nombre_producto3=" + nombre_producto3 + "&vr_total3=" + vr_total3
				+ (codigo3 > 0 ? "&codigo3=" + codigo3 : "") + "&cantidad3=" + cantidad3 + "&mensaje_success="
				+ mensaje_success + "&mensaje_warning=" + mensaje_warning + "&mensaje_error=" + mensaje_error
				+ "&totalventa=" + totalventa + "&totaliva=" + totaliva + "&total_con_iva=" + total_con_iva);

	}

	private String consultarCliente(int cedula) {
		String cliente = "cliente no existe";

		ClientesDTO cldto;
		ClientesDAO cldao;
		ClientesDTO recdatos;

		cldto = new ClientesDTO(cedula);
		cldao = new ClientesDAO();
		recdatos = cldao.consultarcliente(cldto);

		if (recdatos != null) {
			cliente = recdatos.getNombre_cliente();

		} else {

			cliente = "";
			mensaje_warning = mensaje_warning + "\nCliente no existe!, verifica.";

		}

		return cliente;
	}

}
