package Model;

public final class DTOEstudiante {
	// Atributos
	private int codigo;
	private String nombre;
	private String correo;
	private String telefono;
	private String direccion;
	private long cedula;
	
	// Constructor
	public DTOEstudiante(int codigo, String nombre, String correo, String telefono, String direccion, long cedula){
		this.codigo = codigo;
		this.nombre = nombre;
		this.correo = correo;
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
	
	public String getCorreo(){
		return this.correo;
	}
	
	public void setCorreo(String correo){
		this.correo = correo;
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
