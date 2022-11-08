package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;
import model.entities.Vendedor;

public class VendedorDAO {
	
	private Connection conn;
	
	public VendedorDAO(Connection conn) {
		this.conn = conn;
	}
	
	public void CadastraCliente(Vendedor vendedor) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO vendedora "
					+ "(COD_VENDEDORA, NOME, CPF) "
					+ "VALUES "
					+ "(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, vendedor.getCodigo());
			st.setString(2, vendedor.getNome());
			st.setString(3, vendedor.getCpf());
			
			int linhasAfetadas = st.executeUpdate();
			  if(linhasAfetadas > 0) {
				  rs =st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					vendedor.setId(id);
				}
			  } else {
				  throw new DBException("Erro ao salvar !!, nenhuma linha foi afetada");
			  }
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DB.closeStatent(st);
			DB.closeResultSet(rs);
		}
		
	}

}
