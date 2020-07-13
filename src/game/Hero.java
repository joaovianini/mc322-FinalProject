package game;

public abstract class Hero extends MapItem implements Creature{
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
	
	public void attack(Creature creature) {
		
	}
	public void defend(Creature creature) {
		
	}
	public void move(char direction) {
	}
}
