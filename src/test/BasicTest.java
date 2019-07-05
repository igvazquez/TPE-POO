package test;

import game.backend.CandyGame;
import game.frontend.CandyFrame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BasicTest extends Application{

    @Override
    public void start(Stage primaryStage) {

        Tests testLevel = Tests.TEST5;//Aqui se elige el test a ejecutar del enum
        CandyGame game = new CandyGame(testLevel.getLevel());
        CandyFrame frame = new CandyFrame(game, testLevel.getParentLevel(),this);
        Scene scene = new Scene(frame);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
