package Model;

public final class DTOEstudianteCarrera {
	// Atributos
	private int codigo;
	private int codigoEstudiante;
	private int codigoCarrera;
	
	// Constructor
	public DTOEstudianteCarrera(int codigo, int codigoEstudiante, int codigoCarrera){
		this.codigo = codigo;
		this.codigoEstudiante = codigoEstudiante;
		this.codigoCarrera = codigoCarrera;
	}
	
	// Metodos Get y Set
	public int getCodigo(){
		return this.codigo;
	}
	
	public int getCodigoEstudiante(){
		return this.codigoEstudiante;
	}
	
	public void setCodigoEstudiante(int codigoEstudiante){
		this.codigoEstudiante = codigoEstudiante;
	}
	
	public int getCodigoCarrera(){
		return this.codigoCarrera;
	}
	
	public void setCodigoCarrera(int codigoCarrera){
		this.codigoCarrera = codigoCarrera;
	}
}
