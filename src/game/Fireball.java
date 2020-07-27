package game;

import gameController.Map;

public class Fireball extends MapItem implements Magic {
//Fireball tem 6 de dano no target e 3 de dano nas posicoes adjacentes.
//enquanto nao temos mapa deixei apenas o dano no target

	Die die;
	private boolean hidden;
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public Fireball() {
		die = new Die();
		setCreature(false);
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public Fireball(int x, int y) {
		super(x,y);
		setCreature(false);
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public Fireball(int x, int y, int room) {
		super(x,y);
		setCreature(false);
		this.room = room;
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public void getCollected(Wizard wiz) {
		wiz.addMagic(this);
	}
	
	public void getCollected(Elf elf) {
		elf.addMagic(this);
	}

	@Override
	public void cast(Hero caster, Monster target) {

		int dices = die.rollRedDice();
		int targetX = target.getPositionX();
		int targetY = target.getPositionY();
		
		
		if (dices < caster.intelligencePoints) {
			target.healthPoints -= 6;
		}

}

	@Override
	public void cast(Monster caster, Hero target) {
		int dices = die.rollRedDice();
		int targetX = target.getPositionX();
		int targetY = target.getPositionY();
			
		if (dices < caster.intelligencePoints) {
			target.healthPoints -= 6;
			//nao sera preciso dano adj, ja que havera apenas 1 player no mapa
		}
	}

	@Override
	public void cast(Hero hero) {
		
	}
	
	@Override
	public void cast(Monster monster) {
		
	}
	
	public String toBag() {
		return "Fireball";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
		else return " F ";
	}
	
}

