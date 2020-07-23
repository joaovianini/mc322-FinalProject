package game;

public class MapItem {
	protected int x;
		protected int y;
	protected boolean accessible;
	protected boolean visible;
	
	public MapItem() {
		x = 0;
		y = 0;
		accessible = true;
		visible = true;
	}

	public MapItem(int x, int y) {
		this.x = x;
		this.y = y;
		accessible = true;
		visible = true;
	}
	
	public MapItem(int x, int y, boolean accessible) {
		this.x = x;
		this.y = y;
		this.accessible = accessible;
		visible = true;
	}
	
	public MapItem(int x, int y, boolean accessible, boolean visible) {
		this.x = x;
		this.y = y;
		this.accessible = accessible;
		this.visible = visible;
	}

	public boolean isAccessible() {
		return accessible;
	}

	public void setAccessible(boolean accessible) {
		this.accessible = accessible;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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
