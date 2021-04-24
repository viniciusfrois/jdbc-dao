package models.dao.implemento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

				Departamento dep = new Departamento();
				dep.setId(rs.getInt("DepartamentoId"));
				dep.setNome(rs.getString("DepNome"));

				Vendedor vend = new Vendedor();
				vend.setId(rs.getInt("Id"));
				vend.setNome(rs.getString("Nome"));
				vend.setEmail(rs.getString("Email"));
				vend.setSalario(rs.getDouble("Salario"));
				vend.setDataNascimento(rs.getDate("DataNascimento"));
				vend.setDepartamento(dep);
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

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
