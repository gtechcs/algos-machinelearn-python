package cis256.proj7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * A pizza application to create/find/delete Customer data using a ChainedTable(hashtable)
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class PizzaApplication extends JFrame implements ActionListener{

	private static final int TOTAL_CUSTOMERS = 1000;
	private JPanel panel;
	
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;

	private JLabel label7;
	
	private ChainedTable hashtable;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { 
		}
		
		PizzaApplication pizzaApp = new PizzaApplication();
	}

	public PizzaApplication(){
		hashtable = new ChainedTable(TOTAL_CUSTOMERS);
		
		JComponent content = (JComponent) getContentPane();
		content.setLayout(new FlowLayout());
		
		JComponent box = new JPanel();
		box.setLayout( new BoxLayout(box, BoxLayout.Y_AXIS));
		content.add(box);
		
		panel = new JPanel();
		box.add(panel);
		
		JLabel label0 = new JLabel("Add new Customer");
		box.add(label0);
		
		JLabel label1 = new JLabel("New Customer name");
		box.add(label1);
		
		textField1 = new JTextField(50);
        textField1.addActionListener(this);
		box.add(textField1);

		JLabel label2 = new JLabel("New Customer phone No");
		box.add(label2);

		textField2 = new JTextField(15);
        textField2.addActionListener(this);
		box.add(textField2);
		
		JLabel label3 = new JLabel("New Customer address");
		box.add(label3);

		textField3 = new JTextField(50);
        textField3.addActionListener(this);
		box.add(textField3);
		
		JButton b1 = new JButton("Add");	
		b1.setActionCommand("add");
		b1.addActionListener(this);
		box.add(b1);


		JLabel label4 = new JLabel("Find Customer by phone number");
		box.add(label4);

		textField4 = new JTextField(50);
        textField4.addActionListener(this);
		box.add(textField4);
		
		JButton b2 = new JButton("Find");	
		b2.setActionCommand("find");
		b2.addActionListener(this);
		box.add(b2);

		JLabel label5 = new JLabel("Delete Customer by phone number");
		box.add(label5);

		textField5 = new JTextField(50);
        textField5.addActionListener(this);
		box.add(textField5);
		
		JButton b3 = new JButton("Delete");	
		b3.setActionCommand("delete");
		b3.addActionListener(this);
		box.add(b3);
		
		
		JLabel label6 = new JLabel("Last Status:");
		box.add(label6);

		label7 = new JLabel("---");
		box.add(label7);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // make it show up on screen
	}
	
	/**
	 * Adds a new customer with given name/phoneNo/address
	 */
	private boolean createNewCustomer(){
		String name = textField1.getText();
		String phoneNo = textField2.getText();
		String address = textField3.getText();
		
		if(name.equals("")){
			label7.setText("Enter valid customer name.");	
			return false;
		}else if(phoneNo.length() != 10){
			label7.setText("Enter 10 digit phone no.");	
			return false;
		}else if(!phoneNo.matches("\\d+")){
			label7.setText("Enter Only 10 digit phone no.");	
			return false;
		}else {
			Customer customer = new Customer(name, address, new Integer(phoneNo.substring(4)));	
			hashtable.put(new Integer(phoneNo.substring(4)), customer);
			label7.setText("Customer added successfully.");	
		}
		
		return true;
	}

	/**
	 * Finds a customer with given phoneNo
	 */
	public void findCustomer(){
		String phoneNo = textField4.getText();
		if(phoneNo.equals("")){
			label7.setText("Enter valid phone number.");	
			
		}else if(phoneNo.length() != 10){
			label7.setText("Enter 10 digit phone no.");	
			
		}else if(!phoneNo.matches("\\d+")){
			label7.setText("Enter Only 10 digit phone no.");	
			
		}else{
			Customer customer = (Customer)hashtable.get(new Integer(phoneNo.substring(4)));
			if(customer != null){
				label7.setText("Found "+ customer);	
			}else{
				label7.setText("Not Found "+ phoneNo);	
			}
		}
	}
	
	/**
	 * Deletes a customer with given phoneNo
	 */
	public void deleteCustomer(){
		String phoneNo = textField5.getText();
		if(phoneNo.equals("")){
			label7.setText("Enter valid phone number.");	
			
		}else if(phoneNo.length() != 10){
			label7.setText("Enter 10 digit phone no.");	
			
		}else if(!phoneNo.matches("\\d+")){
			label7.setText("Enter Only 10 digit phone no.");	
			
		}else{
			Customer customer = (Customer)hashtable.remove(new Integer(phoneNo.substring(4)));
			if(customer != null){
				label7.setText("Removed "+ customer);	
			}else{
				label7.setText("Not removed "+ phoneNo);	
			}
		}
		
	}

	/**
	 * Action which listens for all Button click actions/events.
	 * 
	 */
	public void actionPerformed(ActionEvent action) {
		
		System.out.println("Action Command: "+ action.getActionCommand());

	    if ("add".equals(action.getActionCommand())) {
	    	createNewCustomer();
	    }

	    if ("find".equals(action.getActionCommand())) {
	    	findCustomer();
	    }

	    if ("delete".equals(action.getActionCommand())) {
	    	deleteCustomer();
	    }
	    
	    if ("exit".equals(action.getActionCommand())) {
	    	System.exit(0);
	    }
	}
	
}
