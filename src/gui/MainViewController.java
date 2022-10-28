package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemCliente;
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemNovaVenda;
	@FXML
	private MenuItem menuItemModificarVenda;
	
	
	public void onMenuItemClienteAction() {
		
	}
	
    public void onMenuItemVendedorAction() {
		
	}
    
    public void onMenuItemNovaVendaAction() {
    	//loadView("/gui/SellerList.fxml", x -> {});
    	System.out.println("Nova Venda");
	}
    
    public void onMenuItemModifcaVendaAction() {
    	System.out.println("Modificar venda");
	}
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
