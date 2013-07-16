package cis256.proj2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/*
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * 
 * Application to test operations on SortedList
 * 
 */
public class SortedApplication extends JFrame implements ActionListener{

	
	private final static String CREATE_NEW_LIST = "createList";
	private final static String ADD_STRING = "addString";
	private final static String CHECK_STRING = "checkString";
	private final static String PRINT_POSITION = "printPosition";
	private final static String PRINT_AT_INDEX = "printAtIndex";
	private final static String IS_EMPTY = "isEmpty";
	private final static String REMOVE_STRING = "removeString";
	private final static String ERASE_RANGE = "eraseRange";
	private final static String EQUALS_ANOTHER_LIST = "equalsAnotherList";
	private final static String CLEAR_LIST = "clearList";
	private final static String PRINT_LIST = "printList";
	
//	private final static String OPERATION_RESULTS = "OPERATION RESULTS: ";
	
	private JPanel panel;
	private JTextField definedListSize;
	private JLabel listCreationResult;
	private JTextField operationData;
	private JTextField secondListData;
	private JLabel sortedListLabel;	
	
	private SortedList sortedList;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { 
		}
		
		new SortedApplication();		
	}
	
	
	public SortedApplication(){
		SortedList sc = new SortedList();
		
		JComponent content = (JComponent) getContentPane();
		content.setLayout(new FlowLayout());
		
		JComponent box = new JPanel();
		box.setLayout( new BoxLayout(box, BoxLayout.Y_AXIS));
		content.add(box);
		
		panel = new JPanel();
		box.add(panel);
		
		
		JLabel listCreationlabel = new JLabel("CREATE NEW SORTED LIST. \nAdd max list size in textfield below, \nand press Button.");
		box.add(listCreationlabel);
		
		definedListSize = new JTextField(30);
        definedListSize.addActionListener(this);
		box.add(definedListSize);

		JButton b1 = new JButton("CREATE NEW SORTED LIST ");	
		b1.setActionCommand(CREATE_NEW_LIST);
		b1.addActionListener(this);
		box.add(b1);
		
		listCreationResult = new JLabel("SORTED LIST CREATION results here");
		box.add(listCreationResult);
		
		
		JLabel operationslabel = new JLabel("SORTED LIST OPERATIONS :");
		box.add(operationslabel);
		
		operationData = new JTextField(30);
		operationData.addActionListener(this);
		box.add(operationData);

		JButton addButton = new JButton("Add");	
		addButton.setActionCommand(ADD_STRING);
		addButton.addActionListener(this);
		box.add(addButton);
		
		JButton checkButton = new JButton("Check");	
		checkButton.setActionCommand(CHECK_STRING);
		checkButton.addActionListener(this);
		box.add(checkButton);
		
		JButton printPositionButton = new JButton("Print position");	
		printPositionButton.setActionCommand(PRINT_POSITION);
		printPositionButton.addActionListener(this);
		box.add(printPositionButton);
		
		JButton printAtIndexButton = new JButton("Print @ index");	
		printAtIndexButton.setActionCommand(PRINT_AT_INDEX);
		printAtIndexButton.addActionListener(this);
		box.add(printAtIndexButton);
		
		JButton isEmptyButton = new JButton("Is Empty");	
		isEmptyButton.setActionCommand(IS_EMPTY);
		isEmptyButton.addActionListener(this);
		box.add(isEmptyButton);
		
		JButton removeButton = new JButton("Remove");	
		removeButton.setActionCommand(REMOVE_STRING);
		removeButton.addActionListener(this);
		box.add(removeButton);
		
		JButton clearListButton = new JButton("Clear List");	
		clearListButton.setActionCommand(CLEAR_LIST);
		clearListButton.addActionListener(this);
		box.add(clearListButton);

		JButton printListButton = new JButton("Print List");	
		printListButton.setActionCommand(PRINT_LIST);
		printListButton.addActionListener(this);
		box.add(printListButton);

		secondListData = new JTextField(30);
		secondListData.setText("Put space seperated range to erase or space seperated second List elements");
		box.add(secondListData);

		JButton eraseRangeButton = new JButton("Erase Range");	
		eraseRangeButton.setActionCommand(ERASE_RANGE);
		eraseRangeButton.addActionListener(this);
		box.add(eraseRangeButton);
		
		JButton equalsAnotherButton = new JButton("Equals Another list");	
		equalsAnotherButton.setActionCommand(EQUALS_ANOTHER_LIST);
		equalsAnotherButton.addActionListener(this);
		box.add(equalsAnotherButton);

		

		sortedListLabel = new JLabel("Sorted List not created.");
		box.add(sortedListLabel);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // make it show up on screen

	}


	@Override
	public void actionPerformed(ActionEvent action) {
		
		operationMessage = "";
		
	    if (CREATE_NEW_LIST.equals(action.getActionCommand())) {
	    	
	    	sortedList = new SortedList();
	    	String listSize = definedListSize.getText();
	    	int askedForSize; 
	    	try{
	    		askedForSize = new Integer(listSize).intValue();
		    	sortedList = new SortedList(askedForSize);
		    	listCreationResult.setText("Created List with "+ askedForSize + " size.");
	    	}catch(Exception e){
		    	sortedList = new SortedList();
		    	listCreationResult.setText("Created List with Default(5) size.");
	    	}
	    }

	    String opData = operationData.getText();

	    if (ADD_STRING.equals(action.getActionCommand())) {
	    	verifyListPresent();
	    	if(!isDataPresent(opData)){
	    		return;
	    	}
	    	System.out.println("Adding "+ opData);
	    	try {
				sortedList.add(opData);
			} catch (SortedListException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    		operationMessage = e.getMessage();

			}
	    }
	    
	    if (CHECK_STRING.equals(action.getActionCommand())) {
	    	verifyListPresent();
	    	if(!isDataPresent(opData)){
	    		return;
	    	}
	    	System.out.println("Checking "+ opData);
	    	boolean isThere = sortedList.contains(opData);
	    	if(isThere){
	    		operationMessage = "The text "+ opData +" IS present";
	    	}else{
	    		operationMessage = "The text "+ opData +" IS NOT present";
	    	}
	    		
	    }

	    if (PRINT_POSITION.equals(action.getActionCommand())) {
	    	verifyListPresent();
	    	if(!isDataPresent(opData)){
	    		return;
	    	}
	    	System.out.println("Print position "+ opData);
	    	int index = sortedList.indexOf(opData);
	    	if(index != -1){
	    		operationMessage = "The text "+ opData +" IS present AT "+ index +". ";
	    	}else{
	    		operationMessage = "The text "+ opData +" IS NOT present";
	    	}
	    }
	    
	    if (PRINT_AT_INDEX.equals(action.getActionCommand())) {
	    	verifyListPresent();
	    	if(!isDataPresent(opData)){
	    		return;
	    	}
	    	if(!isDataInteger(opData)){
	    		operationMessage = "The text "+ opData +" must be numeric ";
	    		return;
	    	}
	    	
	    	System.out.println("Print position "+ opData);
			int index = (new Integer(opData)).intValue();
			String value ;
			try {
				value = sortedList.get(index);
	    		operationMessage = "The text at position "+ opData +" IS "+ value;
			} catch (SortedListException e) {
	    		operationMessage = "The text at position "+ opData +" IS NOT PRESENT ";
			}
	    }
	    
	    if (IS_EMPTY.equals(action.getActionCommand())) {
	    	boolean isEmpty = sortedList.isEmpty();
	    	if(isEmpty){
	    		operationMessage = "The list is EMPTY ";
	    	}else{
	    		operationMessage = "The list is NOT EMPTY ";
	    	}
	    }
	    
	    if (REMOVE_STRING.equals(action.getActionCommand())) {
	    	verifyListPresent();
	    	if(!isDataPresent(opData)){
	    		operationMessage = "The to be removed data must be given in textbox ";
	    		return;
	    	}
	    	System.out.println("Adding "+ opData);
	    	try {
				sortedList.remove(opData);
	    		operationMessage = "Removed "+ opData + ". ";
			} catch (SortedListException e) {
	    		operationMessage = "UNABLE to remove "+ opData+ ". ";
			}
	    }
	    
	    if (CLEAR_LIST.equals(action.getActionCommand())) {
	    	sortedList.clear();
	    }
	    
	    if (ERASE_RANGE.equals(action.getActionCommand())) {
	    	String range = secondListData.getText();
	    	StringTokenizer st = new StringTokenizer(range);
	    	//ToDo improve
	    	int totalTokens = st.countTokens();
	    	if(totalTokens != 2){
	    		operationMessage = "Put space seperated two elements representing range to erase.";
		    	sortedListLabel.setText(  operationMessage +"  SortedList now" + sortedList.toString());
	    		return;
	    	}
	    	String start = st.nextToken();
	    	String end = st.nextToken();
	    	try {
				sortedList.erase(start, end);
	    		operationMessage = "Range Removed "+ start + " to " + end;
			} catch (SortedListException e) {
	    		operationMessage = "UNABLE to Range Remove "+ start + " to " + end;
			}
	    }
	    
	    if (EQUALS_ANOTHER_LIST.equals(action.getActionCommand())) {
	    	String range = secondListData.getText();
	    	
	    	if(range.startsWith("Put space seperated")){
	    		operationMessage =  "Put Second List elements, space seperated in textarea.";
	    		sortedListLabel.setText(  operationMessage);
	    		return;
	    	}
	    	StringTokenizer st = new StringTokenizer(range);
	    	SortedList st2 = new SortedList();
	    	while(st.hasMoreElements()){
	    		try {
					st2.add(st.nextToken());
				} catch (SortedListException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		    		operationMessage =  "Unable to compare. The max size of second list is "+ st2.size();
		    		return;
				}
	    	}
	    	boolean isEqual = sortedList.equals(st2);
	    	if(isEqual){
	    		operationMessage =  "Both Lists are EQUAL  ";
	    	}else{
	    		operationMessage =  "Both Lists are NOT EQUAL. Second List ="+ st2.toString()+ ". ";
	    	}
	    	
	    	
	    }
	    
	    if (PRINT_LIST.equals(action.getActionCommand())) {
	    	
	    }

	    if(sortedList != null){
	    	sortedListLabel.setText(  operationMessage +"  SortedList now" + sortedList.toString());
	    }
	}
	
	private boolean isDataInteger(String opData) {
		try{
			int index = (new Integer(opData)).intValue();
		}catch(Exception e){
			return false;
		}
		return true;
	}

	private String operationMessage = "";
	
	
	private boolean isDataPresent(String opData) {
		if(opData == null || opData.trim().equals("")){
			sortedListLabel.setText( "Expecting data for this operation!!");
			return false;
		}
		return true;
	}


	private void verifyListPresent(){
		if(sortedList == null){
			sortedList = new SortedList();
	    	listCreationResult.setText("Created List with default size.");
		}
		
	}
	
}
