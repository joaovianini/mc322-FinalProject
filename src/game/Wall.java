package game;

public class Wall extends MapItem {
		
		
	public Wall(int x, int y) {
		setPosition(x,y);
		visible = true;
		accessible = false; 
		setCreature(false);
		room = -1;
		
	}

	
	@Override
	public String toString() {
		String output = " & ";
		return output;
	}
	
	
	
	
}
