package application;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Battleship");
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene (organizer.getRoot());
		primaryStage.setScene(scene);
		primaryStage.show();
	}	
	public static void main(String[] args) {
		launch(args);
	}

}

