package test;

import game.backend.CandyGame;
import game.frontend.CandyFrame;
import game.frontend.GameApp;
import game.frontend.Levels;
import game.frontend.MainMenu;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BasicTest extends GameApp {

    //Se guarda el Stage para poder ir y volver entre niveles y el
    // menu principal. El game es necesario para finalizar el nivel.
    private Stage primaryStage;
    private CandyGame game;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        openLevelSelector();
    }

    @Override
    public void startLevel(Levels level){
        game = new CandyGame(level.getLevel());
        CandyFrame frame = new CandyFrame(game, level,this);
        Scene scene = new Scene(frame);
        primaryStage.setResizable(false);
        primaryStage.setTitle(level.name() + ": " + level.getDescription());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void openLevelSelector(){
        //
    }
}
