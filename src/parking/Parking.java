package parking;

import java.io.Serializable;

public abstract class Parking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String location;
	private int numberSpaces;
	private int remainingSpaces;

	
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
	
	public abstract int calcRemainingSpaces();
	
}