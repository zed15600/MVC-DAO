package Model;

public class principal {

	public static void main(String[] args) {
		System.out.println("Probar Estudiantes --------------------------");
		probarEstudiantes();
		System.out.println("Probar Profesores ---------------------------");
		probarProfesores();
		System.out.println("Probar Carreras -----------------------------");
		probarCarreras();
		System.out.println("Probar Estudiantes-Carreras -----------------");
		probarEstudiantesCarreras();
	}
	
	public static void probarEstudiantes(){
		DTOEstudiante est1 = new DTOEstudiante(123,"Miguel","3128705570","lmarinl1@eafit.edu.co","Calle 70 sur Nro 30 c 35",1039470883);
		DTOEstudiante est2 = new DTOEstudiante(124,"Maria","3128705523","lmarial@eafit.edu.co","Calle 75 sur Nro 3 c 5",1039470856);
		EstudianteDAOMySQL edm = new EstudianteDAOMySQL();
		// Create
		edm.create(est1);
		edm.create(est2);
		System.out.println("Se crearon exitosamente");
		
		// Read 
		DTOEstudiante est3 = edm.read(124);
		System.out.println("Se leyo a "+est3.getNombre());
		
		// Update
		est3.setNombre("Mary");
		edm.update(est3);
		System.out.println("Se actualizo Maria a "+est3.getNombre());
		
		// Delete
		edm.delete(est1);
		System.out.println("Se borro Migue!");
		
		// Exist
		if(!edm.exist(est1)){
			System.out.println("Ya no existe migue!");
		}else {
			System.out.println("QUE RARO");
		}
		
		DTOEstudiante est4 = new DTOEstudiante(125,"Miguel","3128705570","lmarinl1@eafit.edu.co","Calle 70 sur Nro 30 c 35",1039470883);
		DTOEstudiante est5 = new DTOEstudiante(126,"Miguel","3128705570","lmarinl1@eafit.edu.co","Calle 70 sur Nro 30 c 35",1039470883);
		edm.create(est4);
		edm.create(est5);
		System.out.println("Hay "+edm.list().size()+" estudiantes.");
	}
	
	
	public static void probarProfesores(){
		DTOProfesor pro1 = new DTOProfesor(999,"Edwin","3128705570","Calle 70 sur Nro 30 c 35",1039470883);
		DTOProfesor pro2 = new DTOProfesor(111,"Liliana","3128705523","Calle 75 sur Nro 3 c 5",1039470856);
		ProfesorDAOMySQL pdm = new ProfesorDAOMySQL();
		// Create
		pdm.create(pro1);
		pdm.create(pro2);
		System.out.println("Se crearon exitosamente");
		
		// Read 
		DTOProfesor pro3 = pdm.read(111);
		System.out.println("Se leyo a "+pro3.getNombre());
		
		// Update
		pro3.setNombre("Lily");
		pdm.update(pro3);
		System.out.println("Se actualizo Liliana a "+pro3.getNombre());
		
		// Delete
		pdm.delete(pro1);
		System.out.println("Se borro Edwin!");
		
		// Exist
		if(!pdm.exist(pro1)){
			System.out.println("Ya no existe edwin!");
		}else {
			System.out.println("QUE RARO");
		}
		
		DTOProfesor pro4 = new DTOProfesor(555,"Sofia","3128705570","Calle 70 sur Nro 30 c 35",1039470883);
		DTOProfesor pro5 = new DTOProfesor(888,"Doris","3128705570","Calle 70 sur Nro 30 c 35",1039470883);
		pdm.create(pro4);
		pdm.create(pro5);
		System.out.println("Hay "+pdm.list().size()+" Profesores.");
	}
	
	public static void probarCarreras(){
		DTOCarrera car1 = new DTOCarrera(010,"Ingenieria de sistemas",888);
		DTOCarrera car2 = new DTOCarrera(011,"Literatura",555);
		CarreraDAOMySQL cdm = new CarreraDAOMySQL();
		// Create
		cdm.create(car1);
		cdm.create(car2);
		System.out.println("Se crearon exitosamente");
		
		// Read 
		DTOCarrera car3 = cdm.read(011);
		System.out.println("Se leyo a "+car3.getNombre());
		
		// Update
		car3.setNombre("Literatura Renacentista");
		cdm.update(car3);
		System.out.println("Se actualizo Literatura a "+car3.getNombre());
		
		// Delete
		cdm.delete(car1);
		System.out.println("Se borro Ingenieria de sistemas!");
		
		// Exist
		if(!cdm.exist(car1)){
			System.out.println("Ya no existe Ingenieria de sistemas!");
		}else {
			System.out.println("QUE RARO");
		}
		
		DTOCarrera car4 = new DTOCarrera(012,"Administracion",555);
		DTOCarrera car5 = new DTOCarrera(013,"Finanzas",888);
		cdm.create(car4);
		cdm.create(car5);
		System.out.println("Hay "+cdm.list().size()+" Carreras.");
	}
	
	public static void probarEstudiantesCarreras(){
		DTOEstudianteCarrera ec1 = new DTOEstudianteCarrera(000,124,011);
		DTOEstudianteCarrera ec2 = new DTOEstudianteCarrera(001,125,012);
		EstudianteCarreraDAOMySQL ecdm = new EstudianteCarreraDAOMySQL();
		// Create
		ecdm.create(ec1);
		ecdm.create(ec2);
		System.out.println("Se crearon exitosamente");
		
		// Read 
		DTOEstudianteCarrera ec3 = ecdm.read(001);
		System.out.println("Se leyo a la relacion  con codigo "+ec3.getCodigo());
		
		// Update
		ec3.setCodigoCarrera(013);
		ecdm.update(ec3);
		System.out.println("Se actualizo la relacion con codigo "+ec3.getCodigo());
		
		// Delete
		ecdm.delete(ec3);
		System.out.println("El estudiante con codigo "+ec3.getCodigoEstudiante()+", ya no estudia la carrera con codigo "+ec3.getCodigoCarrera());
		
		// Exist
		if(!ecdm.exist(ec3)){
			System.out.println("Ya no existe La relacion previamente mencionada!");
		}else {
			System.out.println("QUE RARO");
		}
		
		DTOEstudianteCarrera ec4 = new DTOEstudianteCarrera(002,124,013);
		DTOEstudianteCarrera ec5 = new DTOEstudianteCarrera(003,126,011);
		ecdm.create(ec4);
		ecdm.create(ec5);
		System.out.println("Hay "+ecdm.list().size()+" Relaciones entre estudiantes y carreras");
	}
	
}
