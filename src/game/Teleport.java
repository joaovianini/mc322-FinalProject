package game;

public class Teleport extends MapItem implements Magic {
	protected String name;
	
	public Teleport() {
		name = "Teleport";
		setCreature(false);
	}
	
	public Teleport(int x, int y) {
		name = "Teleport";
		setCreature(false);
		setPosition(x,y);
	}
	
	public Teleport(int x, int y, int room) {
		name = "Teleport";
		setCreature(false);
		setPosition(x,y);
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
		
	}
	
	@Override
	public void cast(Monster caster, Hero target) {
		
	}

	@Override
	public void cast(Monster monster) {
		
	}
	
	@Override
	public void cast(Hero hero) {
		System.out.print("Escolha quantas casas pular: \n");
		//o caster teleporta para alguma casa que esteja no seu campo de vis�o.
	}

}
