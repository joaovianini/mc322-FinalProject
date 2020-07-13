package game;

public final class BroadSword extends Weapon {

	public BroadSword(Hero hero) {
		owner = hero;
		numberExtraDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
	}
	
	@Override
	public void getCollected(Creature creature) {
		// TODO Auto-generated method stub

	}

}
