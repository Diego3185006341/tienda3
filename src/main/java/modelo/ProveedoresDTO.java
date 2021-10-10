package modelo;

public class ProveedoresDTO {
	int nitproveedor;
	String ciudad_proveedor;
	String direccion_proveedor;
	String nombre_proveedor;
	String telefono_proveedor;
	
	
	
	public ProveedoresDTO(int nitproveedor, String ciudad_proveedor, String direccion_proveedor, String nombre_proveedor,
			String telefono_proveedor) {

		this.nitproveedor = nitproveedor;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.telefono_proveedor = telefono_proveedor;
	}


	
	
	
	
	

	public ProveedoresDTO(int nitproveedor) {
	
		this.nitproveedor = nitproveedor;
	}








	public int getnitproveedor() {
		return nitproveedor;
	}



	public void setnitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}



	public String getciudad_proveedor() {
		return ciudad_proveedor;
	}



	public void setciudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}



	public String getdireccion_proveedor() {
		return direccion_proveedor;
	}



	public void setdireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}



	public String getnombre_proveedor() {
		return nombre_proveedor;
	}



	public void setnombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}



	public String gettelefono_proveedor() {
		return telefono_proveedor;
	}



	public void settelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}
	
	
}
