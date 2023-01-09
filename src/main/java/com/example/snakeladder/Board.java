package com.example.snakeladder;

import javafx.util.Pair;
import java.util.ArrayList;

public class Board {

    ArrayList<Pair<Integer, Integer>> positionCoordinates;

    private void populatePositionCoordinates(){

        positionCoordinates = new ArrayList<>();
        positionCoordinates.add(new Pair<Integer,Integer>(0,0));//Dummy Values at Zero Index
        int x=1,y=10,xPos,yPos;

        for(int i=0;i<SnakeLadder.height;i++){
            x=1;
            for(int j=0;j<SnakeLadder.width;j++){

                if(y%2==0){
                    xPos = x*SnakeLadder.tileSize-SnakeLadder.tileSize/2;
                }
                else{
                    xPos= SnakeLadder.width*SnakeLadder.tileSize -(x*SnakeLadder.tileSize-SnakeLadder.tileSize/2);
                }
                yPos= y*SnakeLadder.tileSize-SnakeLadder.tileSize/2;
                positionCoordinates.add(new Pair<Integer, Integer>(xPos,yPos));
                x++;
            }
            y--;
        }
    }

    public static void main(String[] args) {
        Board board= new Board();
        board.populatePositionCoordinates();
        for(int i=0;i<board.positionCoordinates.size();i++){
            System.out.println(i + " #x: " + board.positionCoordinates.get(i).getKey()+
                    " #y: " +board.positionCoordinates.get(i).getValue() );
        }
    }
}
