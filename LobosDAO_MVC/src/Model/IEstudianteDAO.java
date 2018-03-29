package Model;

import java.util.ArrayList;

public interface IEstudianteDAO {
	public void create(DTOEstudiante est);   // C
	public DTOEstudiante read(int codigo);   // R
	public void update(DTOEstudiante est);   // U
	public void delete(DTOEstudiante est);   // D
	public boolean exist(DTOEstudiante est); // E
	public ArrayList<DTOEstudiante> list();  // L
}
