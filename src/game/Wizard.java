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
		rightHandWeapon = new Daggers(this);
		leftHandWeapon = new Daggers(this); 
		magics = new ArrayList<Magic>();
		bag = new Bag();
		bag.addItem(new Daggers(this));
		setCreature(true);
	}
	
	public Wizard(int x, int y, String name, int room) {
		setPosition(x,y);
		this.name = name;
		numberAttackDices = 1;
		numberDefenseDices = 2;
		healthPoints = 4;
		intelligencePoints = 6;
		rightHandWeapon = new Daggers(this);
		leftHandWeapon = new Daggers(this); 
		magics = new ArrayList<Magic>();
		bag = new Bag();
		bag.addItem(new Daggers(this));
		setCreature(true);
		this.room = room;
	}
	public void addMagic(Magic m) {
		this.magics.add(m);
	}
	
	@Override
	public String toString() {
		String string = " W ";
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
