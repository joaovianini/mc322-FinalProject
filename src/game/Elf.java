package game;
import java.util.ArrayList;

public class Elf extends Hero {
	protected ArrayList<Magic> magics;
	
	public Elf(int x, int y, String name) {
		setPosition(x,y);
		this.name = name;
		numberAttackDices = 2;
		numberDefenseDices = 2;
		healthPoints = 6;
		intelligencePoints = 4;
		rightHandWeapon = new ShortSword(this);
		leftHandWeapon = null; 
		magics = new ArrayList<Magic>();
		SimpleHeal simpleHeal = new SimpleHeal();
		magics.add(simpleHeal);
	}
	
	public void addMagic(Magic m) {
		this.magics.add(m);
	}
	
	@Override
	public String toString() {
		String string = " E ";
		return string;
	}
}
