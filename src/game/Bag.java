package game;

import java.util.ArrayList;

public class Bag {
	private ArrayList<Item> list;
	
	public Bag() {
		list = new ArrayList<Item>();
	}
	;
	public void addItem(Item item) {
		list.add(item);
	}
	
	public Item getItemByIndex(int index) {
		Item item = list.get(index);
		return item;
	}
	
	public int getBagSize() {
		return list.size();
	}
}
