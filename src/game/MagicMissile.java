package game;

public class MagicMissile implements Magic {
	protected String name;

	public MagicMissile() {
		name = "Magic Missile";
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
		if (caster instanceof Hero && target instanceof Monster) {
			//roll dices
			if (dices < ((Hero) caster).intelligencePoints) {
				((Monster) target).healthPoints -= 6;
			}
		}
		
		if (caster instanceof Monster && target instanceof Hero) {
			//roll dices
			if (dices < ((Monster) caster).intelligencePoints) {
				((Hero) target).healthPoints -= 6;
			}
		}

	}

}
