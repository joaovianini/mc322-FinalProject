package game;

public class Goblin extends Monster {

	@Override
	public String toString() {
		return " G ";
	}

	public Goblin(int x, int y) {
		this.x = x;
		this.y = y;
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new Daggers(2, this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
	}

}
