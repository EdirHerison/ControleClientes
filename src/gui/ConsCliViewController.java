package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.entities.Clientes;
import model.services.ClienteService;

public class ConsCliViewController implements Initializable{
    
	@FXML
	private TableView<Clientes> tbViewCliente;
	
	private ClienteService service; //criando a dependencia;
	
	private ObservableList<Clientes> cliList;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}

	private void initializeNodes() {
		Stage stage = (Stage) Main.getScene().getWindow();
		tbViewCliente.prefHeightProperty().bind(stage.heightProperty());
		
	}
	
	public void setClienteService(ClienteService service) {
		this.service = service;
	}
	
	public void carregaList() {
		if (service == null) {
			throw new IllegalStateException("Não houve injeção de dependencia ao tentar carregar a lista");
		}
		List<Clientes> list = service.buscaTodos();
		cliList = FXCollections.observableArrayList(list);
		tbViewCliente.setItems(cliList);
	}
	

}
