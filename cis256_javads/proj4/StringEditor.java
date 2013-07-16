package cis256.proj4;

import cis256.proj4.StackException;

/**
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class StringEditor {

	private GStack<Character> leftChars;
	private GStack<Character> rightChars;
	
	/**
	 * StringEditor object is created
	 * @postcondition:  
	 * 	no characters are in the string (ie both lists are empty)
	 * 
	 */
    public StringEditor(){
    	leftChars = new GStack<Character>();
    	rightChars = new GStack<Character>();
    }

    /**
     * StringEditor object is created
     * @param left
     * 	Characters which will be left of cursor
     * @param right
     * 	characters which will be to right of cursor
     * @precondition
     * 	None
     * @postcondition
     * 	characters from the parameter left are to the left of the ‘cursor’, characters from
     * the parameter right are to the right of the ‘cursor’
     * 
     */
    public StringEditor(String left, String right){
    	leftChars = new GStack<Character>();
    	rightChars = new GStack<Character>();
    	
		try {
			if(left == null){
				//Skip initialization
			}else{
		    	for(int i=0;i<left.length();i++){
					leftChars.push(left.charAt(i));
		    	}
			}
		} catch (StackException e) {
			System.err.println("Error initialising characters to left of cursor.");
		}
		if(right == null){
			return;
		}
		try {
	    	for(int i = right.length() - 1; i >= 0; i--){
				rightChars.push(right.charAt(i));
	    	}
		} catch (StackException e) {
			System.err.println("Error initialising characters to right of cursor.");
		}
    	
    }

    /**
     * Determines if the ‘cursor’ is at the end of the string
     * @precondition
     * 	None
     * @postcondition
     * 	object is unchanged
     * @return
     * 	true if the cursor is at the front of the string
     */
    public boolean isCursoratfront(){
    	
		return leftChars.isEmpty();
    }

    /**
     * Determines if the ‘cursor’ is at the front of the string
     * @precondition
     * 	None
     * @postcondition
     * 	object is unchanged
     * @return
     * 	true if the cursor is at the end of the string
     */
    public boolean isCursoratend(){
    	
		return rightChars.isEmpty();
    }

    /**
     * Insert new character at prior to cursor
     * @precondition
     * 	None
     * @postcondition
     * 	cursor should follow new character
     */
    public void insertChar(char c){
    	try {
			leftChars.push(c);
		} catch (StackException e) {
			System.err.println("Unable to insert character "+ c);
		}
    }

    /**
     * Removes the character directly following the cursor
     * @precondition
     * 	None
     * @postcondition
     * 	if there was a character directly following the cursor, it has been removed
     * from the string
     */
    public void deleteChar(){
    	try {
			rightChars.pop();
		} catch (StackException e) {
			System.err.println("Unable to delete character");
		}
    }

    /**
     * Removes character directly prior to cursor
     * @precondition
     * 	None
     * @postcondition
     * 	if there was a character directly prior to the cursor, it has been removed
     * from the string
     */
    public void backspace(){
    	try {
			leftChars.pop();
		} catch (StackException e) {
			System.err.println("Unable to remove characters directly prior to cursor.");
		}
    }

    /**
     * Cursor is moved to the beginning of the string
     * @precondition
     * 	None
     * @postcondition
     * 	if cursor was not already there, it is now at the front of the string
     */
    public void frontOfString(){
    	while(!isCursoratfront()){
    		moveCursorLeft();
    	}
    }

    /**
     * Cursor is moved to the end of the string
     * @precondition
     * 	None
     * @postcondition
     * 	if cursor was not already there, it is now at the end of the string
     */
    public void endOfString(){
    	while(!isCursoratend()){
    		moveCursorRight();
    	}
    }

    /**
     * Moves the cursor one position to the left
     * @precondition
     * 	None
     * @postcondition
     * 	If the cursor was not at the beginning of the string, it has been
     * moved one character to the left
     */
    public void moveCursorLeft(){
    	if(leftChars.isEmpty()){
    		return;
    	}
    	try {
			rightChars.push(leftChars.pop());
		} catch (StackException e) {
			System.err.println("Unable to move cursor to left.");
		}
    }

    /**
     * Moves the cursor one position to the right
     * @precondition
     * 	None
     * @postcondition
     * 	If the cursor was not at the end of the string, it has been
     * moved one character to the right
     */
    public void moveCursorRight(){
    	if(rightChars.isEmpty()){
    		return; 
    	}
    	
    	try {
    		char rightCharsPoped = rightChars.pop();
    		
			leftChars.push(rightCharsPoped);
		} catch (StackException e) {
			System.err.println("Unable to move cursor to right.");
		}
    }

    /**
     * Returns the string, in the following format   (^ represents cursor position)
     *          For example:  [how now brown^cow]
     *          	Empty string:  [^]
     * @precondition
     * 	None
     * @postcondition
     * 	StringEditor object is unchanged
     */
    public String toString(){
    	GStack<Character> tempStack = new GStack<Character>();
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("[");
    	sb.append(leftChars.toString());
    	sb.append("^");
    	while(!isCursoratend()){
    		try {
				char popedRightChar = rightChars.pop();
				tempStack.push(popedRightChar);
	    		sb.append(popedRightChar);
			} catch (StackException e) {
				System.err.println("Error creating String representation.");
			}
    	}
    	
    	while(!tempStack.isEmpty()){
    		try {
				char popedRightChar = tempStack.pop();
				rightChars.push(popedRightChar);
			} catch (StackException e) {
				System.err.println("Error creating String representation.");
			}
    	}
    	sb.append("]");
    	
		return sb.toString();
    }
	
	
}
