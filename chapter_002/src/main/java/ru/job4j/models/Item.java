package ru.job4j.models;

public class Item {
	public static final Item EMPTY = new Item();
	private String id;
	private String name;
	private String description;
	private long create;
	private String author;

	public Item() {
		
	}

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
		//this.create = create;
	}

	public Item(String name, String description, String author) {
		this.name = name;
		this.description = description;
		this.author = author;
		//this.create = create;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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