package modelo;

public class ProductosDTO {
	
	int codigo_productos; 
	double ivacompra;
	int nitproveedor;
	String nombre_producto;
	double precio_compra;
	double precio_venta;
	public ProductosDTO(int codigo_productos, double ivacompra, int nitproveedor, String nombre_producto,
			double precio_compra, double precio_venta) {
	
		this.codigo_productos = codigo_productos;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	
	public ProductosDTO(int codigo_productos) {
		this.codigo_productos=codigo_productos;
		
	}
	
	public int getCodigo_productos() {
		return codigo_productos;
	}
	public void setCodigo_productos(int codigo_productos) {
		this.codigo_productos = codigo_productos;
	}
	public double getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}
	public int getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	
	
}
