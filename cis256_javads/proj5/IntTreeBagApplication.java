package cis256.proj5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class IntTreeBagApplication {

	private IntTreeBag intTreeBag; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntTreeBagApplication proj5App = new IntTreeBagApplication();
		proj5App.run();
	}

	private void run() {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputChoice = ""; 

		
		intTreeBag = new IntTreeBag();
		System.out.println("Initial IntTreeBag created with zero elements \n");
		
		while(true){
			showOptions();
			try{
				inputChoice = br.readLine();
				System.out.println("You input = "+ inputChoice);
			}catch(IOException e){
		         System.exit(1);
			}
			if(inputChoice.equals("a")){
				System.out.println("Input integer to add.");
				try {
					inputChoice = br.readLine();
					intTreeBag.add(Integer.parseInt(inputChoice));
				} catch (Exception e) {
					System.err.println("Unable to add "+ inputChoice);
				}
			}else if(inputChoice.equals("r")){
				System.out.println("Input integer to remove.");
				try {
					inputChoice = br.readLine();
					intTreeBag.remove(Integer.parseInt(inputChoice));
				} catch (Exception e) {
					System.err.println("Unable to remove "+ inputChoice);
				}
			}else if(inputChoice.equals("t")){
				System.out.println("RESULT: Total no of values are "+ intTreeBag.size());
			}else if(inputChoice.equals("ac")){
				System.out.println("Input space seperated integers to be added.");
				try {
					inputChoice = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				StringTokenizer st = new StringTokenizer(inputChoice);
				IntTreeBag intTreeBag2 = new IntTreeBag();
				while(st.hasMoreElements()){
					intTreeBag2.add(Integer.parseInt(st.nextToken()));
				}
				
				intTreeBag.addAll(intTreeBag2);
			}else if(inputChoice.equals("ab")){
				System.out.println("Input space seperated integers to be added.");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					IntTreeBag intTreeBag2 = new IntTreeBag();
					while(st.hasMoreElements()){
						intTreeBag2.add(Integer.parseInt(st.nextToken()));
					}
					
					IntTreeBag intTreeBag3 = IntTreeBag.union(intTreeBag,intTreeBag2);
					System.out.println("RESULT: New IntTreeBag is: ");
					intTreeBag3.print();
				} catch (Exception e) {
					System.err.println("Unable to create/(combine the bag with another) producing a third bag.");
				}
			}else if(inputChoice.equals("o")){
				System.out.println("Output integer whose occurrances needed.");
				try {
					inputChoice = br.readLine();
					System.out.println("RESULT: Occurances of "+ inputChoice + " are "+ intTreeBag.countOccurrences(Integer.parseInt(inputChoice)));
				} catch (Exception e) {
					System.err.println("Unable to output no occurances of "+ inputChoice);
				}
			}else if(inputChoice.equals("p")){
				System.out.println("RESULT: The bag contents are: ");
				intTreeBag.print();
			}else if(inputChoice.equals("i")){
			   	IntTreeBag.Iterator iterator = intTreeBag.iterator();
			   	iterator.start();
			   	while(iterator.isCurrent()){
			   		System.out.println("RESULT: Iterated Value = "+iterator.advance());
			   	}
			}else if(inputChoice.equals("q")){
				System.out.println("RESULT: Closing the application.");
				System.exit(0);
			}else{
				System.err.println("RESULT: Unknown option");
			}
		}
	}

	/*
	 * Prints all the options available to user
	 * 
	 */
	private void showOptions(){
		System.out.println("\nUser Options: ");
		System.out.println("Add an int value. Press a");
		System.out.println("Remove an int value from the bag. Press r");
		System.out.println("Output the total number of values stored in the bag. Press t");
		System.out.println("Add the contents of one bag to another. Press ac");
		System.out.println("Combine the bag with another producing a third bag . Press ab");
		System.out.println("Accept a value from the user, and output the number of occurrances of this value in the bag. Press o");
		System.out.println("Output the bag contents. Press p");
		System.out.println("Output the bag contents, using Iterator. Press i");
		System.out.println("Quit. Press q");
		
	}
	
	
	
}
