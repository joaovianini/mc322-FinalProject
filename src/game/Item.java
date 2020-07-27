package game;

public abstract class Item extends MapItem implements Collectable{
	protected Creature owner;
	private boolean hidden;
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	

}
