package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;


public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemCadCliente;
	@FXML
	private MenuItem menuItemConsCliente;
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemNovaVenda;
	
	
	public void onMenuItemCadClienteAction() {
		carregaTela("/gui/CadCliFormView.fxml");
	}
	public void onMenuItemConsClienteAction() {
		carregaTela("/gui/ConsCliTabView.fxml");
	}
	
    public void onMenuItemVendedorAction() {
		carregaTela("/gui/VendedorFormView.fxml");
	}
    
    public void onMenuItemNovaVendaAction() {
    	carregaTela("/gui/VendasFormView.fxml");
	}
    
	
	private synchronized void carregaTela(String caminhoTela) {
		/*
		 * synchronized - impede que o processamento do metodo não 
		 * seja interrompido pela multitarefas geradas pelo carregamneto e utilização das telas
		 */
		try {
			FXMLLoader carregar = new FXMLLoader(getClass().getResource(caminhoTela));
			VBox novoVb = carregar.load();
			//Carregando nova tela na tela principal
			Scene cenaPrincipal = Main.getScene();
			VBox vbPrincipal = (VBox) ((ScrollPane) cenaPrincipal.getRoot()).getContent();
			//preservando o Menu da tela principal
			Node menuPrincipal = vbPrincipal.getChildren().get(0);
			vbPrincipal.getChildren().clear(); //limpa todos os filhos da VBox
			//adiciona os menus da nova janela na janela principal
			vbPrincipal.getChildren().add(menuPrincipal);
			vbPrincipal.getChildren().addAll(novoVb.getChildren());
			
			
		} catch (Exception e) {
			Alerts.showAlerts("Erro !!!", "Tela não carregada", "A tela não pode ser carregada: " + e.getMessage(), AlertType.ERROR);
		}
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
