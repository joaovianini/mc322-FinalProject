package game;

public class MagicMissile extends MapItem implements Magic {
	protected String name;
	private boolean hidden;
	
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public MagicMissile() {
		name = "Magic Missile";
		creature = false;
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public MagicMissile(int x, int y) {
		setPosition(x,y);
		name = "Magic Missile";
		creature = false;
		setGenType(GeneralType.MAGIC);
		setHidden(true);
	}
	
	public MagicMissile(int x, int y, int room) {
		setPosition(x,y);
		name = "Magic Missile";
		creature = false;
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
	
	public String toString() {
		return " M ";
	}
	
	public String toBag() {
		if(isHidden()) {
			return "   ";
		}
		else return "MagicMissile";
	}

}


