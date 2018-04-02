package Controller;

import java.util.ArrayList;

import Model.DTOEstudiante;
import Model.DTOProfesor;
import Model.ProfesorDAOMySQL;
import Model.IProfesorDAO;

public class ProfesorController {
private IProfesorDAO dao;
	
	public ProfesorController(){
		this.dao = new ProfesorDAOMySQL();
	}
	
	public boolean crear(int cod, String nombre, String telefono, String direccion, long ced){
		DTOProfesor dtoPro = new DTOProfesor(cod,nombre,telefono,direccion,ced);
		// Verificar que se pueda crear
		if(!dao.exist(dtoPro)) {
			dao.create(dtoPro);
			return true;
		}
		
		return false;
	}
	
	
	public DTOProfesor leer(int code){
		return dao.read(code);
	}
	
	
	public boolean actualizar(int cod, String nombre, String telefono, String direccion, long ced){
		DTOProfesor dtoPro = new DTOProfesor(cod,nombre,telefono,direccion,ced);
		// Verificar que se pueda actualizar
		if(dao.exist(dtoPro)) {
			dao.update(dtoPro);
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean borrar(int cod, String nombre, String telefono, String direccion, long ced){
		DTOProfesor dtoPro = new DTOProfesor(cod,nombre,telefono,direccion,ced);
		// Verificar que se pueda eliminar
		if(dao.exist(dtoPro)) {
			dao.delete(dtoPro);;
			return true;
		}
		return false;
	}
	
	public boolean existe(int cod, String nombre, String telefono, String direccion, long ced){
		DTOProfesor dtoPro = new DTOProfesor(cod,nombre,telefono,direccion,ced);
		return dao.exist(dtoPro);
	}
	
	public ArrayList<Object[]> listar(){
		ArrayList<DTOProfesor> dtoList = dao.list();
		ArrayList<Object[]> ao = new ArrayList<Object[]>();
		DTOProfesor dtoEst;
		
		for(int i=0; i<dtoList.size(); i++) {
			dtoEst = dtoList.get(i);
			ao.add(new Object[]{ dtoEst.getCodigo()+"", dtoEst.getNombre(), dtoEst.getTelefono(), dtoEst.getDireccion(), dtoEst.getCedula()+""});
		}
		return ao;
	}
}
