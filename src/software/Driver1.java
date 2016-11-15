package software;

import parking.*;

public class Driver1 {
	public static void main(String args[]) {
		UniversityParking univParking = new UniversityParking();
		Garage cherryGarage = new Garage("Cherry Garage", "Cherry Ave");
		Lot zone1Lot = new Lot("Zone 1", "North of Campus");
		
		/*Create floors to add to garage*/
		Floor cgFloor1 = new Floor(1);
		Floor cgFloor2 = new Floor(2);
		Floor cgFloor3 = new Floor(3);
		
		/*Create Spaces to add to floors*/
		Space cgFloor1Space1 = new Space();
		Space cgFloor1Space2 = new Space();
		Space cgFloor1Space3 = new Space();
		
		Space cgFloor2Space1 = new Space();
		Space cgFloor2Space2 = new Space();
		Space cgFloor2Space3 = new Space();
		Space cgFloor2Space4 = new Space();
		
		Space cgFloor3Space1 = new Space();
		Space cgFloor3Space2 = new Space();
		Space cgFloor3Space3 = new Space();
		
		/*Add spaces to floors*/
		cgFloor1.addSpace(cgFloor1Space1);
		cgFloor1.addSpace(cgFloor1Space2);
		cgFloor1.addSpace(cgFloor1Space3);
		
		cgFloor2.addSpace(cgFloor2Space1);
		cgFloor2.addSpace(cgFloor2Space2);
		cgFloor2.addSpace(cgFloor2Space3);
		cgFloor2.addSpace(cgFloor2Space4);
		
		cgFloor3.addSpace(cgFloor3Space1);
		cgFloor3.addSpace(cgFloor3Space2);
		cgFloor3.addSpace(cgFloor3Space3);
		
		/*Add floors to Garage*/
		cherryGarage.addFloor(cgFloor1);
		cherryGarage.addFloor(cgFloor2);
		cherryGarage.addFloor(cgFloor3);
		
		/*Add Garages and lots to univParking*/
		univParking.addGarage(cherryGarage);
		univParking.addLot(zone1Lot);
		
		/*Checking garage info*/
		for(Garage currGarage: univParking.getGarages()){
			System.out.println("Info for " + currGarage.getName() + "\n");
			System.out.println("Location:" + currGarage.getLocation() + "\n");
			System.out.println("Number of Floors: " + currGarage.getFloors().size());
		
			/*Checking number of spaces on each floor of cherry Garage*/
			for(Floor currFloor: currGarage.getFloors()){
				System.out.println("Number of spaces on Floor " + currFloor.getFloorNumber() + ": " + currFloor.getSpaces().size());
			}
		}
		
	}

}
