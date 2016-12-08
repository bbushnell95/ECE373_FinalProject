package software;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Driver2 {
	
	public static void main(String args[]){
		UniversityParking univ1 = new UniversityParking();
		
		univ1 = UniversityParking.loadData(univ1);
		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		System.out.println(dateFormat.format(cal.getTime()));
		
		new ParkingGUI("test", univ1);
	}

}
