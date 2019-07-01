package game.backend;

import game.backend.cell.JailCell;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;

import java.awt.Point;

public class FigureDetector {
	
	private Grid grid;
	
	public FigureDetector(Grid grid) {
		this.grid = grid;
	}
	
	public Figure checkFigure(int i, int j) {
		int acum = readCheckpoints(i, j);
		//Verifica que figura se formo, devolviendo la mas "potente"
		if (acum > 0) {
			for(Figure f: Figure.values()) {
				if (f.matches(acum)) {
					return f;
				}
			}
		}
		return null;
	}
	
	private int readCheckpoints(int i, int j) {
		Element curr = grid.get(i,j);
		int acum = 0;
		//recorre verificando las 4 direcciones y los 2 lugares posibles
		for (Checkpoint cp: Checkpoint.values()) {
			int newI = i + cp.getI();
			int newJ = j + cp.getJ();
			//valida que no se salga del tablero
			if (Grid.inBounds(newI,newJ)) {
				if (curr.equals(grid.get(newI, newJ))) {
					acum += cp.getValue();
				}
			}
		}
		return acum;
	}

	//Segun la figura que es, saca todos los caramelos explotados y deja
	//el de remplazo si es que existe
	public void removeFigure(int i, int j, Figure f) {
		CandyColor color = ((Candy)grid.get(i, j)).getColor();
		grid.clearContent(i, j);
		if (f.hasReplacement()) {
			grid.setContent(i, j, f.generateReplacement(color));
		}
		for (Point p: f.getPoints()) {
			grid.clearContent(i + p.x, j + p.y);
		}
	}
	
}
