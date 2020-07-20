package game;

public class SimpleHeal implements Magic {
	protected String name;
	
	public SimpleHeal() {
		name ="Simple Heal";
	}
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
		if (caster instanceof Hero) {
			//roll dices
			if (dices < ((Hero) caster).intelligencePoints) {
				((Hero) caster).healthPoints += 6;
			}
		}
		
		if (caster instanceof Monster) {
			//roll dices
			if (dices < ((Monster) caster).intelligencePoints) {
				((Monster) caster).healthPoints += 6;
			}
		}
	}

}
