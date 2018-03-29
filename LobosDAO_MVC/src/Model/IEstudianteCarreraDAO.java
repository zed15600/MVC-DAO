package Model;

import java.util.ArrayList;

public interface IEstudianteCarreraDAO {
	public void create(DTOEstudianteCarrera ec);
	public DTOEstudianteCarrera read(int codigo);
	public void update(DTOEstudianteCarrera ec);
	public void delete(DTOEstudianteCarrera ec);
	public boolean exist(DTOEstudianteCarrera ec);
	public ArrayList<DTOEstudianteCarrera> list();
}
