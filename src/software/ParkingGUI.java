package software;

//Other Java Imports
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

//Layout Imports
import java.awt.FlowLayout;
import java.awt.GridLayout;

//Event Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Swing Imports
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

//Project Imports
import parking.Floor;
import parking.Garage;
import parking.Lot;
import parking.Parking;
import parking.Space;
import parking.User;

public class ParkingGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Swing Fields
	private JFrame mainFrame;
	private JFrame popUpFrame;
	private JFrame errorFrame;
	private JTextField lengthBox;
	private JButton nextButton;
	private JButton endButton;
	private JComboBox<String> hrTimeBox;
	private JComboBox<String> minTimeBox;
	private JComboBox<String> lengthComboBox;
	private JComboBox<String> apTimeBox;
	
	private JMenuBar menuBar;
	private JMenuItem menuLogin;
	private JMenuItem menuLogout;
	private JMenuItem menuNewUser;
	private JMenuItem menuReserve;
	private JMenuItem menuAddUser;
	private JMenuItem menuDeleteUser;
	private JMenuItem menuExit;
	private JTextArea parkingStatus;
	
	//Other Project Fields
	private UniversityParking university;
	private int lengthTime; 
	private Calendar startTime;
	private Calendar maxTime;
	private Calendar endTime;
	private double x;
	private double y;
	private Parking userParking;
	private ArrayList<Space> userSpaces;
	private Space userSpot;
	private int userSpotNum;
	private int userFloorNum;
	
	public ParkingGUI(String windowTitle, UniversityParking univ1) 
	{
		UniversityParking tempParking = new UniversityParking();
		
		tempParking = UniversityParking.loadData(tempParking);
		//use the univ passed through the drive if no saved file to load
		//TODO:: this requires a saved file..
		if(tempParking.getGarages().size() > 0){
			university = tempParking;
		}
		else{
			university = univ1;
		}
	//	university = UniversityParking.loadData(univ1);
		university.checkExpiration();
		createMain("University Parking");
	}
	
	public void errorMessage(String errorMessage)
	{
			errorFrame = new JFrame();
			errorFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
			errorFrame.setSize(400,100);
			errorFrame.setTitle("ERROR!");
			JLabel error = new JLabel(errorMessage);
			errorFrame.add(error);
			JButton okExitButton = new JButton("OK");
			okExitButton.addActionListener(new AbstractAction("OK") {
				private static final long serialVersionUID = 1L;
				public void actionPerformed(ActionEvent e) {
					errorFrame.setVisible(false);
					errorFrame.dispose();
			}});
			errorFrame.add(okExitButton);
			errorFrame.setVisible(true);
	}
	
