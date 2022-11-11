package model.dao;

import java.util.List;

/*
 * Feito como INTERFACE pois, é mais maleavel caso haja uma mudança de Banco de dados 
 * siando de um SQL para um Postgress.
 * ou ate mesmo de tecnologia
 */


import model.entities.Vendedor;

public interface VendedorDAO {

	void CadastraVendedor(Vendedor vendedor);
	void consultaVendedor(Vendedor vendedor);
	void modificarVendedor(Vendedor vendedor);
	List<Vendedor> buscaTodosVendedor();
}
