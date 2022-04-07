package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;

public class PaneOrganizer implements Battle {
	
	private BorderPane main;
	private ArrayList<Button> tiles = new ArrayList<Button>(0);
	
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
			for(int j = 0; j < 11; j++) {
				Button button = new Button();
				tiles.add(button);
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
				tiles.add(button);
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
							button.setStyle("-fx-background-color: black;");
						}
					}
				});
			}
		
		}	
		main.getChildren().add(playerGrid);
		Deploy();
		
	}
	
	public void Deploy() {
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random()*((10-1)+1)+1);
			System.out.println(r);
			int spot = randomRowCheck1(r);
			System.out.println(spot);
			tiles.get(spot).setStyle("-fx-background-color: blue;");
		}
		for (int i = 0; i < 10; i++) {
			int r = (int) (Math.random()*((10-1)+1)+1);
			System.out.println(r);
			int spot = randomRowCheck2(r);
			System.out.println(spot);
			tiles.get(spot).setStyle("-fx-background-color: red;");
		}
		
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
	
	private int randomRowCheck1 (int r) {
		if (r == 1) {
			return (int) (Math.random()*((21-12)+1)+12);
		}
		else if (r == 2) {
			return (int) (Math.random()*((32-23)+1)+23);
		}
		else if (r == 3) {
			return (int) (Math.random()*((43-34)+1)+34);
		}
		else if (r == 4) {
			return (int) (Math.random()*((54-45)+1)+45);
		}
		else if (r == 5) {
			return (int) (Math.random()*((65-56)+1)+56);
		}
		else if (r == 6) {
			return (int) (Math.random()*((76-67)+1)+67);
		}
		else if (r == 7) {
			return (int) (Math.random()*((87-78)+1)+78);
		}
		else if (r == 8) {
			return (int) (Math.random()*((98-89)+1)+89);
		}
		else if (r == 9) {
			return (int) (Math.random()*((109-100)+1)+100);
		}
		else {
			return (int) (Math.random()*((120-111)+1)+111);
		}
	}
	
	private int randomRowCheck2 (int r) {
		if (r == 1) {
			return (int) (Math.random()*((142-133)+1)+133);
		}
		else if (r == 2) {
			return (int) (Math.random()*((153-144)+1)+144);
		}
		else if (r == 3) {
			return (int) (Math.random()*((164-155)+1)+155);
		}
		else if (r == 4) {
			return (int) (Math.random()*((175-166)+1)+166);
		}
		else if (r == 5) {
			return (int) (Math.random()*((186-177)+1)+177);
		}
		else if (r == 6) {
			return (int) (Math.random()*((197-188)+1)+188);
		}
		else if (r == 7) {
			return (int) (Math.random()*((208-199)+1)+199);
		}
		else if (r == 8) {
			return (int) (Math.random()*((219-210)+1)+210);
		}
		else if (r == 9) {
			return (int) (Math.random()*((230-221)+1)+221);
		}
		else {
			return (int) (Math.random()*((120-232)+1)+232);
		}
	}
	
	
	
	
}


