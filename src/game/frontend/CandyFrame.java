package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;

import game.frontend.gameInfo.LevelInfo;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class CandyFrame extends VBox {

	private static final int CELL_SIZE = 65;

	private BoardPanel boardPanel;
	private GameStateInfoPanel gameStateInfoPanel;
	private ImageManager images;
	private Point2D lastPoint;
	private CandyGame game;
	private LevelInfo levelInfo;

	public CandyFrame(CandyGame game, Levels levelEnum) {
		this.game = game;
		getChildren().add(new AppMenu());
		images = new ImageManager();
		boardPanel = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		getChildren().add(boardPanel);
		gameStateInfoPanel = new GameStateInfoPanel();
		getChildren().add(gameStateInfoPanel);
		game.initGame();
		this.levelInfo = levelEnum.createGameInfo();
		GameListener listener = new ScreenUpdater(images,boardPanel,game(), levelInfo);
		game.addGameListener(listener);

		listener.gridUpdated();

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (lastPoint == null) {
				lastPoint = translateCoords(event.getX(), event.getY());
				System.out.println("Get first = " +  lastPoint);
			} else {
				Point2D newPoint = translateCoords(event.getX(), event.getY());
				if (newPoint != null) {
					System.out.println("Get second = " +  newPoint);
					game().tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
					gameStateInfoPanel.updateInfo(levelInfo.levelStateInfo());
					lastPoint = null;
				}
			}
		});

	}


	private CandyGame game() {
		return game;
	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point2D(j, i) : null;
	}

}
