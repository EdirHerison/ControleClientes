package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollpane = loader.load();
			scrollpane.setFitToHeight(true);
			scrollpane.setFitToWidth(true);
			scene = new Scene(scrollpane);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Controle de Clientes Rommanel");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static Scene getScene() {
		return scene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
