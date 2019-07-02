package game.frontend;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MainMenu extends VBox {

    public MainMenu(Application app) {

        setPadding(new Insets(10, 50, 50, 50));
        setSpacing(10);

        setBackground(new Background(new BackgroundImage(new
                Image("images/menuBackground.png"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));


        for(Levels level : Levels.values()){
            Button button = new Button();
            button.setText(level.name());
            button.setOpacity(0.5);
            button.setOnMouseEntered(e->button.setOpacity(0.9));
            button.setOnMouseExited(e->button.setOpacity(0.5));
            button.setPrefWidth(200);
            button.setFont(Font.font("Roboto", FontWeight.BOLD, 24));
            button.setOnMouseClicked((event -> ((GameApp)app).startLevel(level)));
            getChildren().add(button);
        }
    }

}
