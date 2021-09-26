package modelo;

public class Empleados 
{
	int IdEmpleado;
	String Dni;
	String Nombres;
	String Telefono;
	String Estado;
	String User;
	
	public Empleados() {
		
	}

	public Empleados(int idEmpleado, String dni, String nombres, String telefono, String estado, String user) {
		this.IdEmpleado = idEmpleado;
		this.Dni = dni;
		this.Nombres = nombres;
		this.Telefono = telefono;
		this.Estado = estado;
		this.User = user;
	}

	public int getIdEmpleado() {
		return IdEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}
	
	
}
