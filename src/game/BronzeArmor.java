package game;

public class BronzeArmor extends Armor {

	public BronzeArmor(Creature c) {
		owner = c;
		extraDefenseDices = 1;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public BronzeArmor() {
		owner = null;
		extraDefenseDices = 1;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}

	public BronzeArmor(int x, int y) {
		owner = null;
		extraDefenseDices = 1;
		disappearAfterUse = false;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public BronzeArmor(int x, int y, int room) {
		owner = null;
		extraDefenseDices = 1;
		disappearAfterUse = false;
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public String toBag() {
		return "BronzeArmor";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		return " H ";
		}
	}

