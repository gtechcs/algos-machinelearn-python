package cis256.proj3;

/*
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * 
 * A StringEditor object represents a string (collection of characters) , 
 * with a ‘cursor position’.  The StringEditor class is implemented using 
 * two linked lists member variables.  One linked list, let’s call it ‘leftChars’,  
 * contains all the characters which are to the left of the ‘cursor’.  
 * The other linked list, call it ‘rightChars’ contains all the characters to 
 * the right of the ‘cursor’.    
 * It is not necessary to store the ‘cursor’ in this class.  
 * The cursor position always follows characters on the left, and preceded characters on the right.
 * 
 */
public class StringEditor {

	private CharNode leftChars;
	private CharNode rightChars;
	
	/*
	 * 	Constructor
	 *  	StringEditor object is created
	 *	@postcondition
	 *		no characters are in the string (ie both lists are empty)
	 */
    public StringEditor(){
    	//Nothing to do, let leftChars and rightChars be null 
    }
    
	/*
	 * 	Constructor
	 *  	StringEditor object is created
	 *  @precondition
	 *  	none
	 *	@postcondition
	 *		characters from the parameter left are to the left of the ‘cursor’, 
	 *	characters from the parameter right are to the right of the ‘cursor’
	 */
    public StringEditor(String left, String right){
    	char[] charArray;
    	if(left != null && left.length() > 0){
	    	charArray = left.toCharArray();
	    	for(int i=0; i< charArray.length; i++){
	    		if(leftChars == null){
	    			leftChars = new CharNode(charArray[i],null);
	    		}else{
	    			CharNode.listTailInsert(leftChars, charArray[i]);
	    		}
	    	}
    	}
    	
    	if(right != null && right.length() > 0){
	    	charArray = right.toCharArray();
	    	for(int i=0; i< charArray.length; i++){
	    		if(rightChars == null){
	    			rightChars = new CharNode(charArray[i],null);
	    		}else{
	    			CharNode.listTailInsert(rightChars, charArray[i]);
	    		}
	    	}
    	}
    
    }
    
    
    /**
     * Determines if the ‘cursor’ is at the start of the string
     * @precondition
     * 	None
     * @postcondition
     * 	object is unchanged
     * @return 
     * 	boolean true if the cursor is at the front of the string, false otherwise
     * 
     */
    public boolean isCursoratfront(){
    	return (CharNode.listLength(leftChars) == 0);
    }
    
    /**
     * Determines if the ‘cursor’ is at the end of the string
     * @precondition
     * 	None
     * @postcondition
     * 	object is unchanged
     * @return 
     * 	boolean true if the cursor is at the end of the string, false otherwise
     * 
     */
    public boolean isCursoratend(){
    	return (CharNode.listLength(rightChars) == 0);
    }
    
    /**
     * Insert new character at prior to cursor         
     * @precondition
     * 	None
     * @postcondition
     * 	cursor should follow new character
     * @param c
     * 	The character to be inserted
     */
    public void insertChar(char c){
    	leftChars = CharNode.listTailInsert(leftChars, c);
    }
    
    /**
     * Removes the character directly following the cursor
     * @precondition
     * 	None	
     * @postcondition
     * 	if there was a character directly following the cursor, it has been removed
     *  from the string  
     */
    public void deleteChar(){
    	if(rightChars != null)
    		rightChars = rightChars.getLink();
    }
    
    /**
     * Removes character directly prior to cursor
     * @precondition
     * 	None
     * @postcondition
     * if there was a character directly prior to the cursor, it has been removed
     * from the string
     */
    public void backspace(){
    	if(leftChars != null)
    		leftChars = CharNode.listTailRemove(leftChars);
    }
    
    /**
     * Cursor is moved to the beginning of the string
     * @precondition
     * 	None
     * @postcondition
     * 	if cursor was not already there, it is now at the front of the string
     */
    public void frontOfString(){
    	if(isCursoratfront()){
    		return;
    	}
    	
    	CharNode lastOfLeft = CharNode.getLast(leftChars);
    	lastOfLeft.setLink(rightChars);
    	rightChars = leftChars;
    	leftChars = null;
    }
    
    /*
     * Cursor is moved to the end of the string
     * @precondition
     * 	None
     * @postcondition
     * 	if cursor was not already there, it is now at the end of the string
     */
    public void endOfString(){
    	if(isCursoratend()){
    		return;
    	}
    	
    	CharNode lastOfLeft = CharNode.getLast(leftChars);
    	if(lastOfLeft != null){
    		lastOfLeft.setLink(rightChars);
    	}else{
    		leftChars = rightChars;
    	}
    	rightChars = null;
    }
    
    /**
     * Moves the cursor one position to the left
     * @precondition
     * 	None
     * @postcondition
     * 	If the cursor was not at the beginning of the string, it has been 
     * 	moved one character to the left
     */
    public void moveCursorLeft(){
    	if(leftChars == null){
    		return;
    	}
    	
    	CharNode lastOfLeft = CharNode.getLast(leftChars);
    	leftChars = CharNode.listTailRemove(leftChars);
    	
    	lastOfLeft.setLink(rightChars);
    	rightChars = lastOfLeft;
    }
    
    /**
     * Moves the cursor one position to the right
     * @precondition
     * 	None
     * @postcondition
     * 	If the cursor was not at the end of the string, it has been 
     * 	moved one character to the right
     */
    public void moveCursorRight(){
    	if(rightChars == null){
    		return;
    	}
    	
    	char firstRightData = rightChars.getData();
    	leftChars = CharNode.listTailInsert(leftChars, firstRightData);
    	
    	rightChars = rightChars.getLink();
    }
    
    /**
     * Returns the string, in the following format   (^ represents cursor position)
     * For example:  [how now brown^cow]
     * 	Empty string:  [^]
     * @precondition 
     * 	None
     * @postcondition
     * 	StringEditor object is unchanged
     */
    public String toString(){
    	StringBuffer sb = new StringBuffer();
    	
    	sb.append("[");
    	if(leftChars != null)
    		sb.append(leftChars.toString());
    	sb.append("^");
    	if(rightChars != null)
    		sb.append(rightChars.toString());
    	sb.append("]");
    	
    	return sb.toString();
    }
    
}
