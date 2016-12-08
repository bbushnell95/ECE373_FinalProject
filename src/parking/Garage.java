package parking;
import java.io.Serializable;
import java.util.ArrayList;


public class Garage extends Parking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Floor> floors;
	private int x;
	private int y;
	
	
	public Garage(){
		name = "Unknown";
		location = "Unknown";
		floors = new ArrayList<Floor>();
	}
	
	public Garage(String n, String l, int x, int y){
		name = n;
		location = l;
		floors = new ArrayList<Floor>();
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	
	public void addFloor(Floor newFloor){
		floors.add(newFloor);
	}
	
	public int calcRemainingSpaces(){
		
		int countOfSpaces = 0;
		
		for(Floor currFloor : floors){
			countOfSpaces += currFloor.calcRemainingSpaces();
		}
		
		return countOfSpaces;
	}

	public int getY() {
				return y;
	}
	public int getX() {
		return x;
	}
}