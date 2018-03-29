package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class ProfesorDAOMySQL implements IProfesorDAO{
	private Connection con;
	
	public ProfesorDAOMySQL(){
		this.con = DataSourceMySQL.getConexion();
	}
	
	@Override
	public void create(DTOProfesor pro) {
		PreparedStatement ps = null;
		
		String sql = "INSERT INTO Tbl_Profesores (Pro_Codigo,Pro_Nombre,Pro_Tel,Pro_Direccion,Pro_Cedula) VALUES(?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, pro.getCodigo());
			ps.setString(2, pro.getNombre());
			ps.setString(3, pro.getTelefono());
			ps.setString(4, pro.getDireccion());
			ps.setLong(5, pro.getCedula());
			ps.execute();
			
		}catch(SQLException ex) {
			System.err.println(ex);
			
		}
	}

	@Override
	public DTOProfesor read(int codigo) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Profesores WHERE Pro_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new DTOProfesor(rs.getInt("Pro_Codigo"),rs.getString("Pro_Nombre"),rs.getString("Pro_Tel"),rs.getString("Pro_Direccion"),rs.getLong("Pro_Cedula"));
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		return null;
	}

	@Override
	public void update(DTOProfesor pro) {
		PreparedStatement ps = null;
		String sql = "UPDATE Tbl_Profesores SET Pro_Nombre=?,Pro_Tel=?,Pro_Direccion=?,Pro_Cedula=? WHERE Pro_Codigo=?";
	
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(5, pro.getCodigo());
			ps.setString(1, pro.getNombre());
			ps.setString(2, pro.getTelefono());
			ps.setString(3, pro.getDireccion());
			ps.setLong(4, pro.getCedula());
			
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
	}

	@Override
	public void delete(DTOProfesor pro) {
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM Tbl_Profesores WHERE Pro_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, pro.getCodigo());
			ps.execute();
		}catch(SQLException ex) {
			System.err.println(ex);
		} 
		
	}

	@Override
	public boolean exist(DTOProfesor pro) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Tbl_Profesores WHERE Pro_Codigo=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, pro.getCodigo());
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
	public ArrayList<DTOProfesor> list() {
		ArrayList<DTOProfesor> lista = new ArrayList<DTOProfesor>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DTOProfesor pro = null;
		
		String sql = "SELECT * FROM Tbl_Profesores";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				 pro = new DTOProfesor(rs.getInt("Pro_Codigo"),rs.getString("Pro_Nombre"),rs.getString("Pro_Tel"),rs.getString("Pro_Direccion"),rs.getLong("Pro_Cedula"));
				 lista.add(pro);
			}
			
		}catch(SQLException ex) {
			System.err.println(ex);
		}
		
		return lista;
	}

}
