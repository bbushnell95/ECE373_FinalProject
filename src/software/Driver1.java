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
		
		//spaces havent been added to any of the garages below (DONE: Brett, 12/7)
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
		
		//Park Avenue Garage
		Floor pgFloor1 = new Floor(1);
		Floor pgFloor2 = new Floor (2);
		Floor pgFloor3 = new Floor(3);
		Floor pgFloor4 = new Floor(4);
		
		//Highland Garage
		Floor hgFloor1 = new Floor(1);
		Floor hgFloor2 = new Floor(2);
		Floor hgFloor3 = new Floor(3);
		Floor hgFloor4 = new Floor(4);
		
		//Tyndall Garage
		Floor tgFloor1 = new Floor(1);
		Floor tgFloor2 = new Floor(2);
		Floor tgFloor3 = new Floor(3);
		Floor tgFloor4 = new Floor(4);
		
		//Sixth Street Garage
		Floor s6gFloor1 = new Floor(1);
		Floor s6gFloor2 = new Floor(2);
		Floor s6gFloor3 = new Floor(3);
		Floor s6gFloor4 = new Floor(4);
		
		
		/*Create Spaces to add to floors*/
		//Cherry Garage
		Space cgFloor1Space1 = new Space("Cherry Garage, Floor 1, Space 1");
		Space cgFloor1Space2 = new Space("Cherry Garage, Floor 1, Space 2");
		Space cgFloor1Space3 = new Space("Cherry Garage, Floor 1, Space 3");
		Space cgFloor1Space4 = new Space("Cherry Garage, Floor 1, Space 4");
		
		Space cgFloor2Space1 = new Space("Cherry Garage, Floor 2, Space 1");
		Space cgFloor2Space2 = new Space("Cherry Garage, Floor 2, Space 2");
		Space cgFloor2Space3 = new Space("Cherry Garage, Floor 2, Space 3");
		Space cgFloor2Space4 = new Space("Cherry Garage, Floor 2, Space 4");
		
		Space cgFloor3Space1 = new Space("Cherry Garage, Floor 3, Space 1");
		Space cgFloor3Space2 = new Space("Cherry Garage, Floor 3, Space 2");
		Space cgFloor3Space3 = new Space("Cherry Garage, Floor 3, Space 3");
		Space cgFloor3Space4 = new Space("Cherry Garage, Floor 3, Space 4");
		
		//Main Gate Garage
		Space mgFloor1Space1 = new Space("Main Gate Garage, Floor 1, Space 1");
		Space mgFloor1Space2 = new Space("Main Gate Garage, Floor 1, Space 2");
		Space mgFloor1Space3 = new Space("Main Gate Garage, Floor 1, Space 3");
		Space mgFloor1Space4 = new Space("Main Gate Garage, Floor 1, Space 4");
		
		Space mgFloor2Space1 = new Space("Main Gate Garage, Floor 2, Space 1");
		Space mgFloor2Space2 = new Space("Main Gate Garage, Floor 2, Space 2");
		Space mgFloor2Space3 = new Space("Main Gate Garage, Floor 2, Space 3");
		Space mgFloor2Space4 = new Space("Main Gate Garage, Floor 2, Space 4");
		
		Space mgFloor3Space1 = new Space("Main Gate Garage, Floor 3, Space 1");
		Space mgFloor3Space2 = new Space("Main Gate Garage, Floor 3, Space 2");
		Space mgFloor3Space3 = new Space("Main Gate Garage, Floor 3, Space 3");
		Space mgFloor3Space4 = new Space("Main Gate Garage, Floor 3, Space 4");
		
		Space mgFloor4Space1 = new Space("Main Gate Garage, Floor 4, Space 1");
		Space mgFloor4Space2 = new Space("Main Gate Garage, Floor 4, Space 2");
		Space mgFloor4Space3 = new Space("Main Gate Garage, Floor 4, Space 3");
		Space mgFloor4Space4 = new Space("Main Gate Garage, Floor 4, Space 4");
		
		//Park Ave Garage
		Space pgFloor1Space1 = new Space("Park Ave Garage, Floor 1, Space 1");
		Space pgFloor1Space2 = new Space("Park Ave Garage, Floor 1, Space 2");
		Space pgFloor1Space3 = new Space("Park Ave Garage, Floor 1, Space 3");
		Space pgFloor1Space4 = new Space("Park Ave Garage, Floor 1, Space 4");
		
		Space pgFloor2Space1 = new Space("Park Ave Garage, Floor 2, Space 1");
		Space pgFloor2Space2 = new Space("Park Ave Garage, Floor 2, Space 2");
		Space pgFloor2Space3 = new Space("Park Ave Garage, Floor 2, Space 3");
		Space pgFloor2Space4 = new Space("Park Ave Garage, Floor 2, Space 4");
		
		Space pgFloor3Space1 = new Space("Park Ave Garage, Floor 3, Space 1");
		Space pgFloor3Space2 = new Space("Park Ave Garage, Floor 3, Space 2");
		Space pgFloor3Space3 = new Space("Park Ave Garage, Floor 3, Space 3");
		Space pgFloor3Space4 = new Space("Park Ave Garage, Floor 3, Space 4");
		
		Space pgFloor4Space1 = new Space("Park Ave Garage, Floor 4, Space 1");
		Space pgFloor4Space2 = new Space("Park Ave Garage, Floor 4, Space 2");
		Space pgFloor4Space3 = new Space("Park Ave Garage, Floor 4, Space 3");
		Space pgFloor4Space4 = new Space("Park Ave Garage, Floor 4, Space 4");
		
		//HighLand Garage
		Space hgFloor1Space1 = new Space("Highland Garage, Floor 1, Space 1");
		Space hgFloor1Space2 = new Space("Highland Garage, Floor 1, Space 2");
		Space hgFloor1Space3 = new Space("Highland Garage, Floor 1, Space 3");
		Space hgFloor1Space4 = new Space("Highland Garage, Floor 1, Space 4");
		
		Space hgFloor2Space1 = new Space("Highland Garage, Floor 2, Space 1");
		Space hgFloor2Space2 = new Space("Highland Garage, Floor 2, Space 2");
		Space hgFloor2Space3 = new Space("Highland Garage, Floor 2, Space 3");
		Space hgFloor2Space4 = new Space("Highland Garage, Floor 2, Space 4");
		
		Space hgFloor3Space1 = new Space("Highland Garage, Floor 3, Space 1");
		Space hgFloor3Space2 = new Space("Highland Garage, Floor 3, Space 2");
		Space hgFloor3Space3 = new Space("Highland Garage, Floor 3, Space 3");
		Space hgFloor3Space4 = new Space("Highland Garage, Floor 3, Space 4");
		
		Space hgFloor4Space1 = new Space("Highland Garage, Floor 4, Space 1");
		Space hgFloor4Space2 = new Space("Highland Garage, Floor 4, Space 2");
		Space hgFloor4Space3 = new Space("Highland Garage, Floor 4, Space 3");
		Space hgFloor4Space4 = new Space("Highland Garage, Floor 4, Space 4");
		
		//Tyndall
		Space tgFloor1Space1 = new Space("Tyndall Ave Garage, Floor 1, Space 1");
		Space tgFloor1Space2 = new Space("Tyndall Ave Garage, Floor 1, Space 2");
		Space tgFloor1Space3 = new Space("Tyndall Ave Garage, Floor 1, Space 3");
		Space tgFloor1Space4 = new Space("Tyndall Ave Garage, Floor 1, Space 4");
		
		Space tgFloor2Space1 = new Space("Tyndall Ave Garage, Floor 2, Space 1");
		Space tgFloor2Space2 = new Space("Tyndall Ave Garage, Floor 2, Space 2");
		Space tgFloor2Space3 = new Space("Tyndall Ave Garage, Floor 2, Space 3");
		Space tgFloor2Space4 = new Space("Tyndall Ave Garage, Floor 2, Space 4");

		Space tgFloor3Space1 = new Space("Tyndall Ave Garage, Floor 3, Space 1");
		Space tgFloor3Space2 = new Space("Tyndall Ave Garage, Floor 3, Space 2");
		Space tgFloor3Space3 = new Space("Tyndall Ave Garage, Floor 3, Space 3");
		Space tgFloor3Space4 = new Space("Tyndall Ave Garage, Floor 3, Space 4");
		
		Space tgFloor4Space1 = new Space("Tyndall Ave Garage, Floor 4, Space 1");
		Space tgFloor4Space2 = new Space("Tyndall Ave Garage, Floor 4, Space 2");
		Space tgFloor4Space3 = new Space("Tyndall Ave Garage, Floor 4, Space 3");
		Space tgFloor4Space4 = new Space("Tyndall Ave Garage, Floor 4, Space 4");
		
		//Sixth Street Garage
		Space s6gFloor1Space1 = new Space("Sixth Street Garage, Floor 1, Space 1");
		Space s6gFloor1Space2 = new Space("Sixth Street Garage, Floor 1, Space 2");
		Space s6gFloor1Space3 = new Space("Sixth Street Garage, Floor 1, Space 3");
		Space s6gFloor1Space4 = new Space("Sixth Street Garage, Floor 1, Space 4");
		
		Space s6gFloor2Space1 = new Space("Sixth Street Garage, Floor 2, Space 1");
		Space s6gFloor2Space2 = new Space("Sixth Street Garage, Floor 2, Space 2");
		Space s6gFloor2Space3 = new Space("Sixth Street Garage, Floor 2, Space 3");
		Space s6gFloor2Space4 = new Space("Sixth Street Garage, Floor 2, Space 4");
		
		Space s6gFloor3Space1 = new Space("Sixth Street Garage, Floor 3, Space 1");
		Space s6gFloor3Space2 = new Space("Sixth Street Garage, Floor 3, Space 2");
		Space s6gFloor3Space3 = new Space("Sixth Street Garage, Floor 3, Space 3");
		Space s6gFloor3Space4 = new Space("Sixth Street Garage, Floor 3, Space 4");
		
		Space s6gFloor4Space1 = new Space("Sixth Street Garage, Floor 4, Space 1");
		Space s6gFloor4Space2 = new Space("Sixth Street Garage, Floor 4, Space 2");
		Space s6gFloor4Space3 = new Space("Sixth Street Garage, Floor 4, Space 3");
		Space s6gFloor4Space4 = new Space("Sixth Street Garage, Floor 4, Space 4");
		
		//Second Street Garage
		Space sgFloor1Space1 = new Space("Second Street Garage, Floor 1, Space 1");
		Space sgFloor1Space2 = new Space("Second Street Garage, Floor 1, Space 2");
		Space sgFloor1Space3 = new Space("Second Street Garage, Floor 1, Space 3");
		Space sgFloor1Space4 = new Space("Second Street Garage, Floor 1, Space 4");
		
		Space sgFloor2Space1 = new Space("Second Street Garage, Floor 2, Space 1");
		Space sgFloor2Space2 = new Space("Second Street Garage, Floor 2, Space 2");
		Space sgFloor2Space3 = new Space("Second Street Garage, Floor 2, Space 3");
		Space sgFloor2Space4 = new Space("Second Street Garage, Floor 2, Space 4");
		
		//Zone1 lot
		Space z1LotSpace1 = new Space("Zone 1 Lot 2147, Space 1");
		Space z1LotSpace2 = new Space("Zone 1 Lot 2147, Space 2");
		Space z1LotSpace3 = new Space("Zone 1 Lot 2147, Space 3");
		Space z1LotSpace4 = new Space("Zone 1 Lot 2147, Space 4");
		Space z1LotSpace5 = new Space("Zone 1 Lot 2147, Space 5");
		
		//Zone1 lot 1
		Space z1Lot1Space1 = new Space("Zone 1 Lot 2021, Space 1");
		Space z1Lot1Space2 = new Space("Zone 1 Lot 2021, Space 2");
		Space z1Lot1Space3 = new Space("Zone 1 Lot 2021, Space 3");
		Space z1Lot1Space4 = new Space("Zone 1 Lot 2021, Space 4");
		Space z1Lot1Space5 = new Space("Zone 1 Lot 2021, Space 5");
		
		//Zone1 lot 2
		Space z1Lot2Space1 = new Space("Zone 1 Lot 1172, Space 1");
		Space z1Lot2Space2 = new Space("Zone 1 Lot 1172, Space 2");
		Space z1Lot2Space3 = new Space("Zone 1 Lot 1172, Space 3");
		Space z1Lot2Space4 = new Space("Zone 1 Lot 1172, Space 4");
		Space z1Lot2Space5 = new Space("Zone 1 Lot 1172, Space 5");
		
		//Zone1 lot 3
		Space z1Lot3Space1 = new Space("Zone 1 Lot 6091, Space 1");
		Space z1Lot3Space2 = new Space("Zone 1 Lot 6091, Space 2");
		Space z1Lot3Space3 = new Space("Zone 1 Lot 6091, Space 3");
		Space z1Lot3Space4 = new Space("Zone 1 Lot 6091, Space 4");
		Space z1Lot3Space5 = new Space("Zone 1 Lot 6091, Space 5");
		
		//South6 Lot
		Space s6LotSpace1 = new Space("Zone 6 Lot 7167, Space 1");
		Space s6LotSpace2 = new Space("Zone 6 Lot 7167, Space 2");
		Space s6LotSpace3 = new Space("Zone 6 Lot 7167, Space 3");
		Space s6LotSpace4 = new Space("Zone 6 Lot 7167, Space 4");
		Space s6LotSpace5 = new Space("Zone 6 Lot 7167, Space 5");
		
		//South6 lot 2
		Space s6Lot2Space1 = new Space("Zone 6 Lot 8138, Space 1");
		Space s6Lot2Space2 = new Space("Zone 6 Lot 8138, Space 2");
		Space s6Lot2Space3 = new Space("Zone 6 Lot 8138, Space 3");
		Space s6Lot2Space4 = new Space("Zone 6 Lot 8138, Space 4");
		Space s6Lot2Space5 = new Space("Zone 6 Lot 8138, Space 5");	
		
		
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
		
		//Park Ave Garage
		pgFloor1.addSpace(pgFloor1Space1);
		pgFloor1.addSpace(pgFloor1Space2);
		pgFloor1.addSpace(pgFloor1Space3);
		pgFloor1.addSpace(pgFloor1Space4);
		
		pgFloor2.addSpace(pgFloor2Space1);
		pgFloor2.addSpace(pgFloor2Space2);
		pgFloor2.addSpace(pgFloor2Space3);
		pgFloor2.addSpace(pgFloor2Space4);
		
		pgFloor3.addSpace(pgFloor3Space1);
		pgFloor3.addSpace(pgFloor3Space2);
		pgFloor3.addSpace(pgFloor3Space3);
		pgFloor3.addSpace(pgFloor3Space4);
		
		pgFloor4.addSpace(pgFloor4Space1);
		pgFloor4.addSpace(pgFloor4Space2);
		pgFloor4.addSpace(pgFloor4Space3);
		pgFloor4.addSpace(pgFloor4Space4);
		
		//Highland Garage
		hgFloor1.addSpace(hgFloor1Space1);
		hgFloor1.addSpace(hgFloor1Space2);
		hgFloor1.addSpace(hgFloor1Space3);
		hgFloor1.addSpace(hgFloor1Space4);
		
		hgFloor2.addSpace(hgFloor2Space1);
		hgFloor2.addSpace(hgFloor2Space2);
		hgFloor2.addSpace(hgFloor2Space3);
		hgFloor2.addSpace(hgFloor2Space4);
		
		hgFloor3.addSpace(hgFloor3Space1);
		hgFloor3.addSpace(hgFloor3Space2);
		hgFloor3.addSpace(hgFloor3Space3);
		hgFloor3.addSpace(hgFloor3Space4);
		
		hgFloor4.addSpace(hgFloor4Space1);
		hgFloor4.addSpace(hgFloor4Space2);
		hgFloor4.addSpace(hgFloor4Space3);
		hgFloor4.addSpace(hgFloor4Space4);
		
		//Tyndall Garage
		tgFloor1.addSpace(tgFloor1Space1);
		tgFloor1.addSpace(tgFloor1Space2);
		tgFloor1.addSpace(tgFloor1Space3);
		tgFloor1.addSpace(tgFloor1Space4);
		
		tgFloor2.addSpace(tgFloor2Space1);
		tgFloor2.addSpace(tgFloor2Space2);
		tgFloor2.addSpace(tgFloor2Space3);
		tgFloor2.addSpace(tgFloor2Space4);
		
		tgFloor3.addSpace(tgFloor3Space1);
		tgFloor3.addSpace(tgFloor3Space2);
		tgFloor3.addSpace(tgFloor3Space3);
		tgFloor3.addSpace(tgFloor3Space4);
		
		tgFloor4.addSpace(tgFloor4Space1);
		tgFloor4.addSpace(tgFloor4Space2);
		tgFloor4.addSpace(tgFloor4Space3);
		tgFloor4.addSpace(tgFloor4Space4);
		
		//Sixth Street
		s6gFloor1.addSpace(s6gFloor1Space1);
		s6gFloor1.addSpace(s6gFloor1Space2);
		s6gFloor1.addSpace(s6gFloor1Space3);
		s6gFloor1.addSpace(s6gFloor1Space4);
		
		s6gFloor2.addSpace(s6gFloor2Space1);
		s6gFloor2.addSpace(s6gFloor2Space2);
		s6gFloor2.addSpace(s6gFloor2Space3);
		s6gFloor2.addSpace(s6gFloor2Space4);
		
		s6gFloor3.addSpace(s6gFloor3Space1);
		s6gFloor3.addSpace(s6gFloor3Space2);
		s6gFloor3.addSpace(s6gFloor3Space3);
		s6gFloor3.addSpace(s6gFloor3Space4);
		
		s6gFloor4.addSpace(s6gFloor4Space1);
		s6gFloor4.addSpace(s6gFloor4Space2);
		s6gFloor4.addSpace(s6gFloor4Space3);
		s6gFloor4.addSpace(s6gFloor4Space4);
		
		//Zone 1 Lot
		zone1Lot.addSpace(z1LotSpace1);
		zone1Lot.addSpace(z1LotSpace2);
		zone1Lot.addSpace(z1LotSpace3);
		zone1Lot.addSpace(z1LotSpace4);
		zone1Lot.addSpace(z1LotSpace5);
		
		//Zone1 lot1
		zone1Lot1.addSpace(z1Lot1Space1);
		zone1Lot1.addSpace(z1Lot1Space2);
		zone1Lot1.addSpace(z1Lot1Space3);
		zone1Lot1.addSpace(z1Lot1Space4);
		zone1Lot1.addSpace(z1Lot1Space5);
		
		//Zone1 lot2
		zone1Lot2.addSpace(z1Lot2Space1);
		zone1Lot2.addSpace(z1Lot2Space2);
		zone1Lot2.addSpace(z1Lot2Space3);
		zone1Lot2.addSpace(z1Lot2Space4);
		zone1Lot2.addSpace(z1Lot2Space5);
		
		//Zone1 lot3
		zone1Lot3.addSpace(z1Lot3Space1);
		zone1Lot3.addSpace(z1Lot3Space2);
		zone1Lot3.addSpace(z1Lot3Space3);
		zone1Lot3.addSpace(z1Lot3Space4);
		zone1Lot3.addSpace(z1Lot3Space5);
		
		//South of 6 Lot1
		south6Lot1.addSpace(s6LotSpace1);
		south6Lot1.addSpace(s6LotSpace2);
		south6Lot1.addSpace(s6LotSpace3);
		south6Lot1.addSpace(s6LotSpace4);
		south6Lot1.addSpace(s6LotSpace5);
		
		//South of 6 Lot2
		south6Lot2.addSpace(s6Lot2Space1);
		south6Lot2.addSpace(s6Lot2Space2);
		south6Lot2.addSpace(s6Lot2Space3);
		south6Lot2.addSpace(s6Lot2Space4);
		south6Lot2.addSpace(s6Lot2Space5);
		
		
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
		
		//Park Ave Garage
		parkAveGarage.addFloor(pgFloor1);
		parkAveGarage.addFloor(pgFloor2);
		parkAveGarage.addFloor(pgFloor3);
		parkAveGarage.addFloor(pgFloor4);
		
		//Highland garage
		highlandGarage.addFloor(hgFloor1);
		highlandGarage.addFloor(hgFloor2);
		highlandGarage.addFloor(hgFloor3);
		highlandGarage.addFloor(hgFloor4);
		
		//tyndall garage
		tyndallAveGarage.addFloor(tgFloor1);
		tyndallAveGarage.addFloor(tgFloor2);
		tyndallAveGarage.addFloor(tgFloor3);
		tyndallAveGarage.addFloor(tgFloor4);
		
		//Sixth Street Garage
		sixthStreetGarage.addFloor(s6gFloor1);
		sixthStreetGarage.addFloor(s6gFloor2);
		sixthStreetGarage.addFloor(s6gFloor3);
		sixthStreetGarage.addFloor(s6gFloor4);
		
		
		/*Add Garages and lots to univParking*/
		univParking.addGarage(cherryGarage);
		univParking.addGarage(mainGateGarage);
		univParking.addGarage(secondStreetGarage);
		univParking.addGarage(parkAveGarage);
		univParking.addGarage(highlandGarage);
		univParking.addGarage(tyndallAveGarage);
		univParking.addGarage(sixthStreetGarage);
		univParking.addLot(zone1Lot);
		univParking.addLot(zone1Lot1);
		univParking.addLot(zone1Lot2);
		univParking.addLot(zone1Lot3);
		univParking.addLot(south6Lot1);
		univParking.addLot(south6Lot2);
		
		
		
		 new ParkingGUI("test", univParking); 
		
		/*Checking garage info*/
