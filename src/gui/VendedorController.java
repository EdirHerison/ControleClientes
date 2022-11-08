package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class VendedorController implements Initializable{
    @FXML
	private Label LbId;
    @FXML
    private TextField TxtCodigo;
    @FXML
    private TextField TxtCpf;
    @FXML
    private TextField TxtNome;
    @FXML
    private Button BtSalvar;
    
    @FXML
    public void onBtSalvarAction() {
    	System.out.println("Salvar Novo Vendedor");
    }
	
	@Override
	public void initialize(URL aurl, ResourceBundle rb) {	
	}

}
