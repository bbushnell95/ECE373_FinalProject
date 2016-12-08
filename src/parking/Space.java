package parking;
import java.io.Serializable;
import java.util.Calendar;

public class Space implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean isFull;
	private Calendar endTime;
	private String userName = null;
	private String location = null;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Space(){
		isFull = false;
		location = "unknown";
	}
	
	public Space(String l){
		isFull = false;
		location = l;
	}
	
	public boolean checkIfFull(){
		return isFull;
	}
	
	public boolean isOccupiedBy(String name) {
		return userName.equals(name);
	}

	public String getName() {
		return userName;
	}
	
	public void fillSpace(Calendar time, String name){
		endTime = time;
		isFull = true;
		userName = name;
	}
	
	public void emptySpace(){
		isFull = false;
		userName = "";
	}

	public void checkExpiration() {
		if (Calendar.getInstance().compareTo(endTime) <=0 ){
			this.emptySpace();
			this.endTime = null;
		}
		
	}


}
