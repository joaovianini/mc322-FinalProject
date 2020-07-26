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
	protected Bag bag;

	@Override
	public void attack(MapItem creature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void defend(MapItem creature) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub

	}
	
	public void takeDamage(int damage) {
		this.healthPoints -= damage;
	}
	
	public int getHP() {
		return this.healthPoints;
	}
	
	public int getNumberAtkDices() {
		return this.numberAttackDices;
	}
	
	public int getNumberDefDices() {
		return this.numberDefenseDices;
	}

}
