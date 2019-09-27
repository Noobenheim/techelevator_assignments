package com.techelevator;

public class Television {
	public final int MAX_CHANNEL = 18;
	public final int MIN_CHANNEL = 3;
	public final int MAX_VOLUME = 10;
	public final int MIN_VOLUME = 0;
	
	public final boolean DEFAULT_ON = false;
	public final int DEFAULT_CHANNEL = 3;
	public final int DEFAULT_VOLUME = 2;
	
	private boolean isOn = DEFAULT_ON;
	private int currentChannel = DEFAULT_CHANNEL;
	private int currentVolume = DEFAULT_VOLUME;
	
	public void turnOff() { this.isOn = false; }
	public void turnOn() { 
		this.isOn = true;
		this.currentChannel = 3;
		this.currentVolume = 2;
	}
	public void changeChannel(int newChannel) {
		if( !this.isOn() || !this.inChannelRange(newChannel) ) return;
		
		this.currentChannel = newChannel;
	}
	public void channelUp() {
		if( !this.isOn() ) return;
		
		if( this.inChannelRange(this.getCurrentChannel() + 1) ) {
			this.currentChannel++;
		} else {
			this.currentChannel = MIN_CHANNEL;
		}
	}
	public void channelDown() {
		if( !this.isOn() ) return;
		
		if( this.inChannelRange( this.getCurrentChannel()-1 ) ) {
			this.currentChannel--;
		} else {
			this.currentChannel = MAX_CHANNEL;
		}
	}
	public void raiseVolume() {
		if( !this.isOn() ) return;
		
		if( this.inVolumeRange(this.getCurrentVolume()+1) ) {
			this.currentVolume++;
		}
	}
	public void lowerVolume() {
		if( !this.isOn ) return;
		
		if( this.inVolumeRange(this.getCurrentVolume()-1) ) {
			this.currentVolume--;
		}
	}
	
	private boolean inChannelRange(int value) {
		return this.inRange(value, MIN_CHANNEL, MAX_CHANNEL);
	}
	private boolean inVolumeRange(int value) {
		return this.inRange(value, MIN_VOLUME, MAX_VOLUME);
	}
	private boolean inRange(int value, int min, int max) {
		return value >= min && value <= max;
	}
	
	public boolean isOn() {
		return isOn;
	}
	public int getCurrentChannel() {
		return currentChannel;
	}
	public int getCurrentVolume() {
		return currentVolume;
	}
	
	
}
