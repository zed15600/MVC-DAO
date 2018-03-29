package Model;

import java.util.ArrayList;

public interface IProfesorDAO {
	public void create(DTOProfesor pro);   // C
	public DTOProfesor read(int codigo);   // R
	public void update(DTOProfesor pro);   // U
	public void delete(DTOProfesor pro);   // D
	public boolean exist(DTOProfesor pro); // E
	public ArrayList<DTOProfesor> list();  // L
}
