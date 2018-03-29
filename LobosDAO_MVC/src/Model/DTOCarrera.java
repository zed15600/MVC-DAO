package Model;

public final class DTOCarrera {
	// Atributos
	private int codigo;
	private String nombre;
	private int jefeCarreraCodigo;
	
	// Constructor
	public DTOCarrera(int codigo, String nombre, int jefeCarreraCodigo){
		this.codigo = codigo;
		this.nombre = nombre;
		this.jefeCarreraCodigo = jefeCarreraCodigo;
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
	
	
	public int getJefeCarreraCodigo(){
		return this.jefeCarreraCodigo;
	}
	
	public void setCarreraCodigo(int jefeCarreraCodigo){
		this.jefeCarreraCodigo = jefeCarreraCodigo;
	}
}
