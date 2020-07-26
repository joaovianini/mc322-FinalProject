package game;

public class Daggers extends Weapon {
	//as daggers dao +1 dado atk e quebram ap�s o uso.
	
	public Daggers(Creature c) {
		owner = c;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
	}
	
	public Daggers(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
	}
	
	public Daggers(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
		this.room = room;
	}
	
	public Daggers() {
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		creature = false;
	}
	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	@Override
	public void getCollected(Monster monster) {
		monster.bag.addItem(this);
	}
	
	public String toString() {
		return "Dagger";
	}
}
