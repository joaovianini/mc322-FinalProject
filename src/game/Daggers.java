package game;

public class Daggers extends Weapon {
	protected int numberofDaggers;
	//as daggers dao +1 dado atk e quebram após o uso, sendo n o numero de adagas disponiveis;
	
	public Daggers(int n, Creature c) {
		owner = c;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
		numberofDaggers = n;
	}
	public Daggers(int n) {
		owner = null;
		extraAtackDices = 1;
		disappearAfterUse = true;
		usesTwoHands = false;
	}
	@Override
	public void getCollected(Creature c) {
		if (c instanceof Hero) {
			((Hero) c).bag.addItem(this);
		}
	}

}
