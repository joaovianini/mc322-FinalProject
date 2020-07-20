package game;

public class Fireball implements Magic {
//Fireball tem 6 de dano no target e 3 de dano nas posicoes adjacentes.
//enquanto nao temos mapa deixei apenas o dano no target

	@Override
	public void getCollected(Creature c) {
		if (c instanceof Elf ) {
			((Elf) c).addMagic(this);
		}
		else if (c instanceof Wizard) {
			((Wizard) c).addMagic(this);
		}
	}

	@Override
	public void cast(Creature caster, Creature target) {

		int dices = 1;
		if (caster instanceof Hero && target instanceof Monster) {
			//roll dices
			if (dices < ((Hero) caster).intelligencePoints) {
				((Monster) target).healthPoints -= 6;
				//+3 de dano em adj
			}
		}
		
		if (caster instanceof Monster && target instanceof Hero) {
			//roll dices
			if (dices < ((Monster) caster).intelligencePoints) {
				((Hero) target).healthPoints -= 6;
				//nao sera preciso dano adj, ja que havera apenas 1 player no mapa
			}
		}

	}
}

