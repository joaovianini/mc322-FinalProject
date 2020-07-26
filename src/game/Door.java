package game;

public class Door extends MapItem {
	
	int room1, room2;
	
	public Door(){
		creature = false;
		accessible = true;
	}
	
	public Door(int x, int y, int room1, int room2){
		creature = false;
		accessible = true;
		this.room1 = room1;
		this.room2 = room2;
	}
	
	public Door(int x, int y) {
		super(x,y);
	}
	
	
	@Override
	public String toString() {
		return " U ";
	}


}
