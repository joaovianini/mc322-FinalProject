package game;

public class SilverArmor extends Armor {

	public SilverArmor(Creature c) {
		owner = c;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		creature = false;
	}
	
	public SilverArmor() {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		creature = false;
	}

	public SilverArmor(int x, int y) {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		setPosition(x,y);
		creature = false;
	}
	
	public SilverArmor(int x, int y, int room) {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		setPosition(x,y);
		creature = false;
		this.room = room;
	}
}
