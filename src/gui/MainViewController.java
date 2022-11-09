package gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.ClienteService;


public class MainViewController implements Initializable{
	@FXML
	private MenuItem menuItemCadCliente;
	@FXML
	private MenuItem menuItemConsCliente;
	@FXML
	private MenuItem menuItemVendedor;
	@FXML
	private MenuItem menuItemNovaVenda;
	
	@FXML
	public void onMenuItemCadClienteAction() {
		carregaTela("/gui/CadCliFormView.fxml", x -> {});
	}
	@FXML
	public void onMenuItemConsClienteAction() {
		/*
		 * Expressão Lambda 
		 * () - parametro da expressão: composto ( tipo + nome identificação)
		 * -> {} - implenta a função, diz o que a expressão vai realizar
		 */
		carregaTela("/gui/ConsCliTabView.fxml", (ConsCliViewController controller) -> {
			controller.setClienteService(new ClienteService());
			controller.carregaList();
		});
	}
	
	@FXML
    public void onMenuItemVendedorAction() {
		carregaTela("/gui/VendedorFormView.fxml", x -> {});
	}
    
	@FXML
    public void onMenuItemNovaVendaAction() {
    	carregaTela("/gui/VendasFormView.fxml", x -> {});
	}
    
	
	private synchronized <T> void carregaTela(String caminhoTela, Consumer<T> acaoDeInicializacao) {
		/*
		 * synchronized - impede que o processamento do metodo não 
		 * seja interrompido pela multitarefa geradas pelo carregamento e utilização das telas.
		 * Consumer - feito para que haja a chamada do controller no método que faz a chamada da tela
		 * e tmbm para que a expressão lambda seja reconhecida.
		 * <T> - paramatriza a identificação do tipo de Consumer, pode ser qualquer letra, isso é um tipo generico.  
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
			/*
			 * atribuindo um tipo ao controlador, para que assim possa chamar qualquer 
			 * tipo que for usado nos metodos de chamada de tela
			 * as duas linhas a seguir servem para executar a função lambda lá do metodo.
			 */
			T controller = carregar.getController();
			acaoDeInicializacao.accept(controller);
			
			
		} catch (Exception e) {
			Alerts.showAlerts("Erro !!!", "Tela não carregada", "A tela não pode ser carregada: " + e.getMessage(), AlertType.ERROR);
		}
		
	}
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
