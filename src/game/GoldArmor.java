package game;

public class GoldArmor extends Armor {

	public GoldArmor(Creature c) {
			owner = c;
			extraDefenseDices = 3;
			disappearAfterUse = false;
			creature = false;
	}
	
	public GoldArmor() {
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
	}
	
	public GoldArmor(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
	}
	public GoldArmor(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
		this.room = room;
	}
	
	public String toString() {
		return "GoldArmor";
	}
}
