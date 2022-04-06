package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
		main.setPrefHeight(550);
		main.setPrefWidth(1350);
		createGrid();
	}
	
	private void createGrid() {
		
		GridPane playerGrid = new GridPane();
		for (int i = 0; i < 27; i++) {
			playerGrid.getRowConstraints().add(new RowConstraints(50));
			playerGrid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		
		for (int i = 0; i < 11; i++) {
			for(int j = 0; j <11; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				if (j >= 1 && j < 11 && i == 0) {
					button.setText(firstRowCheck(j));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i >= 1 && i < 11 && j == 0) {
					button.setText(Integer.toString(i));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i == 0 && j == 0){
					button.setText("+");
					button.setStyle("-fx-font-size: 1.25em; ");
				}
				GridPane.setConstraints(button, j, i);
				playerGrid.getChildren().add(button);
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						if ((GridPane.getRowIndex(button) >= 0 && GridPane.getRowIndex(button) < 11 && GridPane.getColumnIndex(button) == 0) || (GridPane.getColumnIndex(button) >= 0 && GridPane.getColumnIndex(button) < 11 && GridPane.getRowIndex(button) == 0)) {
						}
						else {
							System.out.println("Column " + (firstRowCheck(GridPane.getColumnIndex(button))));
							System.out.println("Row: " + (GridPane.getRowIndex(button)));
							button.setStyle("-fx-background-color: black;");
						}
					}
				});
			}
		}
		
		for (int i = 0; i < 11; i++) {
			for(int j = 16; j <27; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				if (j >= 17 && j < 27 && i == 0) {
					button.setText(firstRowCheck(j));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i >= 1 && i < 11 && j == 16) {
					button.setText(Integer.toString(i));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i == 0 && j == 16){
					button.setText("+");
					button.setStyle("-fx-font-size: 1.25em; ");
				}
				GridPane.setConstraints(button, j, i);
				playerGrid.getChildren().add(button);
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						if ((GridPane.getRowIndex(button) >= 0 && GridPane.getRowIndex(button) < 11 && GridPane.getColumnIndex(button) == 16) || (GridPane.getColumnIndex(button) >= 16 && GridPane.getColumnIndex(button) < 27 && GridPane.getRowIndex(button) == 0)) {
						}
						else {
							System.out.println("Column " + (firstRowCheck(GridPane.getColumnIndex(button))));
							System.out.println("Row: " + (GridPane.getRowIndex(button)));
							button.setStyle("-fx-background-color: red;");
						}
					}
				});
			}
		
		}	
		main.getChildren().add(playerGrid);
		
	}
	
	public Pane getRoot() {
		return main;
	}
	
	private String firstRowCheck(int c) {
		if (c == 1 || c == 17) {
			return "A";
		}
		else if (c == 2 || c == 18) {
			return "B";
		}
		else if (c == 3 || c == 19) {
			return "C";
		}
		else if (c == 4 || c == 20) {
			return "D";
		}
		else if (c == 5 || c == 21) {
			return "E";
		}
		else if (c == 6 || c == 22) {
			return "F";
		}
		else if (c == 7 || c == 23) {
			return "G";
		}
		else if (c == 8 || c == 24) {
			return "H";
		}
		else if (c == 9 || c == 25) {
			return "I";
		}
		else {
			return "J";
		}
	}
	
	
}


