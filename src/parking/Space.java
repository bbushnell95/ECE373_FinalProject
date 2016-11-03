package parking;

public class Space {
	private boolean isFull;
	
	public Space(){
		isFull = false;
	}
	
	public boolean checkIfFull(){
		return isFull;
	}
	
	public void fillSpace(){
		isFull = true;
	}
	
	public void emptySpace(){
		isFull = false;
	}

}
