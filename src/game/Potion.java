package game;

public class Potion extends Item {
	protected String name;
	
	public Potion() {
		this.name = "Potion";
	}

	@Override
	public void getCollected(Creature c) {
		if (c instanceof Hero) {
			((Hero) c).bag.addItem(this);
		}
	}
	
	public void use(Hero h) {
		h.healthPoints += 2;
	}

}