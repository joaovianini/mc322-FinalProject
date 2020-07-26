package game;

public final class ShortSword extends Weapon {
	
		
	public ShortSword(Hero hero) {
		owner = hero;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
	}

	public ShortSword(Monster monster) {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
	}
	
	public ShortSword(int x, int y) {
		setPosition(x,y);
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
	}
	
	public ShortSword(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		this.room = room;
	}
	
	public ShortSword() {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
	}
	
	
	public void getCollected(Hero hero) {
			hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {
			monster.bag.addItem(this);
	}
}
