package parking;
import java.io.Serializable;
import java.util.*;


public class Floor  implements Serializable{
	private int floorNumber;
	private int spacesRemaining;
	private ArrayList<Space> spaces;
	
	public Floor(){
		floorNumber = -1;
		spacesRemaining = 0;
		spaces = new ArrayList<Space>();
	}
	
	public Floor(int fN){
		floorNumber = fN;
		spacesRemaining = 0;
		spaces = new ArrayList<Space>();
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getSpacesRemaining() {
		return spacesRemaining;
	}

	public void setSpacesRemaining(int spacesRemaining) {
		this.spacesRemaining = spacesRemaining;
	}

	public ArrayList<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(ArrayList<Space> spaces) {
		this.spaces = spaces;
	}
	
	public void addSpace(Space newSpace){
		spaces.add(newSpace);
	}
	
	public int calcRemainingSpaces(){
		int spacesEmpty = 0;
		
		for(Space check: spaces){
			if(!check.checkIfFull()){
				spacesEmpty++;
			}
		}
		
		spacesRemaining = spacesEmpty;
		
		return spacesEmpty;
	}

}
