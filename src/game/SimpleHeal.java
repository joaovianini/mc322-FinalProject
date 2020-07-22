package game;

public class SimpleHeal implements Magic {
	protected String name;
	
	public SimpleHeal() {
		name ="Simple Heal";
	}
	
	public void getCollected(Wizard wiz) {
		wiz.addMagic(this);
	}
	
	public void getCollected(Elf elf) {
		elf.addMagic(this);
	}
	
	
	@Override
	public void cast(Hero caster, Monster target) {
		
	}
	
	public void cast(Monster caster, Hero target) {
		
	}
	
	public void cast(Hero caster) {
		int dices = 1;		
			if (dices < caster.intelligencePoints) {
				caster.healthPoints += 6;
			}		
	}
	
	public void cast(Monster caster) {
		int dices = 1;
			if (dices < caster.intelligencePoints) {
				caster.healthPoints += 6;
			}
		}
	}



