package com.techelevator.dog;

public class Dog {
	private boolean isSleeping = false;
	
	public Dog() {  }
	
	
	public String makeSound() {
		if( this.isSleeping )
			return "Zzzzz...";
		return "Woof!";
	}
	
	
	public boolean isSleeping() { return this.isSleeping; }
	public void sleep() { this.isSleeping = true; }
	public void wakeUp() { this.isSleeping = false; }
}
