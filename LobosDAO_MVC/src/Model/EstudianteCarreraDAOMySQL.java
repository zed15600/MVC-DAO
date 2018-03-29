package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class EstudianteCarreraDAOMySQL implements IEstudianteCarreraDAO{
	private Connection con;
	
	public EstudianteCarreraDAOMySQL(){
		this.con = DataSourceMySQL.getConexion();
	}

	
	@Override
	public void create(DTOEstudianteCarrera ec) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Tbl_Estudiante_Carrera (Est_Car_Codigo, Est_Car_Codigo_Estudiante, Est_Car_Codigo_Carrera) VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, ec.getCodigo());
			ps.setLong(2, ec.getCodigoEstudiante());
			ps.setLong(3, ec.getCodigoCarrera());
			ps.execute();
			
		}catch(SQLException ex) {
			System.err.println(ex);
			
		}
	}

	
	@Override
	public DTOEstudianteCarrera read(int codigo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Estudiante_Carrera WHERE Est_Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new DTOEstudianteCarrera(rs.getInt("Est_Car_Codigo"),rs.getInt("Est_Car_Codigo_Estudiante"),rs.getInt("Est_Car_Codigo_Carrera"));
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return null;
	}

	
	
	@Override
	public void update(DTOEstudianteCarrera ec) {
		PreparedStatement ps = null;
		
		String sql = "UPDATE Tbl_Estudiante_Carrera SET Est_Car_Codigo_Estudiante=?,Est_Car_Codigo_Carrera=? WHERE Est_Car_Codigo=?";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(3, ec.getCodigo());
			ps.setLong(1, ec.getCodigoEstudiante());
			ps.setLong(2, ec.getCodigoCarrera());
			
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		} 
		
	}

	
	@Override
	public void delete(DTOEstudianteCarrera ec) {
		PreparedStatement ps = null;
		String sql = "DELETE FROM Tbl_Estudiante_Carrera WHERE Est_Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, ec.getCodigo());
			ps.execute();

		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
	}

	
	@Override
	public boolean exist(DTOEstudianteCarrera ec) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Estudiante_Carrera WHERE Est_Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, ec.getCodigo());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return false;
	}

	@Override
	public ArrayList<DTOEstudianteCarrera> list() {
		ArrayList<DTOEstudianteCarrera> lista = new ArrayList<DTOEstudianteCarrera>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DTOEstudianteCarrera ec = null;
		
		String sql = "SELECT * FROM Tbl_Estudiante_Carrera";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 ec = new DTOEstudianteCarrera(rs.getInt("Est_Car_Codigo"),rs.getInt("Est_Car_Codigo_Estudiante"),rs.getInt("Est_Car_Codigo_Carrera"));
				 lista.add(ec);
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
		return lista;
	}
}
