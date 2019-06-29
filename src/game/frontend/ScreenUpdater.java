package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;
import game.backend.cell.Cell;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.frontend.gameInfo.GameInfo;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class ScreenUpdater implements GameListener {

    private ImageManager images;
    private BoardPanel boardPanel;
    private CandyGame game;
    private GameInfo gameInfo;

    public ScreenUpdater(ImageManager images, BoardPanel boardPanel, CandyGame game, GameInfo gameInfo){
        this.images = images;
        this.boardPanel = boardPanel;
        this.game = game;
        this.gameInfo = gameInfo;
    }

    @Override
    public void gridUpdated() {
        Timeline timeLine = new Timeline();
        Duration frameGap = Duration.millis(100);
        Duration frameTime = Duration.ZERO;
        for (int i = game.getSize() - 1; i >= 0; i--) {
            for (int j = game.getSize() - 1; j >= 0; j--) {
                int finalI = i;
                int finalJ = j;
                Cell cell = game.get(i, j);
                Element element = cell.getContent();
                Image image = images.getImage(element);
                timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, null)));
                timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, image, gameInfo.getCandyText(element, game.getGrid()))));
            }
            frameTime = frameTime.add(frameGap);
        }
        timeLine.play();
    }

    @Override
    public void cellExplosion(Element e) {
        //
    }

}
