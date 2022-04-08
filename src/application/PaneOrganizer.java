package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;

public class PaneOrganizer implements Battle {
	
	private HBox main;
	private ArrayList<Button> tiles = new ArrayList<Button>(0);
	private GridPane playerGrid;
	private GridPane midGrid;
	private GridPane AI_Grid;
	private ArrayList<Integer> playerShips = new ArrayList<Integer>();
	private ArrayList<Integer> AI_Ships = new ArrayList<Integer>();
	private StringBuilder SB = new StringBuilder();

	
	
	// Boots up Battleship resources
	public PaneOrganizer() {
		main = new HBox(0);
		main.setStyle("-fx-background-color: grey;");
		main.setPrefHeight(550);
		main.minHeight(550);
		main.maxHeight(550);
		main.setPrefWidth(600);
		main.minWidth(600);
		main.maxWidth(600);
		createGrid();
		Deploy();
	}
	
	
	
	
	// Creates main 10x10 grids
	public void createGrid() {
		
		playerGrid = new GridPane();
		playerGrid.setPrefHeight(550);
		playerGrid.maxHeight(550);
		playerGrid.minHeight(550);
		playerGrid.setPrefWidth(550);
		playerGrid.minWidth(550);
		playerGrid.maxWidth(550);
		
		for (int i = 0; i < 11; i++) {
			playerGrid.getRowConstraints().add(new RowConstraints(50));
			playerGrid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		for (int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.minWidth(50);
				button.minWidth(50);
				tiles.add(button);
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
				playerGrid.getChildren().add(button);
				GridPane.setConstraints(button, j, i);
			}
		}

		
		midGrid = new GridPane();
		midGrid.setPrefHeight(550);
		midGrid.maxHeight(550);
		midGrid.minHeight(550);
		midGrid.setPrefWidth(250);
		midGrid.maxWidth(250);
		midGrid.minWidth(250);
		midGrid.getColumnConstraints().add(new ColumnConstraints(250));
		midGrid.getRowConstraints().add(new RowConstraints(100));
		midGrid.getRowConstraints().add(new RowConstraints(450));
		
		Button button0 = new Button();
		button0.setPrefHeight(100);
		button0.setPrefWidth(250);
		button0.minHeight(100);
		button0.minWidth(250);
		tiles.add(button0);
		button0.setText("Start");
		button0.setStyle("-fx-font-size: 2.3em; ");
		midGrid.getChildren().add(button0);
		GridPane.setConstraints(button0, 0, 0);
		
		Button button1 = new Button();
		button1.setPrefHeight(450);
		button1.minHeight(450);
		button1.setPrefWidth(250);
		button1.minWidth(250);
		button1.setStyle("-fx-background-color: white; -fx-font-size: 1.72em; ");
		tiles.add(button1);
		midGrid.getChildren().add(button1);
		GridPane.setConstraints(button1, 0, 1);
		
		
		AI_Grid = new GridPane();
		AI_Grid.setPrefHeight(550);
		AI_Grid.maxHeight(550);
		AI_Grid.minHeight(550);
		AI_Grid.setPrefWidth(550);
		AI_Grid.minWidth(550);
		AI_Grid.maxWidth(550);
		
		for (int i = 0; i < 11; i++) {
			AI_Grid.getRowConstraints().add(new RowConstraints(50));
			AI_Grid.getColumnConstraints().add(new ColumnConstraints(50));
		}
		for (int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				Button button = new Button();
				button.setPrefHeight(50);
				button.setPrefWidth(50);
				button.minHeight(50);
				button.minWidth(50);
				tiles.add(button);
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
				AI_Grid.getChildren().add(button);
				GridPane.setConstraints(button, j, i);
			}
		}	
		
