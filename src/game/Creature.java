package game;

public interface Creature {
	public void attack(MapItem creature);
	public void defend(MapItem creature);
	public void takeDamage(int damage);
	public void move(Direction direction);
}
