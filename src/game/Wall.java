package game;

public class Wall extends MapItem {
		
	private int[] rooms;
	private int roomIndex;
 		
	public Wall(int x, int y) {
		setPosition(x,y);
		visible = true;
		accessible = false; 
		setCreature(false);
		room = -1;
		rooms = new int[2000];
		roomIndex = 0;
	}
	
	@Override
	public int getRoom() {
		return rooms[0];
	}

	@Override
	public void setRoom(int i) {
		rooms[roomIndex++] = i;
	}
	
	@Override
	public String toString() {
		String output = " & ";
		return output;
	}
	
	
	
	
}
