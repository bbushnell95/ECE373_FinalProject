package parking;
import java.util.ArrayList;


public class Garage{
	
	private ArrayList<Floor> floors;
	private double cost;
	
	
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
	
	public int calcRemainingSpaces(){
		
		int countOfSpaces = 0;
		
		for(Floor currFloor : floors){
			countOfSpaces += currFloor.calcRemainingSpaces();
		}
		
		return countOfSpaces;
	}
}