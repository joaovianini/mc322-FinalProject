package game;

public final class ShortSword extends Weapon {
	
		
	public ShortSword(Hero hero) {
		owner = hero;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		setHidden(false);
	}

	public ShortSword(Monster monster) {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		setHidden(false);
	}
	
	public ShortSword(int x, int y) {
		setPosition(x,y);
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(false);
	}
	
	public ShortSword(int x, int y, int room) {
		setPosition(x,y);
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		this.room = room;
		setGenType(GeneralType.ITEM);
		setHidden(false);
	}
	
	public ShortSword() {
		owner = null;
		disappearAfterUse = false;
		usesTwoHands = false;
		extraAtackDices = 2;
		creature = false;
		setGenType(GeneralType.ITEM);
		setHidden(false);
	}
	
	
	public void getCollected(Hero hero) {
			hero.bag.addItem(this);
	}

	public void getCollected(Monster monster) {
			monster.bag.addItem(this);
	}
	
	public String toBag() {
		return "ShortSword";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " N ";
	}
}
