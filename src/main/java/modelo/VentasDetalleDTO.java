package modelo;

public class VentasDetalleDTO {
	
	int codigo_detalle_venta;
	int cantidad_producto;
	int codigo_producto;
	int codigo_venta;
	Double valor_total;
	Double valor_venta;


	
	
	
	public VentasDetalleDTO(int codigo_detalle_venta, int cantidad_producto, int codigo_producto, int codigo_venta,
			Double valor_total, Double valor_venta) {
		super();
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
	}
	public int getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(int codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}


	
	
	
}
