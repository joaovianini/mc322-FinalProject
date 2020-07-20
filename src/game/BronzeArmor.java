package game;

public class BronzeArmor extends Armor {

	public BronzeArmor(Creature c) {
		owner = c;
		extraDefenseDices = 1;
		disappearAfterUse = false;
	}
	
	public BronzeArmor() {
		owner = null;
		extraDefenseDices = 1;
		disappearAfterUse = false;
	}

}
