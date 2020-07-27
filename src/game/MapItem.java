package game;

public class MapItem {
	protected int x;
	protected int y;
	protected int room;
	protected boolean accessible;
	protected boolean visible;
	protected boolean creature;
	protected boolean existsOnMap;
	private GeneralType genType;
	
	public MapItem() {
		this.x = x;
		this.y = y;
		accessible = true;
		visible = true;
		existsOnMap = false;
	}
	

	public boolean ExistsOnMap() {
		return existsOnMap;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public boolean isCreature() {
		return creature;
	}

	public void setCreature(boolean creature) {
		this.creature = creature;
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

	public String toBag() {
		String a = " ";
		return a;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		existsOnMap = true;
	}


	public GeneralType getGenType() {
		return genType;
	}


	public void setGenType(GeneralType genType) {
		this.genType = genType;
	}
	
	public boolean isHidden() {
		return false;
	}
	
	public void setHidden(boolean bool) {
		
	}
}

