package game.frontend;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;


public enum CellEffects {

    NOEFFECT(){
        @Override
        public Effect getEffect(){
            return null;
        }
    },
    GOLDEN(){
        @Override
        public Effect getEffect(){
            Light.Distant spotLight = new Light.Distant();
            spotLight.setColor(Color.YELLOW);
            spotLight.setElevation(100);
            return new Lighting(spotLight);
        }

    };

    public abstract Effect getEffect();

}