/*------------------------------------------  MAIN WINDOW ---------------------------------------*/	

	void createMain(String title){
		mainFrame = new JFrame(title);
		mainFrame.setSize(1000, 1000);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
		mainFrame.setLayout(new FlowLayout());
		//welcome message:
		JLabel welcome1 = new JLabel("<html><font size=\"+2\">Welcome to the University of Arizona's Parking Reservation System!</font size><br><br>"+
									  "<center>Reserve a parking spot in any of the University's affiliated garages</center>"+
									  "<center>Log in or create a new user above with the menu above</center>"+
								  	  "<center>Then you can check your currently reserved spots or reserve a new one</center></html>", SwingConstants.CENTER);
		welcome1.setForeground(Color.BLACK);
		welcome1.setFont(new Font("Serif", Font.BOLD, 14));
		mainFrame.add(welcome1, SwingConstants.CENTER);

		//JLabel photo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("download.jpg")));
		//mainFrame.add(photo);
	
		// Menu
		menuBar = new JMenuBar();

		menuLogin = new JMenuItem("Login");
		menuLogin.setMnemonic(KeyEvent.VK_L);
		menuLogin.getAccessibleContext().setAccessibleDescription("Login to University Parking");
		menuLogin.addActionListener(new loginListener());
		menuBar.add(menuLogin);
		
		menuLogout = new JMenuItem("Logout");
		menuLogout.setMnemonic(KeyEvent.VK_T);
		menuLogout.getAccessibleContext().setAccessibleDescription("Logout of University Parking");
		menuLogout.addActionListener(new logoutListener());
		menuLogout.setVisible(false);
		menuBar.add(menuLogout);
		
		menuNewUser = new JMenuItem("New User");
		menuNewUser.setMnemonic(KeyEvent.VK_N);
		menuNewUser.getAccessibleContext().setAccessibleDescription("Add a new User to University Parking");
		menuNewUser.addActionListener(new newUserListener());
		menuNewUser.setVisible(true);
		menuBar.add(menuNewUser);
		
		
		menuReserve = new JMenuItem("Reserve");
		menuReserve.setMnemonic(KeyEvent.VK_R);
		menuReserve.getAccessibleContext().setAccessibleDescription("Reserve a parking space");
		menuReserve.addActionListener(new reserveListener());
		menuReserve.setVisible(false);
		menuBar.add(menuReserve);
		
		menuAddUser = new JMenuItem("Add User");
		menuAddUser.setMnemonic(KeyEvent.VK_A);
		menuAddUser.getAccessibleContext().setAccessibleDescription("Add User");
		menuAddUser.addActionListener(new addUserListener());
		menuAddUser.setVisible(false);
		menuBar.add(menuAddUser);
		
		menuDeleteUser = new JMenuItem("Delete User");
		menuDeleteUser.setMnemonic(KeyEvent.VK_D);
		menuDeleteUser.getAccessibleContext().setAccessibleDescription("Delete User");
		menuDeleteUser.addActionListener(new deleteUserListener());
		menuDeleteUser.setVisible(false);
		menuBar.add(menuDeleteUser);
		
		menuExit = new JMenuItem("Exit",KeyEvent.VK_X);
		menuExit.getAccessibleContext().setAccessibleDescription("Exit the parking application");
		menuExit.addActionListener(new exitListener());
		menuBar.add(menuExit);
		
		parkingStatus = new JTextArea();
		
		mainFrame.getContentPane().add(parkingStatus);
		mainFrame.setJMenuBar(menuBar);
		mainFrame.setVisible(true);
	}
	
	void updateParkingStatus() {
		
		int i;
		/*Checking garage info*/
		parkingStatus.setText("");
		
		parkingStatus.append("Users\n");
		for (User currUser: university.getUsers()) {
			parkingStatus.append(currUser.getName() + " ");
		}
		parkingStatus.append("\n\nGarages\n");
		for(Garage currGarage: university.getGarages()){
			
			parkingStatus.append(currGarage.getName() + " [" + currGarage.getLocation() + "]\n");
		
			/*Checking number of spaces on each floor of cherry Garage*/
			for(Floor currFloor: currGarage.getFloors()){
				parkingStatus.append("\tFloor " + currFloor.getFloorNumber() + ":");
				i = 0;
				for (Space currSpace: currFloor.getSpaces()) {
					i++;
					parkingStatus.append(" Space " + i + ": ");
					if (currSpace.checkIfFull()) {
						parkingStatus.append(currSpace.getName());
					}
					else {
						parkingStatus.append("free");
					}
				}
				parkingStatus.append("\n");
			}
			parkingStatus.append("\n");
		}
		/*Checking lot info*/
		parkingStatus.append("\nLots\n");
		for(Lot currLot: university.getLots()){
			parkingStatus.append(currLot.getName() + " [" + currLot.getLocation() + "]\n\t");
			i = 0;
			for (Space currSpace: currLot.getSpaces()) {
				i++;
				parkingStatus.append(" Space " + i + ": ");
				if (currSpace.checkIfFull()) {
					parkingStatus.append(currSpace.getName());
				}
				else {
					parkingStatus.append("free");
				}
			}
			parkingStatus.append("\n");
		}
		
	}
	
	void updateUserParkingStatus() {
		
		int i;
		boolean noSpaceFlag = false;
		/*Checking garage info*/
		parkingStatus.setText("");
		
		parkingStatus.append("User: " + university.getCurrentUser() + "\n");
		for(User checkUser: university.getUsers()){
			if(checkUser.getName().equals(university.getCurrentUser()) && !checkUser.getReservedSpace().getLocation().equals("unknown")){
				parkingStatus.append("Reserved Spot: " + checkUser.getReservedSpace().getLocation());
				noSpaceFlag = false;
			}
			else if(checkUser.getReservedSpace().getLocation().equals("unknown")){
				noSpaceFlag = true;
			}
		}
		if(noSpaceFlag){
			parkingStatus.append("\n\nGarages\n");
			for(Garage currGarage: university.getGarages()){

				parkingStatus.append(currGarage.getName() + " [" + currGarage.getLocation() + "]\n");

				/*Checking number of spaces on each floor of cherry Garage*/
				for(Floor currFloor: currGarage.getFloors()){
					parkingStatus.append("\tFloor " + currFloor.getFloorNumber() + ":");
					i = 0;
					for (Space currSpace: currFloor.getSpaces()) {
						i++;
						parkingStatus.append(" Space " + i + ": ");
						if (currSpace.checkIfFull()) {
							if (currSpace.getName().equals(university.getCurrentUser())) {
								parkingStatus.append(currSpace.getName());
							}
							else {
								parkingStatus.append("occupied");

							}
						}
						else {
							parkingStatus.append("free");
						}
					}
					parkingStatus.append("\n");
				}
				parkingStatus.append("\n");
			}
			/*Checking lot info*/
			parkingStatus.append("\nLots\n");
			for(Lot currLot: university.getLots()){
				parkingStatus.append(currLot.getName() + " [" + currLot.getLocation() + "]\n\t");
				i = 0;
				for (Space currSpace: currLot.getSpaces()) {
					i++;
					parkingStatus.append(" Space " + i + ": ");
					if (currSpace.checkIfFull()) {
						parkingStatus.append(currSpace.getName());
					}
					else {
						parkingStatus.append("free");
					}
				}
				parkingStatus.append("\n");
			}
		}
		
	}

