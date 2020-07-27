package game;

public interface Magic{
	public void cast(Hero caster, Monster target);
	public void cast(Monster caster, Hero target);
	public void cast(Monster monster);
	public void cast(Hero hero);
	public String toBag();
}
