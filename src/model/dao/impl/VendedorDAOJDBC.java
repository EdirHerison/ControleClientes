package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DBException;
import model.dao.VendedorDAO;
import model.entities.Vendedor;

public class VendedorDAOJDBC implements VendedorDAO{
	
	private Connection conn;
	
	public VendedorDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void CadastraVendedor(Vendedor vendedor) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO vendedora "
					+ "(COD_VENDEDORA, NOME, CPF) "
					+ "VALUES "
					+ "(?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, vendedor.getCodigo());
			st.setString(2, vendedor.getNome());
			st.setString(3, vendedor.getCpf());
			
			int linhasAfetadas = st.executeUpdate();
			
			//testando se foi inserido
			if(linhasAfetadas > 0 ) {
				rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					vendedor.setId(id);
				}
			}
			else {
				throw new DBException("Erro!! Vendedor não cadastrado");
			}
			
		} catch (Exception e) {
			throw new DBException(e.getMessage());
		}
		
		finally {
			DB.closeResultSet(rs);
			DB.closeStatent(st);
		}
	}

	@Override
	public void consultaVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vendedor> buscaTodosVendedor() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
