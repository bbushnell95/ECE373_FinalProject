package software;

import java.util.*;

import parking.*;


public class UniversityParking {
	private ArrayList<Garage> garages;
	private ArrayList<Lot> lots;
	
	public UniversityParking(){
		garages = new ArrayList<Garage>();
		lots = new ArrayList<Lot>();
	}

	public ArrayList<Garage> getGarages() {
		return garages;
	}

	public void setGarages(ArrayList<Garage> garages) {
		this.garages = garages;
	}

	public ArrayList<Lot> getLots() {
		return lots;
	}

	public void setLots(ArrayList<Lot> lots) {
		this.lots = lots;
	}
	
	public void addLot(Lot l){
		lots.add(l);
	}
	
	public void addGarage(Garage g){
		garages.add(g);
	}
	

}
