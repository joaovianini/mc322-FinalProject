package game;

public class Barbarian extends Hero {
	
	public Barbarian(int x, int y, String name) {
		setPosition(x,y);
		this.name = name;
		numberAttackDices = 3;
		numberDefenseDices = 2;
		healthPoints = 8;
		intelligencePoints = 2;
		rightHandWeapon = new BroadSword(this);
		leftHandWeapon = null; 
		bag = new Bag();
		creature = true;
		setGenType(GeneralType.HERO);
	}
	
	public Barbarian(int x, int y, String name, int room) {
		setPosition(x,y);
		this.name = name;
		numberAttackDices = 3;
		numberDefenseDices = 2;
		healthPoints = 8;
		intelligencePoints = 2;
		rightHandWeapon = new BroadSword(this);
		leftHandWeapon = null; 
		bag = new Bag();
		creature = true;
		this.room = room;
	}

	@Override
	public String toString() {
		String string = " B ";
		return string;
	}

	
}
