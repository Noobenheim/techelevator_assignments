package com.techelevator;

public class Wall {
	private int height;
	private int width;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Wall(int height, int width, String name) { 
		this.height = height;
		this.width = width;
		this.name = name;
	}

	public Wall(int height, int width) { 
		this.height = height;
		this.width = width;
	}

	public int getArea() {
		return height * width;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

}
