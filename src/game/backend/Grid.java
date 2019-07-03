package game.backend;

import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Element;
import game.backend.element.Wall;
import game.backend.level.gameState.GameState;
import game.backend.move.Move;
import game.backend.move.MoveMaker;

import java.awt.Point;
import java.util.*;

public abstract class Grid {

	//Nuevo: Metodo que chequea que las coordenadas esten dentro de Grid.
	public static boolean inBounds(int i, int j){
		return i>= 0 && i <= SIZE -1 && j>= 0 && j <= SIZE -1;
	}

	public static final int SIZE = 9;
	private Cell[][] g = new Cell[SIZE][SIZE];
	private Map<Cell, Point> gMap = new HashMap<>();
	private GameState state;
	private List<GameListener> listeners = new ArrayList<>();
	protected MoveMaker moveMaker;
	protected FigureDetector figureDetector;
	private Cell wallCell;

	protected Cell candyGenCell;

	protected abstract GameState newState();

	protected Cell[][] g() {
		return g;
	}

	protected GameState state(){
		return state;
	}
	//Se usan funciones para modularizacion y para que los distintos levels decidan
	// que instancias de MoveMaker, FigureDetector, CellGenerators y cells usar
	public void initialize() {
		setMoveMaker();
		setFigureDetector();
		setCandyCellGenerator();
		createGrid();
		fillCells();
		fallElements();
	}
	//Nuevo: modularizacion

	private void createGrid(){
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				g[i][j] = cellCreator();
				gMap.put(g[i][j], new Point(i,j));
			}
		}
	}
	//Nuevo: modularizacion

	protected Cell cellCreator(){
		return new Cell(this);
	}
	//Nuevo: modularizacion

	protected void setCandyCellGenerator() {
		candyGenCell = new CandyGeneratorCell(this);
	}
	//Nuevo: modularizacion

	protected void setFigureDetector() {
		figureDetector = new FigureDetector(this);
	}
	//Nuevo: modularizacion

	protected void setMoveMaker() {
		moveMaker = new MoveMaker(this);
	}

	//Se cambio el lugar del metodo desde Level1 a Grid porque entendemos que es un metodo que todos los
	//Levels van a usar, no de alguno en especifico, por lo que corresponde en Grid. Para que cada level
	//decida sus generadores y celdas se crearon los metodos de arriba.
	protected void fillCells() {

		wallCell = cellCreator();
		wallCell.setContent(new Wall());


		//corners
		//Agrega walls a  los costados y generadores arriba
		g[0][0].setAround(candyGenCell, g[1][0], wallCell, g[0][1]);
		g[0][SIZE-1].setAround(candyGenCell, g[1][SIZE-1], g[0][SIZE-2], wallCell);
		//genera parades abajo y a los costados
		g[SIZE-1][0].setAround(g[SIZE-2][0], wallCell, wallCell, g[SIZE-1][1]);
		g[SIZE-1][SIZE-1].setAround(g[SIZE-2][SIZE-1], wallCell, g[SIZE-1][SIZE-2], wallCell);

		//Agrega arriba los generadores y en los bordes las paredes
		//Asocia todas las celdas adyacentes entre si
		//Y quedan todas las celdas vacias
		//upper line cells
		for (int j = 1; j < SIZE-1; j++) {
			g[0][j].setAround(candyGenCell,g[1][j],g[0][j-1],g[0][j+1]);
		}
		//bottom line cells
		for (int j = 1; j < SIZE-1; j++) {
			g[SIZE-1][j].setAround(g[SIZE-2][j], wallCell, g[SIZE-1][j-1],g[SIZE-1][j+1]);
		}
		//left line cells
		for (int i = 1; i < SIZE-1; i++) {
			g[i][0].setAround(g[i-1][0],g[i+1][0], wallCell ,g[i][1]);
		}
		//right line cells
		for (int i = 1; i < SIZE-1; i++) {
			g[i][SIZE-1].setAround(g[i-1][SIZE-1],g[i+1][SIZE-1], g[i][SIZE-2], wallCell);
		}
		//central cells
		for (int i = 1; i < SIZE-1; i++) {
			for (int j = 1; j < SIZE-1; j++) {
				g[i][j].setAround(g[i-1][j],g[i+1][j],g[i][j-1],g[i][j+1]);
			}
		}
	}

	public Element get(int i, int j) {
		return g[i][j].getContent();
	}

	public Cell getCell(int i, int j) {
		return g[i][j];
	}

	public void fallElements() {
		int i = SIZE - 1;
		while (i >= 0) {
			int j = 0;
			while (j < SIZE) {
				if (g[i][j].isEmpty()) {
					if (g[i][j].fallUpperContent()) {
						i = SIZE;
						j = -1; //No se usa
						break;
					}
				}
				j++;
			}
			i--;
		}
	}

	public void clearContent(int i, int j) {
		g[i][j].clearContent();
	}

	public void setContent(int i, int j, Element e) {
		g[i][j].setContent(e);
	}

	public boolean tryMove(int i1, int j1, int i2, int j2) {
		Move move = moveMaker.getMove(i1, j1, i2, j2);
		swapContent(i1, j1, i2, j2);
		if (move.isValid()) {
			state.addMove(); //Grid es el que se encarga de contabilizar sus movimientos. Sino su GameState esta desactualizado.
			move.removeElements();
			fallElements();
			return true;
		} else {
			swapContent(i1, j1, i2, j2);
			return false;
		}
	}

	public Figure tryRemove(Cell cell) {
		if (gMap.containsKey(cell)) {
			Point p = gMap.get(cell);
			Figure f = figureDetector.checkFigure(p.x, p.y);
			if (f != null) {
				figureDetector.removeFigure(p.x, p.y, f); //cambiamos para que llame al metodo de figureDetector
			}
			return f;
		}
		return null;
	}

	/*Igual que en figure detector, y hay casos donde creemos que falla. Lo cambiamos por
	el mismo metodo de figureDetector para que se remueva la figura siempre con el mismo criterio
	y evitamos la existencia de dos metodos practicamente iguales.

	private void removeFigure(int i, int j, Figure f) {
		CandyColor color = ((Candy)get(i, j)).getColor();
		if (f.hasReplacement()) {
			setContent(i, j, f.generateReplacement(color));
		} else {
			clearContent(i, j);
		}
		for (Point p: f.getPoints()) {
			clearContent(i + p.x, j + p.y);
		}
	}*/

	public void swapContent(int i1, int j1, int i2, int j2) {
		Element e = g[i1][j1].getContent();
		g[i1][j1].setContent(g[i2][j2].getContent());
		g[i2][j2].setContent(e);
		wasUpdated();
	}

	public GameState createState() {
		this.state = newState();
		return this.state;
	}

	public void addListener(GameListener listener) {
		listeners.add(listener);
	}

	public void wasUpdated(){
		if (listeners.size() > 0) {
			for (GameListener gl: listeners) {
				gl.gridUpdated();
			}
		}
	}

	public void cellExplosion(Element e) {
		for (GameListener gl: listeners) {
			gl.cellExplosion(e);
		}
	}

	//Nuevo: Metodo que se ejecuta cuando se finaliza un nivel para terminar con sus procesos activos(Threads)
	public void finish(){
		//
	}
	//Nuevo
	public int getCurrentMoves(){
		return state.getMoves();
	}
}