		main.getChildren().add(playerGrid);
		main.getChildren().add(midGrid);
		main.getChildren().add(AI_Grid);
	
	}
	
	
	
	
	// Deploys enemy and user ships onto main grid 
	public void Deploy() {
		
		tiles.get(121).setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
				SB.append(10 - playerShips.size());
				SB.append(" ships remaining");
				tiles.get(122).setText(SB.toString());
				SB.setLength(0);
				tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
				tiles.get(121).setText("Concede");
				tiles.get(121).setStyle("-fx-font-size: 2.3em;");
				
				for (int i = 0; i < 10; i++) {
					int r = (int) (Math.random()*((10-1)+1)+1);
					int spot = randomRowCheck2(r);
					int count = 0;
					for (int j = 0; j < i; j++) {
						if (spot == AI_Ships.get(j)) {
							count ++;
						}
					}
					if (count == 1) {
						i--;
					}
					else { 
						AI_Ships.add(spot);
					}
					tiles.get(spot).setStyle("-fx-background-color: red;");
				}
				
				tiles.get(0).setOnAction(new EventHandler<ActionEvent>() {
					@Override
						public void handle(ActionEvent arg0) {
							for (int i = 0; i < 1 && playerShips.size() < 10; i++) {
								int r = (int) (Math.random()*((10-1)+1)+1);
								int spot = randomRowCheck1(r);
								int count1 = 0;
								for (int j = 0; j < playerShips.size(); j++) {
									if (spot == playerShips.get(j)) {
										count1 ++;
									}
								}
								if (count1 == 1) {
									i--;
								}
								else {
									playerShips.add(spot);
									SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
									SB.append(10 - playerShips.size());
									SB.append(" ships remaining");
									tiles.get(122).setText(SB.toString());
									tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
									SB.setLength(0);
								}
								tiles.get(spot).setStyle("-fx-background-color: blue;");
								if (playerShips.size() == 10) {
									Start();
								}
							}
						}
					});
				
				tileClickPreparer();
				
			}
		});
		
	}
	
	
	
	
	// Starts a game of Battleship
	public void Start() {
		
	}
	
	public void gameOver() {
		
	}
	
	public Pane getRoot() {
		return main;
	}
	
	
	
	// Supporting Methods
	private String firstColumnCheck (int c) {
		if (c == 1 || c == 14) {
			return "A";
		}
		else if (c == 2 || c == 15) {
			return "B";
		}
		else if (c == 3 || c == 16) {
			return "C";
		}
		else if (c == 4 || c == 17) {
			return "D";
		}
		else if (c == 5 || c == 18) {
			return "E";
		}
		else if (c == 6 || c == 19) {
			return "F";
		}
		else if (c == 7 || c == 20) {
			return "G";
		}
		else if (c == 8 || c == 21) {
			return "H";
		}
		else if (c == 9 || c == 22) {
			return "I";
		}
		else {
			return "J";
		}
	}
	
	private String firstRowCheck (int r) {
		if (r == 1 || r == 14) {
			return "1";
		}
		else if (r == 2 || r == 15) {
			return "2";
		}
		else if (r == 3 || r == 16) {
			return "3";
		}
		else if (r == 4 || r == 17) {
			return "4";
		}
		else if (r == 5 || r == 18) {
			return "5";
		}
		else if (r == 6 || r == 19) {
			return "6";
		}
		else if (r == 7 || r == 20) {
			return "7";
		}
		else if (r == 8 || r == 21) {
			return "8";
		}
		else if (r == 9 || r == 22) {
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
			return (int) (Math.random()*((144-135)+1)+135);
		}
		else if (r == 2) {
			return (int) (Math.random()*((155-146)+1)+146);
		}
		else if (r == 3) {
			return (int) (Math.random()*((166-157)+1)+157);
		}
		else if (r == 4) {
			return (int) (Math.random()*((177-168)+1)+168);
		}
		else if (r == 5) {
			return (int) (Math.random()*((188-179)+1)+179);
		}
		else if (r == 6) {
			return (int) (Math.random()*((199-190)+1)+190);
		}
		else if (r == 7) {
			return (int) (Math.random()*((210-201)+1)+201);
		}
		else if (r == 8) {
			return (int) (Math.random()*((221-212)+1)+212);
		}
		else if (r == 9) {
			return (int) (Math.random()*((232-223)+1)+223);
		}
		else {
			return (int) (Math.random()*((243-234)+1)+234);
		}
	}
	
	private void tileClickPreparer () {
		for (int i = 12; i < 22; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 23; i < 33; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 34; i < 44; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 45; i < 55; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 56; i < 66; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 67; i < 77; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 78; i < 88; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 89; i < 99; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 100; i < 110; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		for (int i = 111; i < 121; i++) {
			final int I = i;
			tiles.get(I).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					int tilecheck = 0;
					if (playerShips.size() < 10) {
						for (int j = 0; j < playerShips.size(); j++) {
							if (playerShips.get(j) == I) {
								tilecheck = 1;
							}	
						}
						if (tilecheck != 1) {
							tiles.get(I).setStyle("-fx-background-color: blue;");
							playerShips.add(I);
							SB.append("Your board is on the left\n\nClick the plus button to add\n\na ship randomly\n\nClick a tile on the board\nto place a ship\n\nYou have ");
							SB.append(10 - playerShips.size());
							SB.append(" ships remaining");
							tiles.get(122).setText(SB.toString());
							tiles.get(122).setStyle("-fx-font-size: 1.34em; -fx-background-color: white;");
							SB.setLength(0);
						}
						if (playerShips.size() == 10) {
							Start();
						}
					}
				}
			});
		}
		
				
	}

	
	// old code, may be useful later
	/* button.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent arg0) {
			if ((GridPane.getRowIndex(button) >= 0 && GridPane.getRowIndex(button) < 11 && GridPane.getColumnIndex(button) == 0) || (GridPane.getColumnIndex(button) >= 1 && GridPane.getColumnIndex(button) < 11 && GridPane.getRowIndex(button) == 0)) {
			}
			else {
				System.out.println("Row: " + (firstColumnCheck(GridPane.getRowIndex(button))));
				System.out.println("Column " + (firstRowCheck(GridPane.getColumnIndex(button))));
				button.setStyle("-fx-background-color: black;");
			}
		}
	});
	*/
	
	
}


