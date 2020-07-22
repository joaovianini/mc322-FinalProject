package game;

public class Fireball implements Magic {
//Fireball tem 6 de dano no target e 3 de dano nas posicoes adjacentes.
//enquanto nao temos mapa deixei apenas o dano no target

	
	public void getCollected(Wizard wiz) {
		wiz.addMagic(this);
	}
	
	public void getCollected(Elf elf) {
		elf.addMagic(this);
	}

	@Override
	public void cast(Hero caster, Monster target) {

		int dices = 1;
			//roll dices
		if (dices < caster.intelligencePoints) {
			target.healthPoints -= 6;
			//+3 de dano em adj
		}

}

	@Override
	public void cast(Monster caster, Hero target) {
		int dices = 1;
			//roll dices
			
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
	
}

