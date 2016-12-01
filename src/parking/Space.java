package parking;
import java.io.Serializable;
import java.util.Calendar;

public class Space implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean isFull;
	private Calendar endTime;
	
	public Space(){
		isFull = false;
	}
	
	public boolean checkIfFull(){
		return isFull;
	}
	
	public void fillSpace(Calendar time){
		endTime = time;
		isFull = true;
	}
	
	public void emptySpace(){
		isFull = false;
	}

	public void checkExpiration() {
		if (Calendar.getInstance().compareTo(endTime) <=0 ){
			this.emptySpace();
			this.endTime = null;
		}
		
	}

}
