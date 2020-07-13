package game;

public abstract class Weapon extends Item implements Collectable {
	protected int numberExtraDices;
	protected boolean disappearAfterUse;
	protected boolean usesTwoHands;
	
	public void use(Creature creature) {
		
	}
}
