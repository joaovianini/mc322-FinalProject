package game;

public interface Creature {
	public void attack(Creature creature);
	public void defend(Creature creature);
	public void move(Direction direction);
}
