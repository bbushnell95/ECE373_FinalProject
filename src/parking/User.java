package parking;

public class User {

	private String name;
	private int userType;
	
	public User(String newName, int newType) {
		name = newName;
		userType = newType;
	}
	
	public int getUserType() {
		return userType;
	}
	
	public String getName() {
		return name;
	}

}
