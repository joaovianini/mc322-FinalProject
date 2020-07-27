package game;

public class Daggers extends Weapon {
	//as daggers dao +1 dado atk e quebram ap�s o uso.
	
	public Daggers(Creature c) {
		owner = c;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public Daggers(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public Daggers(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public Daggers() {
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	@Override
	public void getCollected(Monster monster) {
		monster.bag.addItem(this);
	}
	
	public String toBag() {
		return "Dagger";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else
		return " A ";
	}
}
