package game;

public class SimpleHeal extends MapItem implements Magic {
	protected String name;
	private boolean hidden;
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	public SimpleHeal(int x, int y) {
		super(x,y);
		name ="Simple Heal";
		creature = false;
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public SimpleHeal(int x, int y, int room) {
		super(x,y);
		name ="Simple Heal";
		creature = false;
		this.room = room;
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public SimpleHeal() {
		name ="Simple Heal";
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
	
	public String toBag() {
		return "Heal";
	}
	
	public String toString() {
		if(isHidden()) {
			return "   ";
		}
	 else return " C ";
	}
	}



