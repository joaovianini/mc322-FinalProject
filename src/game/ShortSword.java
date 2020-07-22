package game;

public final class ShortSword extends Weapon {
	
		
	public ShortSword(Hero hero) {
		owner = hero;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
	}

	public ShortSword(Monster monster) {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
	}
	
	public ShortSword() {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
	}
	
	
	public void getCollected(Hero hero) {
			hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {
			monster.bag.addItem(this);
	}
}
