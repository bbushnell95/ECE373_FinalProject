package parking;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int userType;
	private Space reservedSpace;
	
	public User(String newName, int newType) {
		name = newName;
		userType = newType;
		reservedSpace = new Space();
	}
	
	public int getUserType() {
		return userType;
	}
	
	public String getName() {
		return name;
	}

	public Space getReservedSpace() {
		return reservedSpace;
	}

	public void setReservedSpace(Space reservedSpace) {
		this.reservedSpace = reservedSpace;
	}



}
