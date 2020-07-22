package game;

public final class BroadSword extends Weapon {

	public BroadSword(Hero hero) {
		owner = hero;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
	}
	
	public BroadSword(Monster monster) {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
	}
	public BroadSword() {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
	}
	
	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {	
		monster.bag.addItem(this);
	}

}
