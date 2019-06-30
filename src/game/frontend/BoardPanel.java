package game.frontend;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BoardPanel extends TilePane {

	//se crea una matriz del tamaño del juego y se llena con ImageView para que muestren
	//los caramelos correspondientes
	private StackPane[][] cells;

	public BoardPanel(int rows, int columns, int cellSize) {
		setPrefRows(rows);
		setPrefColumns(columns);
		setPrefTileHeight(cellSize);
		setPrefTileWidth(cellSize);
		this.cells = new StackPane[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new StackPane();
				getChildren().add(cells[i][j]);
			}
		}
	}

	public void setImage(int row, int column, Image image) {
		cells[row][column].getChildren().add(new ImageView(image));
	}

	public void setImage(int row, int column, Image image, String overlappingText) {
		setImage(row, column, image);
		if(overlappingText != null) {
			DropShadow dropShadow = new DropShadow();
			dropShadow.setRadius(3.0);
			dropShadow.setOffsetX(3.0);
			dropShadow.setOffsetY(3.0);
			dropShadow.setColor(Color.ORANGERED);

			Text text = new Text(overlappingText);
			text.setFont(Font.font("Impact", FontWeight.BOLD, 29));
			text.setFill(Color.BLACK);
			text.setEffect(dropShadow);
			cells[row][column].getChildren().add(text);
		}
	}

}