package game;

public class Potion extends Item {
	protected String name;
	
	public Potion() {
		this.name = "Potion";
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

}