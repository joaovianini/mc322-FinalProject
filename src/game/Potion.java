package game;

public class Potion extends Item {
	protected String name;
	
	public Potion() {
		this.name = "Potion";
		creature = false;
	}
	
	public Potion(int x, int y) {
		setPosition(x,y);
		this.name = "Potion";
		creature = false;
	}
	
	public Potion(int x, int y, int room) {
		setPosition(x,y);
		this.name = "Potion";
		creature = false;
		this.room = room;
	}


	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {
		monster.bag.addItem(this);
	}
	
	public void use(Hero h) {
		h.healthPoints += 2;
	}
	
	public String toString() {
		return "Potion";
	}

}