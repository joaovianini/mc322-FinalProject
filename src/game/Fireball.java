package game;

import gameController.Map;

public class Fireball extends MapItem implements Magic {
//Fireball tem 6 de dano no target e 3 de dano nas posicoes adjacentes.
//enquanto nao temos mapa deixei apenas o dano no target

	Die die;

	public Fireball() {
		die = new Die();
		setCreature(false);
	}
	
	public Fireball(int x, int y) {
		super(x,y);
		setCreature(false);
	}
	
	public Fireball(int x, int y, int room) {
		super(x,y);
		setCreature(false);
		this.room = room;
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
	
	public String toString() {
		return "Fireball";
	}
	
}

