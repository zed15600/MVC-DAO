package Controller;

import java.util.ArrayList;

import Model.*;

public class CarreraController {
	private ICarreraDAO daoC;
	private IProfesorDAO daoP;
	
	public CarreraController(){
		this.daoC = new CarreraDAOMySQL();
		this.daoP = new ProfesorDAOMySQL();
	}
	
	public boolean crear(int codigo, String nombre, int jefeCarreraCodigo){
		DTOCarrera dtoCar = new DTOCarrera(codigo,nombre,jefeCarreraCodigo);
		DTOProfesor dtoPro = daoP.read(jefeCarreraCodigo);
		// Verificar que se pueda crear
		if(!daoC.exist(dtoCar) && daoP.exist(dtoPro)) {
			daoC.create(dtoCar);
			return true;
		}
		
		return false;
	}
	
	
	public DTOCarrera leer(int code){
		return daoC.read(code);
	}
	
	
	public boolean actualizar(int codigo, String nombre, int jefeCarreraCodigo){
		DTOCarrera dtoCar = new DTOCarrera(codigo,nombre,jefeCarreraCodigo);
		DTOProfesor dtoPro = daoP.read(jefeCarreraCodigo);
		// Verificar que se pueda actualizar
		if(daoC.exist(dtoCar) && daoP.exist(dtoPro)) {
			daoC.update(dtoCar);
			return true;
		}
		
		return false;
	}
	
	
	
	
	public boolean borrar(int codigo, String nombre, int jefeCarreraCodigo){
		DTOCarrera dtoCar = new DTOCarrera(codigo,nombre,jefeCarreraCodigo);
		// Verificar que se pueda borrar
		if(daoC.exist(dtoCar)) {
			daoC.delete(dtoCar);
			return true;
		}
		
		return false;
	}
	
	public boolean existe(int codigo, String nombre, int jefeCarreraCodigo){
		DTOCarrera dtoCar = new DTOCarrera(codigo,nombre,jefeCarreraCodigo);
		return daoC.exist(dtoCar);
	}
	
	public ArrayList<Object[]> listar(){
		ArrayList<DTOCarrera> dtoList = daoC.list();
		ArrayList<Object[]> ao = new ArrayList<Object[]>();
		DTOCarrera dtoEst;
		
		for(int i=0; i<dtoList.size(); i++) {
			dtoEst = dtoList.get(i);
			ao.add(new Object[]{ dtoEst.getCodigo()+"", dtoEst.getNombre(), dtoEst.getJefeCarreraCodigo()+""});
		}
		return ao;
	}
	
	
}
