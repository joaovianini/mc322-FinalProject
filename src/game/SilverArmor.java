package game;

public class SilverArmor extends Armor {

	public SilverArmor(Creature c) {
		owner = c;
		extraDefenseDices = 2;
		disappearAfterUse = false;
	}
	
	public SilverArmor() {
		owner = null;
		extraDefenseDices = 2;
		disappearAfterUse = false;
	}

}