/*------------------------------------------POP UP WINDOWS---------------------------------------*/	
	void createTimePopUp(String title){
		//set frame properties
		popUpFrame = new JFrame(title);
		popUpFrame.setSize(500, 300);
		popUpFrame.setLayout(new GridLayout(0,1));
		popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		//create JLabels
		JLabel startTimeText = new JLabel("When would you like to reserve a spot?:", SwingConstants.CENTER);
		startTimeText.setForeground(Color.BLACK);
		startTimeText.setFont(new Font("Serif", Font.BOLD, 18));
		
		JLabel lengthText = new JLabel("How long would you like to reserve the spot?:", SwingConstants.CENTER);
		lengthText.setForeground(Color.BLACK);
		lengthText.setFont(new Font("Serif", Font.BOLD, 18));
		
		
		//create time JComboBoxes
		String[] hrTimes = {"5", "6", "7", "8", "9", "10", "11", "12", "1", "2", "3", "4"};
		String[] minTimes = {"15", "30", "45", "00"};
		String[] ap = {"am", "pm"};
		String[] time = {"hrs", "mins","secs", "days"};
		
		hrTimeBox = new JComboBox<String>(hrTimes);
		minTimeBox = new JComboBox<String>(minTimes);
		apTimeBox = new JComboBox<String>(ap);
		lengthComboBox = new JComboBox<String>(time);
		
		//Create JTextFields
		lengthBox = new JTextField();
		lengthBox.setPreferredSize( new Dimension( 200, 24 ) );
		lengthBox.setFont(new Font("Serif", Font.BOLD, 12));
	 		
		//Create JButtons
		nextButton = new JButton("Next");
		nextButton.addActionListener(new NextButtonListener());
		
		//create JPanel to format and beautify the GUI
		JPanel panel3 = new JPanel();
		panel3.add(lengthBox);
		panel3.add(lengthComboBox);
			
		JPanel panel2 = new JPanel();
		panel2.add(nextButton);

		JPanel panel = new JPanel();
		panel.add(hrTimeBox);
		panel.add(minTimeBox);
		panel.add(apTimeBox);
		
		//Add components to Frame
		popUpFrame.add(startTimeText);
		popUpFrame.add(panel);
		popUpFrame.add(lengthText);
		popUpFrame.add(panel3);
		popUpFrame.add(panel2);
		popUpFrame.setVisible(true);
	}
	
	void createGaragePopUp(String title){
		//Set up Frame properties
		popUpFrame = new JFrame("Pick a Garage");
		popUpFrame.setSize(1000, 1000);
		popUpFrame.setLayout(new FlowLayout());
		popUpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		//Create JLabel
		JLabel startTimeText = new JLabel("<html><br/><br/>Pick a Garage! Clicking anywhere on the map " +
				"will find the nearest, available garage:<br/><br/><html/>", SwingConstants.CENTER);
		startTimeText.setFont(new Font("Serif", Font.BOLD, 18));
				
		//Create Listener and Image using JLabel
		JLabel photo = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("garage.jpg")));
		photo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
		         x = e.getX();
		         y = e.getY();
		         
		         System.out.println(x);
		         System.out.println(y);
		         userParking = university.findClosestGarage(x, y);
		         
		         popUpFrame.setVisible(false);
		         popUpFrame.dispose();
		         
		         if (userParking instanceof Garage){
		        	 createLevelPopUp("Pick A Level");
		         }
		         else{
		        	 userSpaces = ((Lot)userParking).getSpaces();
		        	 createSpotPopUp("Pick A Space");
		         }
		         
			}
		});
		
		//Add components to the JPanel
		JPanel l2 = new JPanel();
		l2.setLayout(new BoxLayout(l2, BoxLayout.PAGE_AXIS));
		l2.add(startTimeText);
		l2.add(photo);
		
		//Add JPanel to the JFrame
		popUpFrame.add(l2, SwingConstants.CENTER);
		popUpFrame.setVisible(true);
	}
	
	void createLevelPopUp(String title){
		//Set the JFrame properties
		popUpFrame = new JFrame("Pick A Level in "+userParking.getName());
		popUpFrame.setSize(700, 400);
		popUpFrame.setLayout(new GridLayout(0,1));

		//Create JLabels
		JLabel startTimeText = new JLabel("Which level in "+userParking.getName()+" would you like? " +
				"Only the open levels are clickable:", SwingConstants.CENTER);
		startTimeText.setFont(new Font("Serif", Font.BOLD, 18));
		popUpFrame.add(startTimeText);
		
		//Create JButton for each floor in the user selected garage;
		for(Floor floor: ((Garage) userParking).getFloors()){
			JButton levelButton = new JButton("Level "+floor.getFloorNumber());
			levelButton.addActionListener(new LevelButtonListener());
			levelButton.setBackground(new Color(59, 89, 182));
			levelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			levelButton.setForeground(Color.WHITE);
			if(floor.calcRemainingSpaces()==0){
				levelButton.setEnabled(false);
			}
		    popUpFrame.add(levelButton);
		}
		
		popUpFrame.setVisible(true);
	}
	
	void createSpotPopUp(String title){
		//Set the JFrame properties
		popUpFrame = new JFrame("Pick a Garage");
		popUpFrame.setSize(500, 500);
		popUpFrame.setLayout(new GridLayout(0,1));

		JPanel popUpPanel = new JPanel();
		popUpPanel.setLayout(new GridLayout(0,2));
		
		//Create JLabels
		JLabel startTimeText = new JLabel("Pick a Spot in "+userParking.getName()+"! Click on the spot you want:", SwingConstants.CENTER);
		startTimeText.setFont(new Font("Serif", Font.BOLD, 18));
		popUpFrame.add(startTimeText);
		
		//Create JButtons for Garage
		int i=0;
		
		for(Space space: userSpaces){
			i++;
			JButton spaceButton = new JButton("Space "+i);
			spaceButton.addActionListener(new SpaceButtonListener());
			spaceButton.setBackground(new Color(59, 89, 182));
			spaceButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			spaceButton.setForeground(Color.WHITE);
			if(space.checkIfFull()){
				spaceButton.setEnabled(false);
			}
		    popUpPanel.add(spaceButton);
		}		
				
		popUpFrame.add(popUpPanel);
		//Add Components to the JFrame
		popUpFrame.setVisible(true);
	}
	
	void createEndPopUp(String title){
		//Set up the JFrame properties
		popUpFrame = new JFrame(title);
		popUpFrame.setSize(500, 400);
		popUpFrame.setLayout(new GridLayout(0,1));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		
		//Create JLabels
		JLabel text0 = new JLabel("You're spot has been reserved!" , SwingConstants.CENTER);
		JLabel text1 = new JLabel("Review the information presented below" , SwingConstants.CENTER);
		JLabel text2 = new JLabel("<html><br/>Garage: "+userParking.getName()+"</html>");
		JLabel text4 = new JLabel("Spot: "+userSpotNum);
		JLabel text5 = new JLabel("Start Time: "+ dateFormat.format(startTime.getTime()));
		JLabel text6 = new JLabel("End Time: "+ dateFormat.format(endTime.getTime()));
		text0.setFont(new Font("Serif", Font.BOLD, 18));
		text1.setFont(new Font("Serif", Font.BOLD, 18));
		text2.setFont(new Font("Serif", Font.BOLD, 14));
		text4.setFont(new Font("Serif", Font.BOLD, 14));
		text5.setFont(new Font("Serif", Font.BOLD, 14));
		text6.setFont(new Font("Serif", Font.BOLD, 14));
	    
		//Create End Button
		endButton = new JButton("Done");
		endButton.addActionListener(new EndButtonListener());
		
		//Add Components to the JFrame
		popUpFrame.add(text0);
		popUpFrame.add(text1);
		popUpFrame.add(text2);
		
		if(userParking instanceof Garage){
			JLabel text3 = new JLabel("Level: "+ userFloorNum);
			popUpFrame.add(text3);
			text3.setFont(new Font("Serif", Font.BOLD, 14));
		}
		popUpFrame.add(text4);
		popUpFrame.add(text5);
		popUpFrame.add(text6);
		popUpFrame.add(endButton);
		popUpFrame.setVisible(true);
	}

