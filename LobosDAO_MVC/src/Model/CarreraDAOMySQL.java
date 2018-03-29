package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class CarreraDAOMySQL implements ICarreraDAO{
	
	private Connection con;
	
	public CarreraDAOMySQL(){
		this.con = DataSourceMySQL.getConexion();
	}
	
	
	@Override
	public void create(DTOCarrera car) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Tbl_Carreras (Car_Codigo,Car_Nombre,Car_Jefe_Carrera) VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, car.getCodigo());
			ps.setString(2, car.getNombre());
			ps.setLong(3, car.getJefeCarreraCodigo());
			ps.execute();
			
		}catch(SQLException ex) {
			System.err.println(ex);
			
		}
	}

	
	@Override
	public DTOCarrera read(int codigo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Carreras WHERE Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new DTOCarrera(rs.getInt("Car_Codigo"),rs.getString("Car_Nombre"),rs.getInt("Car_Jefe_Carrera"));
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return null;
	}

	@Override
	public void update(DTOCarrera car) {
		PreparedStatement ps = null;
		
		String sql = "UPDATE Tbl_Carreras SET Car_Nombre=?,Car_Jefe_Carrera=? WHERE Car_Codigo=?";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(3, car.getCodigo());
			ps.setString(1, car.getNombre());
			ps.setLong(2, car.getJefeCarreraCodigo());
			
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		} 
		
	}

	@Override
	public void delete(DTOCarrera car) {
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM Tbl_Carreras WHERE Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, car.getCodigo());
			ps.execute();
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
	}

	@Override
	public boolean exist(DTOCarrera car) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Carreras WHERE Car_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, car.getCodigo());
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
	public ArrayList<DTOCarrera> list() {
		ArrayList<DTOCarrera> lista = new ArrayList<DTOCarrera>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DTOCarrera car = null;
		
		String sql = "SELECT * FROM Tbl_Carreras";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 car = new DTOCarrera(rs.getInt("Car_Codigo"),rs.getString("Car_Nombre"),rs.getInt("Car_Jefe_Carrera"));
				 lista.add(car);
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
		return lista;
	}

}
