package com.example.snakeladder;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {

    private Circle coin;
    private String name;
    private int coinPosition;

    private static Board gameBoard = new Board();



    public Player(int tileSize, Color coinColor, String playerName){

        coinPosition = 1;
        coin = new Circle(tileSize/2);
        coin.setFill(coinColor);
        coin.setTranslateX(20);
        coin.setTranslateY(380);
    }

    public void movePlayer(int diceValue){
        if(coinPosition + diceValue <=100){
            coinPosition +=diceValue;
        }
//        coin.setTranslateX(gameBoard.getXCoordinate(coinPosition));
//        coin.setTranslateY(gameBoard.getYCoordinate(coinPosition));
        translatePlayer();
    }

    public void translatePlayer(){

        TranslateTransition move = new TranslateTransition(Duration.millis(1000),this.coin);
        move.setToX(gameBoard.getXCoordinate(coinPosition));
        move.setToY(gameBoard.getYCoordinate(coinPosition));
        move.setAutoReverse(false);
        move.play();
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCoinPosition() {
        return coinPosition;
    }

    public void setName(String name) {
        this.name = name;
    }
}
