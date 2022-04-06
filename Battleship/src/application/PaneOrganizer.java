package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class PaneOrganizer {
	
	private BorderPane main;
	public PaneOrganizer() {
		main = new BorderPane();
		main.setStyle("-fx-background-color: grey;");
		main.setPrefHeight(500);
		main.setPrefWidth(500);
		createGrid();
	}
	
	private void createGrid() {
		GridPane playerGrid = new GridPane();
		for (int i = 0; i < 10; i++) {
			playerGrid.getColumnConstraints().add(new ColumnConstraints(50));
			playerGrid.getRowConstraints().add(new RowConstraints(50));
		}
		for (int i = 0; i <10; i++) {
			for(int j = 0; j <10; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				GridPane.setConstraints(button, j, i);
				playerGrid.getChildren().add(button);
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						System.out.println("Row: " + GridPane.getRowIndex(button));
						System.out.println("Column " + GridPane.getColumnIndex(button));
						button.setStyle("-fx-background-color: black;");
					}
				});
			}
			
		}
		main.getChildren().add(playerGrid);
	}
	
	public Pane getRoot() {
		return main;
	}
	
}

