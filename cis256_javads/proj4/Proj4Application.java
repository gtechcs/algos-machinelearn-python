package cis256.proj4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cis256.proj4.StringEditor;

/**
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class Proj4Application {

	//The StringEditor object manipulated by this application
	StringEditor se = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Proj4Application proj4App = new Proj4Application();
		proj4App.run();
	}

	private void run() {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputChoice = ""; 

		do{
			System.out.println("Enter a initial String \n");
			try {
				inputChoice = br.readLine();
			} catch (IOException e1) {
				System.out.println("Initial String was not specified!!! \n");
			}
		}
		while(inputChoice == null || inputChoice.trim().equals(""));
			
		se = new StringEditor(inputChoice, null);		
		System.out.println("Current String is  " + se.toString()+ "\n");
		
		//Once a String is created, all operations that can be done on it 
		while(true){
			showOptions();
			try{
				inputChoice = br.readLine();
				System.out.println("You input = "+ inputChoice);
			}catch(IOException e){
		         System.exit(1);
			}
			if(inputChoice.equals("1")){
				se.moveCursorRight();
			}else if(inputChoice.equals("2")){
				se.moveCursorLeft();
			}else if(inputChoice.equals("3")){
				se.frontOfString();
			}else if(inputChoice.equals("4")){
				se.endOfString();
			}else if(inputChoice.equals("5")){
				se.deleteChar();
			}else if(inputChoice.equals("6")){
				se.backspace();
			}else if(inputChoice.length() == 1){
				se.insertChar(inputChoice.charAt(0));
			}else if(inputChoice.length() == 0){
				System.out.println("Closing the application.");
				System.exit(0);
			}
			
			System.out.println("Current String is  " + se.toString());
		}
		
	}

	/*
	 * Prints all the options available to user
	 * 
	 */
	private void showOptions(){
		System.out.println("User Options: ");
		System.out.println("Insert a Character at current position. Press ONE character");
		System.out.println("Move the cursor right one position. Press 1");
		System.out.println("Move the cursor left one position. Press 2");
		System.out.println("Move the cursor to front of String. Press 3");
		System.out.println("Move the cursor to rear of String. Press 4");
		System.out.println("Delete the character at current cursor. Press 5");
		System.out.println("Backspace(Remove) the character at preceding the cursor. Press 6");
		System.out.println("Press Enter, with no characters, to Quit");
		
	}
	
	
}