//		for(Garage currGarage: univParking.getGarages()){
//			System.out.println("Info for " + currGarage.getName());
//			System.out.println("\tLocation:" + currGarage.getLocation());
//			System.out.println("\tNumber of Floors: " + currGarage.getFloors().size());
//		
//			/*Checking number of spaces on each floor of cherry Garage*/
//			for(Floor currFloor: currGarage.getFloors()){
//				System.out.println("\t\tNumber of spaces on Floor " + currFloor.getFloorNumber() + ": " + currFloor.getSpaces().size());
//			}
//		}
//		/*Checking lot info*/
//		for(Lot currLot: univParking.getLots()){
//			System.out.println("Info for " + currLot.getName());
//			System.out.println("\tLocation:" + currLot.getLocation());
//			System.out.println("\tNumber of Spaces: " + currLot.getSpaces().size());
//		}
//		
//		/*System.out.println("\nTesting filling spaces: ");
//		
//		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(0).fillSpace();
//		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(1).fillSpace();
//		*/
//		System.out.println("\tNumber of Spaces remaining on floor " + univParking.getGarages().get(0).getFloors().get(0).getFloorNumber() + 
//				" of " + univParking.getGarages().get(0).getName() + ": " + univParking.getGarages().get(0).getFloors().get(0).calcRemainingSpaces());
//		System.out.println("\nTesting Emptying Spaces:");
//		
//		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(0).emptySpace();
//		univParking.getGarages().get(0).getFloors().get(0).getSpaces().get(1).emptySpace();
//		
//		System.out.println("\tNumber of Spaces remaining on floor " + univParking.getGarages().get(0).getFloors().get(0).getFloorNumber() + 
//				" of " + univParking.getGarages().get(0).getName() + ": " + univParking.getGarages().get(0).getFloors().get(0).calcRemainingSpaces());
	}

}
