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
	
	@Override
	public void getCollected(Creature creature) {
		if(creature instanceof Hero) {
			((Hero) creature).bag.addItem(this);
		}

	}

}
