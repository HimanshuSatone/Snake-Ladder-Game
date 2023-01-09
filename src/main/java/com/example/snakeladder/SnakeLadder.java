package com.example.snakeladder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SnakeLadder extends Application {

    public static final int tileSize = 40, height=10,width=10;

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
//        root.getChildren().add(new Tile(tileSize));

        //Setting image url to the pane with respective sizes
        Image img = new Image(new FileInputStream("C:\\Users\\Himanshu\\IdeaProjects\\SnakeLadder\\src\\main\\java\\com\\example\\snakeladder\\SnakeAndLadder.jpg"));
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(tileSize*width);
        boardImage.setFitHeight(tileSize*height);
        root.getChildren().add(boardImage);
        return root;
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