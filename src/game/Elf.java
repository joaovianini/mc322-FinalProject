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
		bag = new Bag();
		creature = true;
	}
	
	public Elf(int x, int y, String name, int room) {
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
		bag = new Bag();
		creature = true;
		this.room = room;
	}
	
	public void addMagic(Magic m) {
		this.magics.add(m);
	}
	
	@Override
	public String toString() {
		String string = " E ";
		return string;
	}
	
	public void printMagics() {
		System.out.printf("| MAGICS | %d total |:", magics.size());
		for (int i = 0; i<magics.size();i++) {
			System.out.printf(" (%d - %s) ", i, magics.get(i).toString());
		}
		System.out.print("\n");
	}
}
