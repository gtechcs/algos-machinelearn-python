package cis256.proj3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * 
 * allows the user to enter an initial string (cursor will follow this string)
 * allows the user to edit the string, by performing any of the following operations
 *	insert a character at the cursor position
 *	move the cursor to the right one position
 * 	move the cursor to the left one position
 * 	move the cursor to the front of the string
 * 	move the cursor to the rear of the string
 * 	delete the character directly following the cursor
 * 	backspace (remove) the character directly preceding the cursor
 * 
 * your application should display the StringEditor object when it has first
 * been created, and following each edit
 */
public class Proj3Application {

	//The StringEditor object manipulated by this application
	StringEditor se = null;
	
	
	public static void main(String [] args){
		Proj3Application proj3App = new Proj3Application();
		proj3App.run();
	      
	}
	
	
	/*
	 * The workhorse method of this application
	 * 
	 */
	private void run(){
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
		System.out.println("Enter a initial String \n");
	    
		String inputChoice = ""; 
		try {
			inputChoice = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
