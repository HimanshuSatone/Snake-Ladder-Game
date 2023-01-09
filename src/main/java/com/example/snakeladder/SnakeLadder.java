package com.example.snakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 40, height=10,width=10;
    int lowerLine = tileSize*height;
    public int diceValue;
    Label rolledDiceValueLabel;

    //Two players to play the game
    Player firstPlayer = new Player(tileSize-15, Color.BLACK,"Himanshu");
    Player secondPlayer = new Player(tileSize-22, Color.RED,"Sneha");


    //Setting tiles on the Pane to make a playing board
    Pane createContent() throws FileNotFoundException {
        Pane root = new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+50);

        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                Tile tile = new Tile(tileSize);
                tile.setTranslateX(i*tileSize);
                tile.setTranslateY(j*tileSize);
                root.getChildren().add(tile);
            }
        }

        //Setting image url to the pane with respective sizes
        Image img = new Image(new FileInputStream("C:\\Users\\Himanshu\\IdeaProjects\\SnakeLadder\\src\\main\\java\\com\\example\\snakeladder\\SandL.jpg"));
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tileSize*width);
        boardImage.setFitHeight(tileSize*height);

        //Button for player1
        Button  playerOneButton = new Button("Player One");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(lowerLine+20);
        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setDiceValue();
                firstPlayer.movePlayer(diceValue);
                if(firstPlayer.playerWon()!=null){
                    rolledDiceValueLabel.setText(firstPlayer.playerWon());
                }
            }
        });

        //Button for player2
        Button  playerTwoButton = new Button("Player Two");
        playerTwoButton.setTranslateX(250);
        playerTwoButton.setTranslateY(lowerLine+20);
        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setDiceValue();
                secondPlayer.movePlayer(diceValue);
                if(secondPlayer.playerWon()!=null){
                    rolledDiceValueLabel.setText(secondPlayer.playerWon());
                }
            }
        });

        //Label for start the game and dice number
        rolledDiceValueLabel = new Label("Start the Game");
        rolledDiceValueLabel.setTranslateY(lowerLine+20);
        rolledDiceValueLabel.setTranslateX(140);

        root.getChildren().addAll(boardImage,playerOneButton, playerTwoButton,
                firstPlayer.getCoin(), secondPlayer.getCoin(),rolledDiceValueLabel);
        return root;
    }

    private void setDiceValue(){
         diceValue = (int)(Math.random()*6+1);
         rolledDiceValueLabel.setText("Dice Value : " +diceValue);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake & Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}