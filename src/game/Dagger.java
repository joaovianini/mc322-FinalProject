package game;

public final class Dagger extends Weapon {
	
	public Dagger(Hero hero){
		owner = hero;
		numberExtraDices = 1;
		usesTwoHands = false;
		disappearAfterUse = true;
 	}

	@Override
	public void getCollected(Creature creature) {
		// TODO Auto-generated method stub

	}

}
