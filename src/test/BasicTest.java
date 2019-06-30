package test;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.frontend.CandyFrame;
import game.frontend.GameApp;
import game.frontend.Levels;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTest extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Levels levelEnum = Levels.LEVEL1; //Aca se elige el nivel.
        CandyGame game = new CandyGame(levelEnum.getLevel());
        CandyFrame frame = new CandyFrame(game, levelEnum);
        Scene scene = new Scene(frame);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
