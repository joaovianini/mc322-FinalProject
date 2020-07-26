package game;

import java.util.ArrayList;

public class SkeletonWizard extends Monster {
	protected ArrayList<Magic> magics;
	
	public SkeletonWizard(int x, int y) {
		this.x = x;
		this.y =y;
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new ShortSword(this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
		magics = new ArrayList<Magic>();
		MagicMissile m = new MagicMissile();
		magics.add(m);
		creature = true;
	}

	public SkeletonWizard(int x, int y, int room) {
		this.x = x;
		this.y =y;
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new ShortSword(this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
		magics = new ArrayList<Magic>();
		MagicMissile m = new MagicMissile();
		magics.add(m);
		creature = true;
		this.room = room;
		accessible = false;
	}
	@Override
	public String toString() {
		return " R ";
	}

	
	
}
