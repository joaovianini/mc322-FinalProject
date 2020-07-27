package game;

public final class BroadSword extends Weapon {

	public BroadSword(Hero hero) {
		owner = hero;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public BroadSword(Monster monster) {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public BroadSword(int x, int y) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(true);
	}
	
	public BroadSword(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
	}
	
	public BroadSword() {
		owner = null;
		extraAtackDices = 3;
		disappearAfterUse = false;
		usesTwoHands = true;
		creature = false;
		setGenType(GeneralType.ITEM);
	}
	
	@Override
	public void getCollected(Hero hero) {
		hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {	
		monster.bag.addItem(this);
	}
	
	public String toBag() {
		return "BroadSword";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " L ";
	}

}
