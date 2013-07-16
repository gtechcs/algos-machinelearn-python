package cis256.proj1;

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

/*
 * author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 */
public class SeatChartApplication extends JFrame implements ActionListener{

	private JPanel panel;

	
	private JLabel labelResult;
	private JLabel labelResult1;
	private JLabel labelResult111;
	
	private JTextField textField1;
	private SeatChart seatChart1;
	private JTextField textField11;
	private SeatChart seatChart11;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ignored) { 
		}
		
		new SeatChartApplication();		
	}

	
	
	public SeatChartApplication(){
		SeatChart sc = new SeatChart();
		
		JComponent content = (JComponent) getContentPane();
		content.setLayout(new FlowLayout());
		
		JComponent box = new JPanel();
		box.setLayout( new BoxLayout(box, BoxLayout.Y_AXIS));
		content.add(box);
		
		panel = new JPanel();
		box.add(panel);
		
		
		JLabel label1 = new JLabel("First Seat Chart");
		box.add(label1);

		textField1 = new JTextField(50);
        textField1.addActionListener(this);
		box.add(textField1);
			
	   JButton b1 = new JButton("Create Seat Chart");	
	   b1.setActionCommand("create1");
	    b1.addActionListener(this);
	    box.add(b1);
		
	   JButton b2 = new JButton("Reserve Seat");		
	   b2.setActionCommand("reserve1");
	    b2.addActionListener(this);
	    box.add(b2);
		
	   JButton b3 = new JButton("Release Seat");		
	   b3.setActionCommand("release1");
	    b3.addActionListener(this);
	    box.add(b3);

	   JButton b4 = new JButton("How many Seats?");		
	   b4.setActionCommand("howmany1");
	    b4.addActionListener(this);
	    box.add(b4);

	   JButton b5 = new JButton("Clear Reservations");		
	   b5.setActionCommand("clear1");
	    b5.addActionListener(this);
	    box.add(b5);

		labelResult = new JLabel("First Seat Chart actions show here");
		box.add(labelResult);


		JLabel label11 = new JLabel("Second Seat Chart");
		box.add(label11);

		textField11 = new JTextField(50);
        textField11.addActionListener(this);
		box.add(textField11);
			
	   JButton b11 = new JButton("Create Seat Chart");	
	   b11.setActionCommand("create11");
	    b11.addActionListener(this);
	    box.add(b11);
		
	   JButton b21 = new JButton("Reserve Seat");		
	   b21.setActionCommand("reserve11");
	    b21.addActionListener(this);
	    box.add(b21);
		
	   JButton b31 = new JButton("Release Seat");		
	   b31.setActionCommand("release11");
	    b31.addActionListener(this);
	    box.add(b31);

	   JButton b41 = new JButton("How many Seats?");		
	   b41.setActionCommand("howmany11");
	    b41.addActionListener(this);
	    box.add(b41);

	   JButton b51 = new JButton("Clear Reservations");		
	   b51.setActionCommand("clear11");
	    b51.addActionListener(this);
	    box.add(b51);

		labelResult1 = new JLabel("Second Seat Chart actions show here");
		box.add(labelResult1);
		
		
		   JButton bb = new JButton("Compare BOTH Seat Charts");		
		   bb.setActionCommand("compareSeatCharts");
		   bb.addActionListener(this);
		    box.add(bb);
		
			labelResult111 = new JLabel("Comparison between both Seat Charts here!");
			box.add(labelResult111);
		
		
			   JButton bexit = new JButton("Exit");		
			   bexit.setActionCommand("exit");
			   bexit.addActionListener(this);
			    box.add(bexit);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // make it show up on screen
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		
		System.out.println("Action Command: "+ action.getActionCommand());
		System.out.println("TextField text: "+ textField1.getText());
		
		labelResult.setText("");
		labelResult1.setText("");
		
	    if ("create1".equals(action.getActionCommand())) {
	    	seatChart1 = new SeatChart();
	    }
	    if ("reserve1".equals(action.getActionCommand())) {
	    	if(seatChart1 == null){
	    		labelResult.setText("Create Seat Chart first!");
	    	}
	    	if(textField1.getText().equals("")){
	    		labelResult.setText("Put some digit in textArea above");
	    		return;
	    	}
	    	
	    	try{
		    	seatChart1.reserve((new Integer(textField1.getText())).intValue());
		    	labelResult.setText("Researved "+ textField1.getText());
	    	}catch(Exception e){
	    		labelResult.setText("Put some digit in textArea above");
	    		return;
	    	}
	    }
	    if ("release1".equals(action.getActionCommand())) {
	    	try {
				seatChart1.release((new Integer(textField1.getText())).intValue());
			} catch (Exception e) {
		    	labelResult.setText("UNABLE TO Release "+ textField1.getText());
			}
	    	labelResult.setText("Released "+ textField1.getText());
	    }
	    if ("howmany1".equals(action.getActionCommand())) {
	    	labelResult.setText("Seats reseerved: "+ seatChart1.numtaken());
	    }
	    if ("clear1".equals(action.getActionCommand())) {
	    	if(seatChart1 == null){
	    		labelResult.setText("Create Seat Chart first!");
	    	}
	    	SeatChart.clearAll(seatChart1);
	    	labelResult.setText("All Seats cleared.");
	    }

	    

	    if ("create11".equals(action.getActionCommand())) {
	    	seatChart11 = new SeatChart();
	    }
	    if ("reserve11".equals(action.getActionCommand())) {
	    	if(seatChart11 == null){
	    		labelResult1.setText("Create Seat Chart first!");
	    	}
	    	if(textField1.getText().equals("")){
	    		labelResult.setText("Put some digit in textArea above");
	    		return;
	    	}
	    	try{
		    	seatChart11.reserve((new Integer(textField11.getText())).intValue());
		    	labelResult1.setText("Researved "+ textField1.getText());
	    	}catch(Exception e){
	    		labelResult1.setText("Put some digit in textArea above");
	    		return;
	    	}
	    }
	    if ("release1".equals(action.getActionCommand())) {
	    	try {
				seatChart11.release((new Integer(textField11.getText())).intValue());
			} catch (Exception e) {
		    	labelResult1.setText("UNABLE TO Release "+ textField11.getText());
			}
	    	labelResult1.setText("Released "+ textField11.getText());
	    }
	    if ("howmany11".equals(action.getActionCommand())) {
	    	labelResult1.setText("Seats reseerved: "+ seatChart11.numtaken());
	    }
	    if ("clear11".equals(action.getActionCommand())) {
	    	if(seatChart11 == null){
	    		labelResult1.setText("Create Seat Chart first!");
	    	}
	    	SeatChart.clearAll(seatChart11);
	    	labelResult1.setText("All Seats cleared.");
	    }
	    
	    if ("compareSeatCharts".equals(action.getActionCommand())) {
	    	if(seatChart11 == null){
	    		labelResult1.setText("Create Seat Chart first!");
	    	}
	    	if(seatChart1 == null){
	    		labelResult.setText("Create Seat Chart first!");
	    	}
	    	
	    	boolean bothEqual = seatChart1.equals(seatChart11);
	    	labelResult111.setText("Both Seat Charts same? "+ bothEqual);
	    }

	    
	    if ("exit".equals(action.getActionCommand())) {
	    	System.exit(0);
	    }
	    
	}
	
}
