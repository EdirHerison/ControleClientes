package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.entities.Clientes;

public class ConsCliViewController implements Initializable{
    
	@FXML
	private TableView<Clientes> tbViewCliente;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		initializeNodes();
	}

	private void initializeNodes() {
		Stage stage = (Stage) Main.getScene().getWindow();
		tbViewCliente.prefHeightProperty().bind(stage.heightProperty());
		
	}
	

}
