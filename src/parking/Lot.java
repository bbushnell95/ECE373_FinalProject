package parking;
import java.util.ArrayList;

public class Lot{
	
	private ArrayList<Space> spaces;
	
	public Lot(){
		
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
}