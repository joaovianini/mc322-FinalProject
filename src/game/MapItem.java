package game;

public class MapItem {
	protected int x;
	protected int y;
	protected boolean accessible;
	
	public MapItem() {
		x = 0;
		y = 0;
		accessible = true;
	}

	public MapItem(int x, int y) {
		this.x = x;
		this.y = y;
		accessible = true;
	}
	
	public MapItem(int x, int y, boolean accessible) {
		this.x = x;
		this.y = y;
		this.accessible = accessible;
	}

	public int getPositionX() {
		return x;
	}
	
	public int getPositionY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
