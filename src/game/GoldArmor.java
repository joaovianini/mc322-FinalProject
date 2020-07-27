package game;

public class GoldArmor extends Armor {

	public GoldArmor(Creature c) {
			owner = c;
			extraDefenseDices = 3;
			disappearAfterUse = false;
			creature = false;
			setGenType(GeneralType.ITEM);
			setHidden(true);
	}
	
	public GoldArmor() {
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public GoldArmor(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	public GoldArmor(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public String toBag() {
		return "GoldArmor";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " O ";
	}
}
