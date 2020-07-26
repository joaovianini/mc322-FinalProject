package game;

public class EmptySpace extends MapItem {
	
	public EmptySpace() {
		creature = false;
	}
	
	public EmptySpace(int x, int y) {
		super(x,y);
		creature = false;
		
	}
	
	public EmptySpace(int x, int y, int room) {
		super(x,y);
		creature = false;
		this.room = room;
	}
	
	@Override
	public String toString() {
		String string = "   ";
		return string;
	}

}