/*----------------------------------------------ACTION LISTENERS----------------------------*/

	private class loginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String loginName = JOptionPane.showInputDialog(mainFrame, "Enter user name");
			if (loginName != "") {
				switch (university.login(loginName)) {
				case 0:
					menuLogin.setVisible(false);
					menuLogout.setVisible(true);
					menuReserve.setVisible(true);
					menuNewUser.setVisible(false);
					menuAddUser.setVisible(false);
					menuDeleteUser.setVisible(false);
					updateUserParkingStatus();
					break;
				case 1:
					menuLogin.setVisible(false);
					menuLogout.setVisible(true);
					menuReserve.setVisible(false);
					menuNewUser.setVisible(false);
					menuAddUser.setVisible(true);
					menuDeleteUser.setVisible(true);
					updateParkingStatus();
					break;
				default:
					JOptionPane.showMessageDialog(mainFrame,"Unknown user: " + loginName);
				}
			}
		}
	}

	private class logoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			university.logout();
			menuLogin.setVisible(true);
			menuLogout.setVisible(false);
			menuReserve.setVisible(false);
			menuAddUser.setVisible(false);
			menuDeleteUser.setVisible(false);
			parkingStatus.setText("");
		}
	}

private class reserveListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
	{
		createTimePopUp("Welcome to University Parking!");
	}
}

