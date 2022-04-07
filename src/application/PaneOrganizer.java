package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class PaneOrganizer implements Battle {
	
	private BorderPane main;
	
	public PaneOrganizer() {
		main = new BorderPane();
		main.setStyle("-fx-background-color: grey;");
		main.setPrefHeight(550);
		main.setPrefWidth(1350);
		createGrid();
	}
	
	public void createGrid() {
		
		GridPane playerGrid = new GridPane();
		for (int i = 0; i < 11; i++) {
			playerGrid.getRowConstraints().add(new RowConstraints(50));
			playerGrid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		
		playerGrid.getRowConstraints().add(new RowConstraints(550));
		playerGrid.getColumnConstraints().add(new ColumnConstraints(250));
		
		for (int i = 12; i < 23; i++) {
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
					button.setText(firstColumnCheck(i));
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
							System.out.println("Row: " +  (firstColumnCheck(GridPane.getRowIndex(button))));
							System.out.println("Column " + (firstRowCheck(GridPane.getColumnIndex(button))));
							button.setStyle("-fx-background-color: black;");
						}
					}
				});
			}
		}
		
		for (int i = 0; i < 11; i++) {
			for(int j = 12; j < 23; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				if (j >= 13 && j < 23 && i == 0) {
					button.setText(firstRowCheck(j));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i >= 1 && i < 11 && j == 12) {
					button.setText(firstColumnCheck(i));
					button.setStyle("-fx-font-size: 1.72em; ");
				}
				else if (i == 0 && j == 12){
					button.setText("+");
					button.setStyle("-fx-font-size: 1.25em; ");
				}
				GridPane.setConstraints(button, j, i);
				playerGrid.getChildren().add(button);
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent arg0) {
						if ((GridPane.getRowIndex(button) >= 0 && GridPane.getRowIndex(button) < 11 && GridPane.getColumnIndex(button) == 12) || (GridPane.getColumnIndex(button) >= 12 && GridPane.getColumnIndex(button) < 23 && GridPane.getRowIndex(button) == 0)) {
						}
						else {
							System.out.println("Row: " + (firstColumnCheck(GridPane.getRowIndex(button))));
							System.out.println("Column " + (firstRowCheck(GridPane.getColumnIndex(button))));
							button.setStyle("-fx-background-color: red;");
						}
					}
				});
			}
		
		}	
		main.getChildren().add(playerGrid);
		
	}
	
	public void Deploy() {
		
	}
	
	public void Start() {
		
	}
	
	
	public Pane getRoot() {
		return main;
	}
	
	private String firstColumnCheck (int c) {
		if (c == 1 || c == 13) {
			return "A";
		}
		else if (c == 2 || c == 14) {
			return "B";
		}
		else if (c == 3 || c == 15) {
			return "C";
		}
		else if (c == 4 || c == 16) {
			return "D";
		}
		else if (c == 5 || c == 17) {
			return "E";
		}
		else if (c == 6 || c == 18) {
			return "F";
		}
		else if (c == 7 || c == 19) {
			return "G";
		}
		else if (c == 8 || c == 20) {
			return "H";
		}
		else if (c == 9 || c == 21) {
			return "I";
		}
		else {
			return "J";
		}
	}
	
	private String firstRowCheck (int r) {
		if (r == 1 || r == 13) {
			return "1";
		}
		else if (r == 2 || r == 14) {
			return "2";
		}
		else if (r == 3 || r == 15) {
			return "3";
		}
		else if (r == 4 || r == 16) {
			return "4";
		}
		else if (r == 5 || r == 17) {
			return "5";
		}
		else if (r == 6 || r == 18) {
			return "6";
		}
		else if (r == 7 || r == 19) {
			return "7";
		}
		else if (r == 8 || r == 20) {
			return "8";
		}
		else if (r == 9 || r == 21) {
			return "9";
		}
		else {
			return "10";
		}
	}
	
	
}


