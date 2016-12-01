package software;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import parking.*;


public class UniversityParking implements Serializable{

	private static final long serialVersionUID = 1L;
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

	public void checkExpiration(){
		for (Garage garage: this.getGarages()){
			for(Floor floor: garage.getFloors()){
				for(Space space: floor.getSpaces()){
					if(space.checkIfFull()){
						space.checkExpiration();
					}
				}
			}
		}
		
		for (Lot lot: this.getLots()){
			for(Space space: lot.getSpaces()){
				if(space.checkIfFull()){
					space.checkExpiration();
				}

			}
		}
	}
	
	public Parking findClosestGarage(double x, double y){
		Parking userParking = null;
		double minDist = Double.POSITIVE_INFINITY;
		for (Garage garage: this.getGarages()){
			Double xsq = Math.pow((garage.getY()-y), 2); 
			Double ysq = Math.pow((garage.getX()-x), 2);
			double distance = Math.sqrt(xsq+ysq);
			if(distance < minDist){
				minDist = distance;
				userParking = garage;
			}
		}
		for (Lot lot: this.getLots()){
			Double xsq = Math.pow((lot.getY()-y), 2); 
			Double ysq = Math.pow((lot.getX()-x), 2);
			double distance = Math.sqrt(xsq+ysq);
			if(distance < minDist){
				minDist = distance;
				userParking = lot;
			}
		}
		return userParking;	
	}

	static UniversityParking loadData(UniversityParking univ){
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
			
		try
		{
			fileIn = new FileInputStream("universityparking.ser");
			objIn = new ObjectInputStream(fileIn);
			univ = (UniversityParking) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(Exception i)
		{
			i.printStackTrace();
		}  
		return univ;
	}
	
	static void saveData(UniversityParking uni){	
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream( "universityparking.ser" );
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(uni);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }		
	}
	
}
