package game;

public abstract class Weapon extends Item implements Collectable {
	protected int extraAtackDices;
	protected boolean disappearAfterUse;
	protected boolean usesTwoHands;
	
	public void use(Creature creature) {
		
	}
}
