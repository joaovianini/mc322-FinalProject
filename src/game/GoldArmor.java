package game;

public class GoldArmor extends Armor {

	public GoldArmor(Creature c) {
			owner = c;
			extraDefenseDices = 3;
			disappearAfterUse = false;
	}
	
	public GoldArmor() {
		owner = null;
		extraDefenseDices = 3;
		disappearAfterUse = false;
	}
}