private class newUserListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{
		String userName = JOptionPane.showInputDialog(mainFrame, "Enter user name to add");
		if(userName != null){
			if(!userName.equals("")){
				if (university.addUser(userName) == -1) {
					JOptionPane.showMessageDialog(mainFrame,"user already exists: " + userName);
				}
				else {
					JOptionPane.showMessageDialog(mainFrame,"user: " + userName + " added");
				}
			}
			else{
				JOptionPane.showMessageDialog(mainFrame, "Cannot leave user name blank, please try again");
			}
		}
	}
}
private class addUserListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		String userName = JOptionPane.showInputDialog(mainFrame, "Enter user name to add");
		if(userName != null){
			if(!userName.equals("")){
				if (university.addUser(userName) == -1) {
					JOptionPane.showMessageDialog(mainFrame,"user already exists: " + userName);
				}
				else {
					JOptionPane.showMessageDialog(mainFrame,"user: " + userName + " added");
				}
			}
			else{
				JOptionPane.showMessageDialog(mainFrame, "Cannot leave user name blank, please try again");
			}
		}
		updateParkingStatus();
	}
}

private class deleteUserListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		String userName = JOptionPane.showInputDialog(mainFrame, "Enter user name to delete");
		if(userName != null){
			if(!userName.equals("")){
				if (university.deleteUser(userName) == 0) {
					JOptionPane.showMessageDialog(mainFrame,"could not find user: " + userName);
				}
				else {
					JOptionPane.showMessageDialog(mainFrame,"user: " + userName + " deleted");
				}
			}
			else{
				JOptionPane.showMessageDialog(mainFrame, "Cannot leave userName blank, please try again.");
			}
		}
		updateParkingStatus();
	}
}

