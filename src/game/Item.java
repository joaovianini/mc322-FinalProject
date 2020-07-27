package game;

public class Item extends MapItem implements Collectable{
	protected Creature owner;
	private boolean hidden;
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
}

	public void getCollected(Monster monster) {
		monster.bag.addItem(this);
	}
}
