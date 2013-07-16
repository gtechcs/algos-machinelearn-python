package cis256.proj2;

/*
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * The SortedListException to be used with methods of SortedList
 * 
 */
public class SortedListException extends Exception{

	/*
	 * Create SortedListException with the specified detailed message
	 * @param - message
	 * 	The detail message, (which can be later retrieved with getMessage()) 
	 * @postcondition 
	 * 	A SortedListException with no message is created
	 */
	public SortedListException(String message) {
		super(message);
		
	}

	/*
	 * Create SortedListException with null as its message
	 * @param - none
	 * @postcondition 
	 * 	A SortedListException with no message is created
	 */
	public SortedListException() {
		
	}

}
