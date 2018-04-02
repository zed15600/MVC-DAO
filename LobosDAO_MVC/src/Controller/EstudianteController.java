package Controller;

import java.util.ArrayList;

import Model.DTOEstudiante;
import Model.EstudianteDAOMySQL;
import Model.IEstudianteDAO;

public class EstudianteController {
	private IEstudianteDAO dao;
	
	public EstudianteController(){
		this.dao = new EstudianteDAOMySQL();
	}
	
	public boolean crear(int cod, String nombre, String correo, String telefono, String direccion, long ced){
		DTOEstudiante dtoEst = new DTOEstudiante(cod,nombre,correo,telefono,direccion,ced);
		// Verificar que se pueda crear
		if(!dao.exist(dtoEst)) {
			dao.create(dtoEst);
			return true;
		}
		
		return false;
	}
	
	
	public DTOEstudiante leer(int code){
		return dao.read(code);
	}
	
	
	public boolean actualizar(int cod, String nombre, String correo, String telefono, String direccion, long ced){
		DTOEstudiante dtoEst = new DTOEstudiante(cod,nombre,correo,telefono,direccion,ced);
		// Verificar que se pueda actualizar
		if(dao.exist(dtoEst)) {
			dao.update(dtoEst);
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean borrar(int cod, String nombre, String correo, String telefono, String direccion, long ced){
		DTOEstudiante dtoEst = new DTOEstudiante(cod,nombre,correo,telefono,direccion,ced);
		// Verificar que se pueda eliminar

		if(dao.exist(dtoEst)) {
			dao.delete(dtoEst);;
			return true;
		}
		return false;
	}
	
	public boolean existe(int cod, String nombre, String correo, String telefono, String direccion, long ced){
		DTOEstudiante dtoEst = new DTOEstudiante(cod,nombre,correo,telefono,direccion,ced);
		return dao.exist(dtoEst);
	}
	
	public ArrayList<Object[]> listar(){
		ArrayList<DTOEstudiante> dtoList = dao.list();
		ArrayList<Object[]> ao = new ArrayList<Object[]>();
		DTOEstudiante dtoEst;
		
		for(int i=0; i<dtoList.size(); i++) {
			dtoEst = dtoList.get(i);
			ao.add(new Object[]{ dtoEst.getCodigo()+"", dtoEst.getNombre(),dtoEst.getCorreo(), dtoEst.getTelefono(), dtoEst.getDireccion(), dtoEst.getCedula()+""});
		}
		return ao;
	}
}
