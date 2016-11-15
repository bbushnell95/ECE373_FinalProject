package parking;
import java.util.ArrayList;

public class Lot extends Parking{
	
	private ArrayList<Space> spaces;
	
	public Lot(){
		name = "Unknown";
		location = "Unknown";
	}
	
	public Lot(String n, String l){
		name = n;
		location = l;
	}
	
	public int calcRemainingCost(){
		
		int countOfSpaces = 0;
		
		for(Space currSpace : spaces){
			if(currSpace.checkIfFull() == true){
				countOfSpaces++;
			}
		}
		
		return countOfSpaces;
	}

	@Override
	public int calcRemainingSpaces() {
		// TODO Auto-generated method stub
		return 0;
	}
}