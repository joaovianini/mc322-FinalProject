package game;

public class Dwarf extends Hero {

	public Dwarf(int x, int y, String name) {
		setPosition(x,y);
		this.name = name;
		numberAttackDices = 2;
		numberDefenseDices = 2;
		healthPoints = 7;
		intelligencePoints = 3;
		rightHandWeapon = new ShortSword(this);
		leftHandWeapon = null; 
	}

}
