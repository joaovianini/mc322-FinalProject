package game;

public class Goblins extends Monster {

	public Goblins(int x, int y) {
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
