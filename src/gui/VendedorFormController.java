package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import db.DBException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Vendedor;
import model.services.VendedorService;


public class VendedorFormController implements Initializable{
    
	private Vendedor ved;
	private VendedorService service;
	
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
    
//####### injetando as dependencias ##########
    
    public void setVendedorEntidade (Vendedor ved) {
    	this.ved = ved;
    }
    
    public void setVendedorService (VendedorService service) {
    	this.service = service;
    }
    
//###########################################
    
    @FXML
    public void onBtSalvarAction() {
    	if(ved == null) {
    		throw new IllegalStateException("Não houve a injeção de dependecias: Entidade Vendedor");
    	}
    	if(service == null) {
    		throw new IllegalStateException("Não houve a injeção de dependecias: Serviços Vendedor");
    	}
    	try {
			ved = dadosDoForm();
			service.insereOuAtualiza(ved);
		} catch (DBException e) {
			Alerts.showAlerts("Erro ao salvar no banco", null,"Causa: " + e.getMessage() , AlertType.ERROR);
		}
    }
    
    public void modificaVendedor() { //depois vai virar o consultar vendedor
    	if(ved == null) {
    		throw new IllegalStateException("Não houve a injeção de dependecias: Entidade Vendedor");
    	}
    	LbId.setText(String.valueOf(ved.getId()));
    	TxtCodigo.setText(String.valueOf(ved.getCodigo()));
    	TxtCpf.setText(ved.getCpf());
    	TxtNome.setText(ved.getNome());
    }

	
	private Vendedor dadosDoForm() {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(Utils.tryParsetoInt(LbId.getText()));
		vendedor.setCodigo(Utils.tryParsetoInt(TxtCodigo.getText()));
		vendedor.setCpf(TxtCpf.getText());
		vendedor.setNome(TxtNome.getText());
		
		return vendedor;
	}
	
	@Override
	public void initialize(URL aurl, ResourceBundle rb) {
		
	}
	
	private void iniciaNodes() {
		Constraints.setTextFieldInteger(TxtCodigo);
		Constraints.setTextFieldInteger(TxtCpf);
		Constraints.setTextFieldMaxLength(TxtNome, 100);
	}
	

}
