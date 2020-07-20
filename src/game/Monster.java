package game;

public abstract class Monster extends MapItem implements Creature {
	protected int healthPoints;
	protected int intelligencePoints;
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
	public void move(char direction) {
		// TODO Auto-generated method stub

	}

}
