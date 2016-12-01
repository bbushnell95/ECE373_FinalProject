package parking;
import java.io.Serializable;
import java.util.ArrayList;

public class Lot extends Parking implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Space> spaces;
	private int x;
	private int y;
	
	public Lot(){
		name = "Unknown";
		location = "Unknown";
		spaces = new ArrayList<Space>();
	}
	
	public Lot(String n, String l, int x, int y){
		name = n;
		location = l;
		spaces = new ArrayList<Space>();
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<Space> getSpaces(){
		return spaces;
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
	
	public void addSpace(Space s){
		spaces.add(s);
	}

	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
}