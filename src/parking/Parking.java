package parking;

import java.io.Serializable;

public abstract class Parking implements Serializable{

	protected String name;
	protected String location;
	private String timesOpen;
	private int numberSpaces;
	private int remainingSpaces;
	private int numberCars;
	
	public Parking(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimesOpen() {
		return timesOpen;
	}

	public void setTimesOpen(String timesOpen) {
		this.timesOpen = timesOpen;
	}

	public int getNumberSpaces() {
		return numberSpaces;
	}

	public void setNumberSpaces(int numberSpaces) {
		this.numberSpaces = numberSpaces;
	}

	public int getRemainingSpaces() {
		return remainingSpaces;
	}

	public void setRemainingSpaces(int remainingSpaces) {
		this.remainingSpaces = remainingSpaces;
	}

	public int getNumberCars() {
		return numberCars;
	}

	public void setNumberCars(int numberCars) {
		this.numberCars = numberCars;
	}
	
	public abstract int calcRemainingSpaces();
	
}