package model.dao;

import db.DB;
import model.dao.impl.VendedorDAOJDBC;

/*
 * classe para instanciar os DAOS
 * e fazer a injeção de dependencias
 */
public class DAOFactory {

	public static VendedorDAO cadVendedor() {
		return new VendedorDAOJDBC(DB.getConnection());
	}
	
}
