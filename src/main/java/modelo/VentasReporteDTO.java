package modelo;

public class VentasReporteDTO {
	
	int cedula_cliente;
	String nombre_cliente;
	Double total_ventas;
	
	
	
	public VentasReporteDTO(int cedula_cliente, String nombre_cliente, Double total_ventas) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.total_ventas = total_ventas;
	}



	public int getCedula_cliente() {
		return cedula_cliente;
	}



	public void setCedula_cliente(int cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}



	public String getNombre_cliente() {
		return nombre_cliente;
	}



	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}



	public Double getTotal_ventas() {
		return total_ventas;
	}



	public void setTotal_ventas(Double total_ventas) {
		this.total_ventas = total_ventas;
	}
	
	
	
	
	

}
