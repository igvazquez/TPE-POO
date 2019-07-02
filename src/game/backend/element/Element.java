package game.backend.element;

import game.backend.move.Direction;

public abstract class Element {
	
	public abstract boolean isMovable();
	
	public abstract String getKey();
	
	public String getFullKey() {
		return getKey();
	}

	public boolean isSolid() {
		return true;
	}
	
	public Direction[] explode() {
		return null;
	}
	
	public long getScore() {
		return 0;
	}

	public boolean isCombinable(){
	    return true;
    }

    public boolean isExpirable(){
		return false;
	}

	public boolean hasBonus(){return false;}

	public boolean hasEffect(){
		return false;
	}
}
