package game.frontend;

import game.backend.cell.Cell;
import game.backend.cell.JailCell;
import game.backend.element.*;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageManager {

	private static final String IMAGE_PATH = "images/";
	private Map<String, Image> images;

	//Se tiene un Map donde estan cargados todas las imagenes de los distintos tipos de caramelos
	//En base al key del caremelo y su color
	public ImageManager() {
		WrappedCandy wc = new WrappedCandy();
		VerticalStripedCandy vc = new VerticalStripedCandy();
		HorizontalStripedCandy hc = new HorizontalStripedCandy();
		images = new HashMap<>();

		//Imagenes del content
		//Agrega 3 imagenes independientes de color
		images.put(new Nothing().getKey(), new Image(IMAGE_PATH + "nothing.png"));
		images.put(new Bomb().getKey(),  new Image(IMAGE_PATH + "bomb.png"));
		images.put(new Wall().getKey(),  new Image(IMAGE_PATH + "wall.png"));
		images.put(new Fruit(FruitType.CHERRY).getFullKey(), new Image(IMAGE_PATH + "cherry.png"));
		images.put(new Fruit(FruitType.HAZELNUT).getFullKey(), new Image(IMAGE_PATH + "hazelnut.png"));

		//Agrega todos los colores para caramelos comunes
		for (CandyColor cc: CandyColor.values()) {
			images.put(new Candy(cc).getFullKey(),   new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Candy.png"));
		}
		//Agrega todos los colores para caramelos envueltos
		for (CandyColor cc: CandyColor.values()) {
			wc.setColor(cc);
			images.put(wc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Wrapped.png"));
		}
		//Agrega todos los colores para caramelos de lineas
		for (CandyColor cc: CandyColor.values()) {
			vc.setColor(cc);
			images.put(vc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "VStripped.png"));
		}
		for (CandyColor cc: CandyColor.values()) {
			hc.setColor(cc);
			images.put(hc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "HStripped.png"));
		}

		//Imagenes de cell
		images.put(new JailCell().getKey(), new Image(IMAGE_PATH + "jail.png"));
	}

	public Image getImage(Element e) {
		String key = e.getFullKey();
		if(images.containsKey(key))
			return images.get(key);
		return null;
	}

	public Image getImage(Cell cell){
		String key = cell.getKey();
		if(images.containsKey(key))
			return images.get(key);
		return null;
	}

}
