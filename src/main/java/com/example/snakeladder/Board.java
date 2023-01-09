package com.example.snakeladder;

import javafx.util.Pair;
import java.util.ArrayList;

public class Board {

    ArrayList<Pair<Integer, Integer>> positionCoordinates;
    private ArrayList<Integer> snakeLadderPosition;

    public Board(){

        populatePositionCoordinates();
        populateSnakeLadderPosition();
    }

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

    private void populateSnakeLadderPosition(){

        snakeLadderPosition = new ArrayList<>();
        for(int i=0;i<101;i++){
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4,25);
        snakeLadderPosition.set(21,39);
        snakeLadderPosition.set(29,74);
        snakeLadderPosition.set(43,76);
        snakeLadderPosition.set(63,80);
        snakeLadderPosition.set(71,89);
        snakeLadderPosition.set(47,15);
        snakeLadderPosition.set(30,7);
        snakeLadderPosition.set(56,19);
        snakeLadderPosition.set(82,42);
        snakeLadderPosition.set(98,55);
        snakeLadderPosition.set(92,75);
        snakeLadderPosition.set(73,51);
    }

    public int getXCoordinate(int position){

        return positionCoordinates.get(position).getKey();
    }
    public int getYCoordinate(int position){

        return positionCoordinates.get(position).getValue();
    }

    public int getNextPosition(int position){

        if(position>=1 && position<=100)
            return snakeLadderPosition.get(position);

        else return -1;
    }
}
