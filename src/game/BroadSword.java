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
	public void getCollected(Creature creature) {
		if(creature instanceof Hero) {
			((Hero) creature).bag.addItem(this);
		}

	}

}
