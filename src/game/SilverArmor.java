package game;

public class SilverArmor extends Armor {

	public SilverArmor(Creature c) {
		owner = c;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public SilverArmor() {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}

	public SilverArmor(int x, int y) {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		setPosition(x,y);
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public SilverArmor(int x, int y, int room) {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
		setPosition(x,y);
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public String toBag() {
		return "SiverArmor";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " X ";
	}
}
