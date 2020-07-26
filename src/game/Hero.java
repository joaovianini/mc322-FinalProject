package game;

public abstract class Hero extends MapItem implements Creature {
	protected String name;
	protected int healthPoints;
	protected int intelligencePoints;
	protected Bag bag;
	protected int numberAttackDices;
	protected int numberDefenseDices;
	protected Weapon rightHandWeapon;
	protected Weapon leftHandWeapon;
	protected Armor armor;
	protected boolean controlled;
	
	@Override
	public void attack(Creature creature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void defend(Creature creature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub

	}
	

	public Bag getBag() {
		return this.bag;
	}

}
