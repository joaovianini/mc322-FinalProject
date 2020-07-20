package game;

public class Teleport implements Magic {
	protected String name;
	
	public Teleport() {
		name = "Teleport";
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
		System.out.print("Escolha quantas casas pular: \n");
		//o caster teleporta para alguma casa que esteja no seu campo de visão.
	}

}
