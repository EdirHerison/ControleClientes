package model.services;

import model.dao.DAOFactory;
import model.dao.VendedorDAO;
import model.entities.Vendedor;

public class VendedorService {

	private VendedorDAO dao = DAOFactory.cadVendedor();
	
	public void insereOuAtualiza(Vendedor vendedor) {
		if(vendedor.getId() == null) {
			dao.CadastraVendedor(vendedor);
		}
		else {
			dao.modificarVendedor(vendedor);
		}
	}
	
}
