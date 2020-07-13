package game;

public final class ShortSword extends Weapon {
	
		
	public ShortSword(Hero hero) {
		owner = hero;
		disappearAfterUse = false;
		usesTwoHands = false;
		numberExtraDices = 2;
	}

	@Override
	public void getCollected(Creature creature) {
		// TODO Auto-generated method stub

	}

}
