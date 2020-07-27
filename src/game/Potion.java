package game;

public class Potion extends Item {
	protected String name;
	
	public Potion() {
		this.name = "Potion";
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public Potion(int x, int y) {
		setPosition(x,y);
		this.name = "Potion";
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public Potion(int x, int y, int room) {
		setPosition(x,y);
		this.name = "Potion";
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(true);
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
	
	public String toBag() {
		return "Potion";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " P ";
	}

}