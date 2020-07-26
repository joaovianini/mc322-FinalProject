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
	public void attack(MapItem creature) {

	}
	
	public void attack(Monster monster, int damage) {
		if (damage >= 0) {
			monster.takeDamage(damage);
		} else {
			this.takeDamage(damage);
		}
		
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
		this.healthPoints += damage;
	}

	public Bag getBag() {
		return this.bag;
	}
	
	public int getNumberAtkDices() {
		return this.numberAttackDices;
	}
	
	public int getNumberDefDices() {
		return this.numberDefenseDices;
	}
	
	public int getHP() {
		return this.healthPoints;
	}

}
