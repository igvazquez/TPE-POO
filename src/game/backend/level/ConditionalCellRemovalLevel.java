package game.backend.level;

import game.backend.cell.Cell;

//La implementan los niveles que desean remover las celdas solamente si un criterio es valido.
public interface ConditionalCellRemovalLevel {

    boolean cellRemovalCriteria(Cell cell);
}