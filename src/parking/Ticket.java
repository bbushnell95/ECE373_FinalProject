package parking;
import java.util.*;

public class Ticket {
	private Space parkingSpace;
	private int ID;
	private int validTime;
	private double cost;
	private Parking location;
	
	public Ticket(){
		ID = 0;
		validTime = 0;
		cost = 0.0;
	}
	
	public Ticket(Space pS, int iD, int vT, double c, Parking l){
		parkingSpace = pS;
		ID = iD;
		validTime = vT;
		cost = c;
		location = l;
	}
	
	public Space getParkingSpace() {
		return parkingSpace;
	}
	public void setParkingSpace(Space parkingSpace) {
		this.parkingSpace = parkingSpace;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getValidTime() {
		return validTime;
	}
	public void setValidTime(int validTime) {
		this.validTime = validTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Parking getLocation() {
		return location;
	}
	public void setLocation(Parking location) {
		this.location = location;
	}
	

	
}
