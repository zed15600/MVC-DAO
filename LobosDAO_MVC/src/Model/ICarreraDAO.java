package Model;

import java.util.ArrayList;

public interface ICarreraDAO {
	public void create(DTOCarrera car);
	public DTOCarrera read(int codigo);
	public void update(DTOCarrera car);
	public void delete(DTOCarrera car);
	public boolean exist(DTOCarrera car);
	public ArrayList<DTOCarrera> list();
	
}
