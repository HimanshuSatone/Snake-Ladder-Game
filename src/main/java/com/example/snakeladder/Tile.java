package com.example.snakeladder;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int size){

        setWidth(size);//Tile width size
        setHeight(size);//Tile height size
        setFill(Color.RED);//Tile base color
        setStroke(Color.BLACK);//Tile Border color
    }
}
