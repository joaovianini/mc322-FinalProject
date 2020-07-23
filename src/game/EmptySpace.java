package game;

public class EmptySpace extends MapItem {
	
	public EmptySpace() {
		
	}
	
	public EmptySpace(int x, int y) {
		super(x,y);
	}
	@Override
	public String toString() {
		String string = "   ";
		return string;
	}

}
