package game.backend.level;

import game.backend.element.Element;

//La implementan los niveles que agregan un item especial, como frutas o bombas de tiempo.
public interface SpecialItemLevel {
    Element getSpecialLevelElement();
}
