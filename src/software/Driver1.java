package software;

import parking.*;

public class Driver1 {
	public static void main(String args[]) {
		UniversityParking univParking = new UniversityParking();
		Garage cherryGarage = new Garage("Cherry Garage", "Cherry Ave", 810, 631);
		Garage mainGateGarage = new Garage("Main Gate Garage", "Euclid Ave", 43, 382);
		Garage secondStreetGarage = new Garage("2nd Street Garage", "2nd Street", 519, 378);
		Lot zone1Lot = new Lot("Zone 1 (2147)", "North of Campus", 730, 31);
		Lot south6Lot1 = new Lot("South of 6th (7167)", "South of Campus",209 ,830);
		
		//spaces havent been added to any of the garages below
		Garage parkAveGarage = new Garage("Park Ave Garage", "2nd Street", 247, 124);
		Garage highlandGarage = new Garage("Highland Garage", "2nd Street",595, 39);
		Garage tyndallAveGarage = new Garage("Tyndall Ave. Garage", "2nd Street", 74, 639);
		Garage sixthStreetGarage = new Garage("Sixth Street Garage", "2nd Street", 341, 772);
		Lot zone1Lot1 = new Lot("Zone 1 (2021)", "North of Campus", 607, 138);
		Lot zone1Lot2= new Lot("Zone 1 (1172)", "North of Campus", 323, 37);
		Lot zone1Lot3 = new Lot("Zone 1 (6091)", "North of Campus", 623, 784);
		Lot south6Lot2 = new Lot("South of 6th (8138)", "South of Campus",825 ,823);
		
		/*Create floors to add to garages*/
		//cherry garage
		Floor cgFloor1 = new Floor(1);
		Floor cgFloor2 = new Floor(2);
		Floor cgFloor3 = new Floor(3);
		
		//main gate garage
		Floor mgFloor1 = new Floor(1);
		Floor mgFloor2 = new Floor(2);
		Floor mgFloor3 = new Floor(3);
		Floor mgFloor4 = new Floor(4);
		
		//2nd Street Garage
		Floor sgFloor1 = new Floor(1);
		Floor sgFloor2 = new Floor(2);
		
		
		/*Create Spaces to add to floors*/
		//Cherry Garage
		Space cgFloor1Space1 = new Space();
		Space cgFloor1Space2 = new Space();
		Space cgFloor1Space3 = new Space();
		Space cgFloor1Space4 = new Space();
		
		Space cgFloor2Space1 = new Space();
		Space cgFloor2Space2 = new Space();
		Space cgFloor2Space3 = new Space();
		Space cgFloor2Space4 = new Space();
		
		Space cgFloor3Space1 = new Space();
		Space cgFloor3Space2 = new Space();
		Space cgFloor3Space3 = new Space();
		Space cgFloor3Space4 = new Space();
		
		//Main Gate Garage
		Space mgFloor1Space1 = new Space();
		Space mgFloor1Space2 = new Space();
		Space mgFloor1Space3 = new Space();
		Space mgFloor1Space4 = new Space();
		
		Space mgFloor2Space1 = new Space();
		Space mgFloor2Space2 = new Space();
		Space mgFloor2Space3 = new Space();
		Space mgFloor2Space4 = new Space();
		
		Space mgFloor3Space1 = new Space();
		Space mgFloor3Space2 = new Space();
		Space mgFloor3Space3 = new Space();
		Space mgFloor3Space4 = new Space();
		
		Space mgFloor4Space1 = new Space();
		Space mgFloor4Space2 = new Space();
		Space mgFloor4Space3 = new Space();
		Space mgFloor4Space4 = new Space();
		
		//Second Street Garage
		Space sgFloor1Space1 = new Space();
		Space sgFloor1Space2 = new Space();
		Space sgFloor1Space3 = new Space();
		Space sgFloor1Space4 = new Space();
		
		Space sgFloor2Space1 = new Space();
		Space sgFloor2Space2 = new Space();
		Space sgFloor2Space3 = new Space();
		Space sgFloor2Space4 = new Space();
		
		//Zone1 lot
		Space z1LotSpace1 = new Space();
		Space z1LotSpace2 = new Space();
		Space z1LotSpace3 = new Space();
		Space z1LotSpace4 = new Space();
		Space z1LotSpace5 = new Space();
		
		//South6 Lot
		Space s6LotSpace1 = new Space();
		Space s6LotSpace2 = new Space();
		Space s6LotSpace3 = new Space();
		Space s6LotSpace4 = new Space();
		Space s6LotSpace5 = new Space();
		
		
		/*Add spaces to floors*/
		//Cherry Garage
		cgFloor1.addSpace(cgFloor1Space1);
		cgFloor1.addSpace(cgFloor1Space2);
		cgFloor1.addSpace(cgFloor1Space3);
		cgFloor1.addSpace(cgFloor1Space4);
		
		cgFloor2.addSpace(cgFloor2Space1);
		cgFloor2.addSpace(cgFloor2Space2);
		cgFloor2.addSpace(cgFloor2Space3);
		cgFloor2.addSpace(cgFloor2Space4);
		
		cgFloor3.addSpace(cgFloor3Space1);
		cgFloor3.addSpace(cgFloor3Space2);
		cgFloor3.addSpace(cgFloor3Space3);
		cgFloor3.addSpace(cgFloor3Space4);
		
		//Main Gate Garage
		mgFloor1.addSpace(mgFloor1Space1);
		mgFloor1.addSpace(mgFloor1Space2);
		mgFloor1.addSpace(mgFloor1Space3);
		mgFloor1.addSpace(mgFloor1Space4);
		
		mgFloor2.addSpace(mgFloor2Space1);
		mgFloor2.addSpace(mgFloor2Space2);
		mgFloor2.addSpace(mgFloor2Space3);
		mgFloor2.addSpace(mgFloor2Space4);
		
		mgFloor3.addSpace(mgFloor3Space1);
		mgFloor3.addSpace(mgFloor3Space2);
		mgFloor3.addSpace(mgFloor3Space3);
		mgFloor3.addSpace(mgFloor3Space4);
		
		mgFloor4.addSpace(mgFloor4Space1);
		mgFloor4.addSpace(mgFloor4Space2);
		mgFloor4.addSpace(mgFloor4Space3);
		mgFloor4.addSpace(mgFloor4Space4);
		
		//Second Street Garage
		sgFloor1.addSpace(sgFloor1Space1);
		sgFloor1.addSpace(sgFloor1Space2);
		sgFloor1.addSpace(sgFloor1Space3);
		sgFloor1.addSpace(sgFloor1Space4);
		
		sgFloor2.addSpace(sgFloor2Space1);
		sgFloor2.addSpace(sgFloor2Space2);
		sgFloor2.addSpace(sgFloor2Space3);
		sgFloor2.addSpace(sgFloor2Space4);
		
		//Zone 1 Lot
		zone1Lot.addSpace(z1LotSpace1);
		zone1Lot.addSpace(z1LotSpace2);
		zone1Lot.addSpace(z1LotSpace3);
		zone1Lot.addSpace(z1LotSpace4);
		zone1Lot.addSpace(z1LotSpace5);
		
		//South of 6 Lot
		south6Lot1.addSpace(s6LotSpace1);
		south6Lot1.addSpace(s6LotSpace2);
		south6Lot1.addSpace(s6LotSpace3);
		south6Lot1.addSpace(s6LotSpace4);
		south6Lot1.addSpace(s6LotSpace5);
		
		/*Add floors to Garage*/
		//Cherry Garage
		cherryGarage.addFloor(cgFloor1);
		cherryGarage.addFloor(cgFloor2);
		cherryGarage.addFloor(cgFloor3);
		
		//Main Gate
		mainGateGarage.addFloor(mgFloor1);
		mainGateGarage.addFloor(mgFloor2);
		mainGateGarage.addFloor(mgFloor3);
		mainGateGarage.addFloor(mgFloor4);
		
		//Second Street
		secondStreetGarage.addFloor(sgFloor1);
		secondStreetGarage.addFloor(sgFloor2);
		
		/*Add Garages and lots to univParking*/
		univParking.addGarage(cherryGarage);
		univParking.addGarage(mainGateGarage);
		univParking.addGarage(secondStreetGarage);
		univParking.addLot(zone1Lot);
		univParking.addLot(south6Lot1);
		
		 new ParkingGUI("test", univParking); 
		
		/*Checking garage info*/
		for(Garage currGarage: univParking.getGarages()){
			System.out.println("Info for " + currGarage.getName());
			System.out.println("\tLocation:" + currGarage.getLocation());
			System.out.println("\tNumber of Floors: " + currGarage.getFloors().size());
		
			/*Checking number of spaces on each floor of cherry Garage*/
			for(Floor currFloor: currGarage.getFloors()){
				System.out.println("\t\tNumber of spaces on Floor " + currFloor.getFloorNumber() + ": " + currFloor.getSpaces().size());
			}
		}
		/*Checking lot info*/
		for(Lot currLot: univParking.getLots()){
			System.out.println("Info for " + currLot.getName());
			System.out.println("\tLocation:" + currLot.getLocation());
			System.out.println("\tNumber of Spaces: " + currLot.getSpaces().size());
		}
		
		/*System.out.println("\nTesting filling spaces: ");
		
		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(0).fillSpace();
		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(1).fillSpace();
		*/
		System.out.println("\tNumber of Spaces remaining on floor " + univParking.getGarages().get(0).getFloors().get(0).getFloorNumber() + 
				" of " + univParking.getGarages().get(0).getName() + ": " + univParking.getGarages().get(0).getFloors().get(0).calcRemainingSpaces());
		System.out.println("\nTesting Emptying Spaces:");
		
		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(0).emptySpace();
		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(1).emptySpace();
		
		System.out.println("\tNumber of Spaces remaining on floor " + univParking.getGarages().get(0).getFloors().get(0).getFloorNumber() + 
				" of " + univParking.getGarages().get(0).getName() + ": " + univParking.getGarages().get(0).getFloors().get(0).calcRemainingSpaces());
	}

}
