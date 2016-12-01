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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Swing Imports
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//Project Imports
import parking.Floor;
import parking.Garage;
import parking.Lot;
import parking.Parking;
import parking.Space;

public class ParkingGUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	//Swing Fields
	private JFrame popUpFrame;
	private JFrame errorFrame;
	private JTextField lengthBox;
	private JButton nextButton;
	private JButton endButton;
	private JComboBox<String> hrTimeBox;
	private JComboBox<String> minTimeBox;
	private JComboBox<String> lengthComboBox;
	private JComboBox<String> apTimeBox;
	
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
		//use the univ passed throught the drive if no saved file to load
		university = univ1;
		university = UniversityParking.loadData(univ1);
		university.checkExpiration();
		createTimePopUp("Welcome to University Parking!");
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
	
/*------------------------------------------POP UP WINDOWS---------------------------------------*/	
	void createTimePopUp(String title){
		//set frame properties
		popUpFrame = new JFrame(title);
		popUpFrame.setSize(500, 300);
		popUpFrame.setLayout(new GridLayout(0,1));
		popUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		popUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		//Create JLabels
		JLabel text0 = new JLabel("You're spot has been reserved!" , SwingConstants.CENTER);
		JLabel text1 = new JLabel("Review the information presented below" , SwingConstants.CENTER);
		JLabel text2 = new JLabel("<html><br/>Garage: "+userParking.getName()+"</html>");
		JLabel text4 = new JLabel("Spot: "+userSpotNum);
		JLabel text5 = new JLabel("Start Time: "+startTime.getTime());
		JLabel text6 = new JLabel("End Time: "+endTime.getTime());
		text0.setFont(new Font("Serif", Font.BOLD, 18));
		text1.setFont(new Font("Serif", Font.BOLD, 18));
		text2.setFont(new Font("Serif", Font.BOLD, 14));
		text4.setFont(new Font("Serif", Font.BOLD, 14));
		text5.setFont(new Font("Serif", Font.BOLD, 14));
		text6.setFont(new Font("Serif", Font.BOLD, 14));
	    
		//Create End Button
		endButton = new JButton("End");
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
		userSpot.fillSpace(endTime);
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
	}
}
	
private class NextButtonListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
	{
		//get the user info
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
		startTime = Calendar.getInstance();
		startTime.set(now.YEAR,now.MONTH,now.DAY_OF_MONTH,hrTime, minTime);
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
		if (!error)
		{
			popUpFrame.setVisible(false);
			popUpFrame.dispose();
			createGaragePopUp("Pick A Garage");	
		}
	}
}
}