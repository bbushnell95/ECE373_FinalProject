package parking;
import java.util.ArrayList;


public class Garage extends Parking{
	
	private ArrayList<Floor> floors;
	private double cost;
	
	
	public Garage(){
		name = "Unknown";
		location = "Unknown";
		floors = new ArrayList<Floor>();
	}
	
	public Garage(String n, String l){
		name = n;
		location = l;
		floors = new ArrayList<Floor>();
	}
	
	public ArrayList<Floor> getFloors() {
		return floors;
	}
	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
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
}