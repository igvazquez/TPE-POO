package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level5;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

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

	public void startLevel(Levels level){
		game = new CandyGame(level.getLevel());
		CandyFrame frame = new CandyFrame(game, level,this);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setTitle(level.name() + ": " + level.getDescription());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void openLevelSelector(){
		if( game != null )
			game.finish();
		Scene scene = new Scene(new MainMenu(this));
		primaryStage.setTitle("Level Selector");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
