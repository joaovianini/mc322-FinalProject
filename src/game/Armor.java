package game;

public class Armor extends Item implements Collectable {
	protected int extraDefenseDices;
	protected boolean  disappearAfterUse;

	@Override
	public void getCollected(Creature c) {
	}

}
