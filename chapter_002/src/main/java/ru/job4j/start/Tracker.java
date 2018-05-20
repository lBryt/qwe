package ru.job4j.start;

import ru.job4j.models.*;
import java.util.*;

public class Tracker extends Item {
	private static final Random RN = new Random();
	private Item[] items = new Item[100];
	private int position = 0;

	public Tracker() {
	}

	public Item add(Item item) {
		item.setId(generateId());
		this.items[position++] = item;
		return item;
	}

	public void replace(String id, Item item) {
		if (findById(id) != Item.EMPTY) {
			for (int index = 0; index != this.items.length; index++) {
				if (this.items[index] != null && this.items[index].getId().equals(id)) {
					this.items[index] = item;
					break;
				}
			}
		}
	}

	public void delete(String id) {
		for (int index = 0; index != this.items.length; index++) {
			if (this.items[index] != null && items[index].getId().equals(id)) {
				System.arraycopy(this.items, index + 1, this.items, index, this.items.length - 1 - index);
				position--;
				break;
			}
		}
	}

	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}

	protected Item findById(String id) {
		Item result = Item.EMPTY;
		for (Item item : items) {
			if (item != null && item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}

	protected Item findByName(String name) {
		Item result = Item.EMPTY;
		for (Item item : items) {
			if (item != null && item.getName().equals(name)) {
				result = item;
				break;
			}
		}
		return result;
	}

	private String generateId() {
		return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
	}
}