package game;

public class Goblin extends Monster {

	@Override
	public String toString() {
		return " G ";
	}

	public Goblin(int x, int y) {
		setPosition(x,y);
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new Daggers(this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
		this.bag.addItem(new Daggers(this));
		creature = true;
		accessible = false;
		
	}
	
	public Goblin(int x, int y, int room) {
		setPosition(x,y);
		this.healthPoints = 5;
		this.intelligencePoints = 0;
		this.numberAttackDices = 1;
		this.numberDefenseDices = 1;
		this.rightHandWeapon = new Daggers(this);
		this.leftHandWeapon= null; 
		this.armor = null;
		this.bag = new Bag();
		this.bag.addItem(new Daggers(this));
		creature = true;
		this.room = room;
	}

	@Override
	public void attack(MapItem creature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void defend(MapItem creature) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void move(Direction direction) {
		// TODO Auto-generated method stub
		
	}


}
