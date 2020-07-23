package game;

public class Door extends MapItem {
	
	private boolean locked;
	
	
	public Door(){
		
	}
	
	public Door(int x, int y) {
		super(x,y);
		locked = false;
	}
	
	public boolean isLocked() {
			return locked;
		}
	
	public void setLocked(boolean locked) {
			this.locked = locked;
			if(locked = true) {
				accessible = false;
			}
			else {
				accessible = true;
			}
	}
	
	@Override
	public String toString() {
		return " P ";
	}


}
