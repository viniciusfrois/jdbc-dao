package models.dao.implemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DBConnect;
import db.DbException;
import models.Departamento;
import models.Vendedor;
import models.dao.VendedorDAO;

public class VendedorDaoJDBC implements VendedorDAO {

	private Connection conn;

	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarById(Vendedor obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor buscarId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			"SELECT vendedor.*,departamento.Nome as DepNome " 
			+ "FROM vendedor INNER JOIN departamento "
			+ "ON vendedor.DepartamentoId = departamento.Id " 
			+ "WHERE vendedor.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {

				Departamento dep = instanciaDepartamento(rs);
				Vendedor vend = instanciaVendedor(rs, dep);
				return vend;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DBConnect.closeStatement(st);
			DBConnect.closeResultSet(rs);
		}

	}
	
	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartamentoId"));
		dep.setNome(rs.getString("DepNome"));
		return dep;
	}
	
	private Vendedor instanciaVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor vend = new Vendedor();
		vend.setId(rs.getInt("Id"));
		vend.setNome(rs.getString("Nome"));
		vend.setEmail(rs.getString("Email"));
		vend.setSalario(rs.getDouble("Salario"));
		vend.setDataNascimento(rs.getDate("DataNascimento"));
		vend.setDepartamento(dep);
		return vend;
	}

	@Override
	public List<Vendedor> buscarTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			"SELECT vendedor.*,departamento.Nome as DepNome " 
			+ "FROM vendedor INNER JOIN departamento "
			+ "ON vendedor.DepartamentoId = departamento.Id " 
			+ "ORDER BY Nome");
						
			rs = st.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {				
				Departamento dep = map.get(rs.getInt("DepartamentoId"));
				if (dep==null) {
					dep = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartamentoId"), dep);
				}				
				Vendedor vend = instanciaVendedor(rs, dep);
				lista.add(vend);
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DBConnect.closeStatement(st);
			DBConnect.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> buscarDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
			"SELECT vendedor.*,departamento.Nome as DepNome " 
			+ "FROM vendedor INNER JOIN departamento "
			+ "ON vendedor.DepartamentoId = departamento.Id " 
			+ "WHERE departamento.Id = ? ORDER BY Nome");
			
			st.setInt(1, departamento.getId());			
			rs = st.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while (rs.next()) {				
				Departamento dep = map.get(rs.getInt("DepartamentoId"));
				if (dep==null) {
					dep = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartamentoId"), dep);
				}				
				Vendedor vend = instanciaVendedor(rs, dep);
				lista.add(vend);
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DBConnect.closeStatement(st);
			DBConnect.closeResultSet(rs);
		}
	}

}
