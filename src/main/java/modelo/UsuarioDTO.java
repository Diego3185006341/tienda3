package modelo;


	public class UsuarioDTO {
		 private int cedula_usuario;
		 private String email_usuario;
		 private String nombre_usuario;
		 private String password;
		 private String usuario;
		 
		 
		 
		 public UsuarioDTO(int cedulausuario,String email, String nombreus, String password, String usuario) {
			this.cedula_usuario =cedulausuario ;
			this.email_usuario= email;
			this.nombre_usuario = nombreus;
			this.password =password;
			this.usuario = usuario;
		}
		 




		public UsuarioDTO(int cd) {
			this.cedula_usuario = cd;
		}





		public int getCedula_usuario() {
			return cedula_usuario;
		}





		public void setCedula_usuario(int cedula_usuario) {
			this.cedula_usuario = cedula_usuario;
		}





		public String getEmail_usuario() {
			return email_usuario;
		}





		public void setEmail_usuario(String email_usuario) {
			this.email_usuario = email_usuario;
		}





		public String getNombre_usuario() {
			return nombre_usuario;
		}





		public void setNombre_usuario(String nombre_usuario) {
			this.nombre_usuario = nombre_usuario;
		}





		public String getPassword() {
			return password;
		}





		public void setPassword(String password) {
			this.password = password;
		}





		public String getUsuario() {
			return usuario;
		}





		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}




		 
}
