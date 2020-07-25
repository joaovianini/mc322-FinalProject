package game;

public class Skeleton extends Monster {

	public Skeleton(int x, int y) {
		this.x = x;
		this.y = y;
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new ShortSword(this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
	}

	@Override
	public String toString() {
		return " S ";
	}

	
}
