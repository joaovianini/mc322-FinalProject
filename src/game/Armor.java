package game;

public abstract class Armor extends Item implements Collectable {
	protected int extraDefenseDices;
	protected boolean  disappearAfterUse;

	@Override
	public void getCollected(Hero hero) {
	}
	@Override
	public void getCollected(Monster monster) {
		
	}

}
