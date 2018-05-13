package ru.job4j.models;

public class Item {
	private String id;
	private String name;
	private String description;
	private long create;
	public static final Item EMPTY = new Item();
	
	public Item() {
		
	}
	
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		//this.create = create;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreate() {
		return this.create; 
	}
	
	public String getId() {
		return this.id; 
	}
	
	public void setId(String id) {
		this.id = id;
	}
}