private class exitListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		UniversityParking.saveData(university);
		System.exit(0);
	}
}
		
private class LevelButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
	{
		for(Floor floor: ((Garage) userParking).getFloors())
		{
			int floorNum = Integer.parseInt(((JButton) e.getSource()).getText().substring(6));
			if(floor.getFloorNumber()==floorNum)
			{
					userSpaces = floor.getSpaces();
					userFloorNum = floor.getFloorNumber();
			}
		}
		popUpFrame.setVisible(false);
		popUpFrame.dispose();
		createSpotPopUp("Pick A Spot");
	}
}
	
private class SpaceButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		int spaceNum = Integer.parseInt(((JButton) e.getSource()).getText().substring(6));
		userSpotNum = spaceNum;
		userSpot = userSpaces.get(spaceNum-1);
		
		//User can only have 1 space
		for(Garage checkGarage: university.getGarages()){
			for(Floor checkFloor: checkGarage.getFloors()){
				for(Space checkSpace: checkFloor.getSpaces()){
					if(checkSpace.getName() != null){
						if(checkSpace.getName().compareTo(university.getCurrentUser()) == 0){
							checkSpace.emptySpace();
						}
					}
				}
			}
		}
		
		for(Lot checkLot: university.getLots()){
			for(Space checkSpace: checkLot.getSpaces()){
				if(checkSpace.getName() != null){
					if(checkSpace.getName().compareTo(university.getCurrentUser()) == 0){
						checkSpace.emptySpace();
					}
				}
			}
		}
		
		userSpot.fillSpace(endTime, university.getCurrentUser());
		for(User checkUser: university.getUsers()){
			if(checkUser.getName().compareTo(university.getCurrentUser()) == 0){
				checkUser.setReservedSpace(userSpot);
			}
		}
		
		popUpFrame.setVisible(false);
		popUpFrame.dispose();
		createEndPopUp("Pick A Spot");
	}
}

private class EndButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		UniversityParking.saveData(university);
		popUpFrame.setVisible(false);
		popUpFrame.dispose();
		updateUserParkingStatus();
	}
}
	
private class NextButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
	{
		//get the user info
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		lengthTime = Integer.parseInt(lengthBox.getText());
		String ap = (String) apTimeBox.getSelectedItem();
		int hrTime = Integer.parseInt((String) hrTimeBox.getSelectedItem());
		int minTime = Integer.parseInt((String) minTimeBox.getSelectedItem());
		String lengthString = (String) (lengthComboBox.getSelectedItem());
		if (ap == "pm"){
			if(hrTime!=12){
				hrTime = hrTime+12;
			}
		}
		else if (ap == "am" && hrTime==12){
			hrTime =0;	
		}
		
		
		Calendar now = Calendar.getInstance();
		System.out.println(dateFormat.format(now.getTime()));
		startTime = Calendar.getInstance();
		startTime.set(now.getTime().getYear(),now.getTime().getMonth(),now.getTime().getDate(),hrTime, minTime);
		endTime = (Calendar) startTime.clone();
		maxTime = (Calendar) startTime.clone();
		maxTime.add(Calendar.MONTH, 1);
		switch(lengthString){
			case "hrs": endTime.add(Calendar.HOUR, lengthTime); break;
			case "mins": endTime.add(Calendar.MINUTE, lengthTime); break;
			case "secs": endTime.add(Calendar.SECOND, lengthTime); break;
			case "days": endTime.add(Calendar.DAY_OF_MONTH, lengthTime); break;
		}
				
		//check for error with user input
		boolean error = false;
		if(endTime.compareTo(startTime)<=0){
			error = true;
			errorMessage("The end time must be after the start time! Try Again");
		}
		if(endTime.compareTo(maxTime) >=0 )
		{
			error = true;
			errorMessage("The max time to reserve a spot is a month! Try Again");
		}
		if(now.getTime().getHours() > hrTime ){
			error = true;
			errorMessage("Start time must be after the current time! Try Again");
		}
		
		if(now.getTime().getHours() <= hrTime && now.getTime().getMinutes() > minTime ){
			error = true;
			errorMessage("Start time must be after the current time! Try Again");
		}
		if (!error)
		{
			popUpFrame.setVisible(false);
			popUpFrame.dispose();
			createGaragePopUp("Pick A Garage");	
		}
	}
}
}
