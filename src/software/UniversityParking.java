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
	private ArrayList<User> users;
	private String currentUser;
	
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public UniversityParking(){
		garages = new ArrayList<Garage>();
		lots = new ArrayList<Lot>();
		users = new ArrayList<User>();
		users.add(new User("manager", 1)); // there is always a manager user
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

	public String getCurrentUser() {
		return currentUser;
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public int addUser(String name) {
		
		int userFound = 0;
		
		for (User user: users){
			if (user.getName().equals(name)) {
				// user already defined
				userFound = -1;
				break;
			}
		}
		if (userFound == 0) {
			users.add(new User(name, 0));
		}
		
		return userFound;
	}
	
	public int deleteUser(String name) {
		
		int userFound = 0;
		User theUser = null;
		
		for (User user: users){
			if (user.getName().equals(name)) {
				// user already defined
				userFound = -1;
				theUser = user;
				break;
			}
		}
		if (userFound == -1) {
			// delete all reservations
			for (Garage garage: this.getGarages()){
				for(Floor floor: garage.getFloors()){
					for(Space space: floor.getSpaces()){
						if(space.isOccupiedBy(currentUser)){
							space.emptySpace();
						}
					}
				}
			}
			
			for (Lot lot: this.getLots()){
				for(Space space: lot.getSpaces()){
					if(space.isOccupiedBy(currentUser)){
						space.emptySpace();
					}

				}
			}

			//delete the user
			users.remove(theUser);
		}
		
		return userFound;
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

	public int login(String username) {
		// find the user
		currentUser = username;
		int userResult = -1;
		
		for (User user: users){
			if (user.getName().equals(username)) {
				currentUser = username;
				userResult = user.getUserType();
				break;
			}
		}
		
		return userResult;
	}
	
	public void logout() {
		currentUser = "";
	}
	
	static UniversityParking loadData(UniversityParking univ){
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
			
		try
		{
			fileIn = new FileInputStream("universityparking.ser");
			if (fileIn != null) {
				objIn = new ObjectInputStream(fileIn);
				univ = (UniversityParking) objIn.readObject();
				objIn.close();
				fileIn.close();
			}
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
