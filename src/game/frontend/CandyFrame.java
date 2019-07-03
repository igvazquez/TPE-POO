package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;

import game.frontend.gameInfo.LevelInfo;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.text.DateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class CandyFrame extends VBox {

	private static final int CELL_SIZE = 65;
	private static final int TIMER_INIT_DELAY = 200;

	private BoardPanel boardPanel;
	private GameStateInfoPanel gameStateInfoPanel;
	private ImageManager images;
	private Point2D lastPoint;
	private CandyGame game;
	private LevelInfo levelInfo;
	private Application app;

	public CandyFrame(CandyGame game, Levels levelEnum, Application app) {
		this.game = game;
		this.app = app;
		getChildren().add(new AppMenu(app));
		images = new ImageManager();
		boardPanel = new BoardPanel(CandyGame.getSize(), CandyGame.getSize(), CELL_SIZE);
		getChildren().add(boardPanel);
		gameStateInfoPanel = new GameStateInfoPanel();
		getChildren().add(gameStateInfoPanel);
		game.initGame();
		this.levelInfo = levelEnum.createGameInfo(game.getState());
		GameListener listener = new ScreenUpdater( images, boardPanel, this.game, levelInfo);
		game.addGameListener(listener);

		listener.gridUpdated();

		if(levelInfo.hasToUpdateInfo()) {
			final Timeline timeline = new Timeline(
					new KeyFrame(
							Duration.millis(levelInfo.getInfoRefreshRate()),
							event -> gameStateInfoPanel.updateInfo(levelInfo.levelStateInfo())
					)
			);
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();
		}

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (lastPoint == null) {
				lastPoint = translateCoords(event.getX(), event.getY());
				System.out.println("Get first = " +  lastPoint);
			} else {
				Point2D newPoint = translateCoords(event.getX(), event.getY());
				if (newPoint != null) {
					if(game.getState().gameOver())
						showAlert();
					System.out.println("Get second = " +  newPoint);
					game.tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
					gameStateInfoPanel.updateInfo(levelInfo.levelStateInfo());
					lastPoint = null;

				}
			}
		});

	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < CandyGame.getSize() && j >= 0 && j < CandyGame.getSize()) ? new Point2D(j, i) : null;
	}

	private void showAlert() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Level Finished");
		alert.setHeaderText("GAME OVER");
		alert.setContentText("Moves can no longer be made. Accept to choose a new level");
		alert.setOnHidden(event -> ((GameApp)app).openLevelSelector());
		alert.showAndWait();
	}

}
