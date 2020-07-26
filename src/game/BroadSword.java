package game;

public final class BroadSword extends Weapon {

	public BroadSword(Hero hero) {
		owner = hero;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
	}
	
	public BroadSword(Monster monster) {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
	}
	
	public BroadSword(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
	}
	
	public BroadSword(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		this.room = room;
	}
	
	public BroadSword() {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
	}
	
	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {	
		monster.bag.addItem(this);
	}

}
