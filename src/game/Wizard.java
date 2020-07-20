package game;
import java.util.ArrayList;

public class Wizard extends Hero {
	private ArrayList<Magic> magics;
	
	public Wizard(int x, int y, String name) {
				setPosition(x,y);
				this.name = name;
				numberAttackDices = 1;
				numberDefenseDices = 2;
				healthPoints = 4;
				intelligencePoints = 6;
				rightHandWeapon = new Daggers(3, this);
				leftHandWeapon = null; 
				magics = new ArrayList<Magic>();
			}
	public void addMagic(Magic m) {
		this.magics.add(m);
	}
}
