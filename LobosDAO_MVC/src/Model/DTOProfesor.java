package Model;

public final class DTOProfesor {
	// Atributos
		private int codigo;
		private String nombre;
		private String telefono;
		private String direccion;
		private long cedula;
		
		// Constructor
		public DTOProfesor(int codigo, String nombre, String telefono, String direccion, long cedula){
			this.codigo = codigo;
			this.nombre = nombre;
			this.telefono = telefono;
			this.direccion = direccion;
			this.cedula = cedula;
		}
		
		// Metodos Get y Set
		public int getCodigo(){
			return this.codigo;
		}
		
		public String getNombre(){
			return this.nombre;
		}
		
		public void setNombre(String nombre){
			this.nombre = nombre;
		}
		
		public String getTelefono(){
			return this.telefono;
		}
		
		public void setTelefono(String telefono){
			this.telefono = telefono;
		}
		
		public String getDireccion(){
			return this.direccion;
		}
		
		public void setDireccion(String direccion){
			this.direccion = direccion;
		}
		
		public long getCedula(){
			return this.cedula;
		}
		
		public void setCedula(long cedula){
			this.cedula = cedula;
		}
}
