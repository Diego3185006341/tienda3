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
		// doGet(request, response);

		String direccion_cliente, email_cliente, nombre_cliente, telefono_cliente;
		int cedula_cliente;
		String res;
		ClientesDTO cldto;
		ClientesDAO cldao;
		ClientesDTO recdatos;

		if (request.getParameter("btnins") != null) {
			if (request.getParameter("cedula_cliente") != "" && request.getParameter("direccion") != ""
					&& request.getParameter("email") != "" && request.getParameter("nombre") != ""
					&& request.getParameter("telefono") != "") {

				cedula_cliente = Integer.parseInt(request.getParameter("cedula_cliente"));
				direccion_cliente = request.getParameter("direccion");
				email_cliente = request.getParameter("email");
				nombre_cliente = request.getParameter("nombre");
				telefono_cliente = request.getParameter("telefono");

				cldto = new ClientesDTO(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente,
						telefono_cliente);
				cldao = new ClientesDAO();
				res = cldao.insertarcliente(cldto);
				if (res.equals("r")) {
					request.setAttribute("mensaje_success", "Cliente registrado correctamente!");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				} else {
					request.setAttribute("mensaje_error", "Cliente no registrado");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btncon") != null) {
			// Acciï¿½n para consultar
			int doc;

			if (request.getParameter("cedula_cliente") != "") {
				cedula_cliente = Integer.parseInt(request.getParameter("cedula_cliente"));
				cldto = new ClientesDTO(cedula_cliente);
				cldao = new ClientesDAO();
				recdatos = cldao.consultarcliente(cldto);

				if (recdatos != null) {

					doc = recdatos.getCedula_cliente();
					direccion_cliente = recdatos.getDireccion_cliente();
					email_cliente = recdatos.getEmail_cliente();
					nombre_cliente = recdatos.getNombre_cliente();
					telefono_cliente = recdatos.getTelefono_cliente();

					response.sendRedirect("Clientes.jsp?do=" + doc + "&&us=" + direccion_cliente + "&&cl="
							+ email_cliente + "&&ro=" + nombre_cliente + "&&es=" + telefono_cliente);

				} else {
					request.setAttribute("mensaje_warning", "No existen datos para el número de cédula ingresado.");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número de cédula para consultar.");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btnact") != null) {
			// Acciï¿½n para consultar un usuraio
			boolean dat;

			if (request.getParameter("cedula_cliente") != "") {
				cedula_cliente = Integer.parseInt(request.getParameter("cedula_cliente"));
				direccion_cliente = request.getParameter("direccion");
				email_cliente = request.getParameter("email");
				nombre_cliente = request.getParameter("nombre");
				telefono_cliente = request.getParameter("telefono");
				cldto = new ClientesDTO(cedula_cliente, direccion_cliente, email_cliente, nombre_cliente,
						telefono_cliente);
				cldao = new ClientesDAO();
				dat = cldao.actualizar(cldto);
				if (dat == true) {
					request.setAttribute("mensaje_success", "Cliente actualizado correctamente!");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				}

				else {
					request.setAttribute("mensaje_error", "Cliente no actualizado");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);

				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese los valores requeridos");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}

		}

		if (request.getParameter("btneli") != null) {
			// Acciï¿½n para eliminar
			int y;
			if (request.getParameter("cedula_cliente") != "") {
				cedula_cliente = Integer.parseInt(request.getParameter("cedula_cliente"));
				cldto = new ClientesDTO(cedula_cliente);
				cldao = new ClientesDAO();
				y = cldao.eliminar(cldto);
				if (y > 0) {
					request.setAttribute("mensaje_success", "Cliente eliminado correctamente!");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);

				} else {
					request.setAttribute("mensaje_error", "El Cliente NO fue eliminado");
					request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("mensaje_warning", "Ingrese un número de cédula para eliminar.");
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}

		}

		ArrayList<ClientesDTO> lista = new ArrayList<ClientesDTO>();
		cldao = new ClientesDAO();
		lista = cldao.consultar();
		try (PrintWriter out = response.getWriter()) {
			out.println("<select> <option> " + request.getContextPath() + "</option></select>");
		}

	}

}
