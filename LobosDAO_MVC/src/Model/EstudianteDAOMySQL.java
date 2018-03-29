package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class EstudianteDAOMySQL implements IEstudianteDAO{
	
	private Connection con;
	
	public EstudianteDAOMySQL(){
		this.con = DataSourceMySQL.getConexion();
	}
	
	@Override
	public void create(DTOEstudiante est) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Tbl_Estudiantes (Est_Codigo,Est_Nombre,Est_Correo,Est_Tel,Est_Direccion,Est_Cedula) VALUES(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, est.getCodigo());
			ps.setString(2, est.getNombre());
			ps.setString(3, est.getCorreo());
			ps.setString(4, est.getTelefono());
			ps.setString(5, est.getDireccion());
			ps.setLong(6, est.getCedula());
			ps.execute();
			
		}catch(SQLException ex) {
			System.err.println(ex);
			
		} 
	}

	
	@Override
	public DTOEstudiante read(int codigo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Estudiantes WHERE Est_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new DTOEstudiante(rs.getInt("Est_Codigo"),rs.getString("Est_Nombre"),rs.getString("Est_Correo"),rs.getString("Est_Tel"),rs.getString("Est_Direccion"),rs.getLong("Est_Cedula"));
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return null; 
	}

	
	@Override
	public void update(DTOEstudiante est) {
		PreparedStatement ps = null;
		
		String sql = "UPDATE Tbl_Estudiantes SET Est_Nombre=?,Est_Correo=?,Est_Tel=?,Est_Direccion=?,Est_Cedula=? WHERE Est_Codigo=?";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(6, est.getCodigo());
			ps.setString(1, est.getNombre());
			ps.setString(2, est.getCorreo());
			ps.setString(3, est.getTelefono());
			ps.setString(4, est.getDireccion());
			ps.setLong(5, est.getCedula());
			
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		} 
		
	}

	@Override
	public void delete(DTOEstudiante est) {
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM Tbl_Estudiantes WHERE Est_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, est.getCodigo());
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		} 
		
	}

	@Override
	public boolean exist(DTOEstudiante est) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Estudiantes WHERE Est_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, est.getCodigo());
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
	public ArrayList<DTOEstudiante> list() {
		ArrayList<DTOEstudiante> lista = new ArrayList<DTOEstudiante>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DTOEstudiante est = null;
		
		String sql = "SELECT * FROM Tbl_Estudiantes";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 est = new DTOEstudiante(rs.getInt("Est_Codigo"),rs.getString("Est_Nombre"),rs.getString("Est_Correo"),rs.getString("Est_Tel"),rs.getString("Est_Direccion"),rs.getLong("Est_Cedula"));
				 lista.add(est);
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
		return lista;
	}

}
