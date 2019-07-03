package game.frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
	//Se decidio utilizar este nombre para la clase ay que nos
	// parecio que reflejaba mejor el proposito de la misma
public class GameStateInfoPanel extends BorderPane {

	private Label infoLabel;

	public GameStateInfoPanel() {
		setStyle("-fx-background-color: #5490ff");
		infoLabel = new Label("Start Game");
		infoLabel.setAlignment(Pos.CENTER);
		infoLabel.setStyle("-fx-font-size: 24");
		setCenter(infoLabel);
	}
	
	public void updateInfo(String text) {
		infoLabel.setText(text);
	}

}