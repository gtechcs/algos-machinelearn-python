package cis256.proj4;

import java.util.ArrayList;

import cis256.proj4.StackException;

/**
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class GStack<T> implements Cloneable{

	private ArrayList<T> stack;
	
	/**
	 * Creates an empty stack
	 * @note
	 * 	java.util.ArrayList default constructor will create ArrayList of capacity 10. 
	 */
	public GStack(){
		stack = new ArrayList<T>();
	}

	/**
	 * Creates an empty stack
	 * @param
	 * 	initialCapacity The initial capacity of ArrayList
	 */
	public GStack(int initialCapacity){
		stack = new ArrayList<T>(initialCapacity);
	}
	
	/**
	 * Determines whether the stack is empty.
	 * @precondition 
	 * 	None
	 * @postcondition 
	 * @return true if the stack is empty;
	 * 	otherwise returns false.
	 */
	public boolean isEmpty(){
		return (stack.size() == 0);
	}

	/**
	 * Removes all the items from the stack.
	 * @precondition
	 *  None.
	 * @postcondition
	 *  Stack is empty.
	 */
	public void popAll(){
		stack.clear();
	}
	
	/**
	 * Adds an item to the top of a stack.
	 * @precondition
	 *  newItem is the item to be added.
	 * @postcondition
	 *  If insertion is successful, newItem is on the top of the stack.
	 * Exception: Some implementations may throw 
	 * StackException when newItem cannot be placed on
	 * the stack.
	 * @param newItem
	 * @throws 
	 * 	StackException, in fact does not throw this
	 * @exception OutOfMemoryError
	 *   Indicates insufficient memory for increasing the stack's capacity.
	 *   	 
	 */
	 public void push(T newItem) throws StackException{
		 stack.add(newItem);
	 }

	 /**
	  * Removes the top of a stack.
	  * @precondition
	  *  None.
	  * @postcondition
	  *  If the stack is not empty, the item  that was added most recently
	  * 	is removed from the stack and returned.
	  * @exception
	  * 	Throws StackException if the stack is empty 
	  * @return
	  * @throws StackException
	  */
	 public T pop() throws StackException{
		if(stack.size() == 0){
			throw new StackException("The stack is empty.");
		}
		
		return stack.remove(stack.size() -1);
	 }
	 
	/**
	 * Retrieves the top of a stack.
	 * @precondition 
	 *  None.
	 * @postcondition
	 *  If the stack is not empty, the item that was added most recently is returned. 
	 * 	The stack is unchanged.
	 * @return
	 * 	the top element of Stack
	 * @throws StackException if the stack is empty.
	 */
	  public T peek() throws StackException{
			if(stack.size() == 0){
				throw new StackException("The stack is empty");
			}
		  
			return stack.get(stack.size() -1);
	  }

	  /**
	   * Returns a String containing stack contents, from bottom to top
	   * @return
	   * 	String representation of this Stack
	   * @note
	   * typically you would not print a stack, however this method may help with debugging
	   * 
	   */
	  public String toString(){
		  StringBuilder sb = new StringBuilder();
		  for(int i=0;i < stack.size();i++){
			  sb.append(stack.get(i));
			  sb.append("");
		  }
		  
		  return sb.toString();
	  }
	
	
	  /**
	   * Generate a copy of this stack.
	   * @param - none
	   * @return
	   *   The return value is a copy of this stack. Subsequent changes to the
	   *   copy will not affect the original, nor vice versa. Note that the return
	   *   value must be type cast to a <CODE>GStack</CODE> before it can be used.
	   * @exception OutOfMemoryError
	   *   Indicates insufficient memory for creating the clone.
   	   */
	  @SuppressWarnings("unchecked")
	public GStack<T> clone(){
		  GStack<T> copyStack;
		  
		  try
	      {
			  copyStack = (GStack<T>) super.clone( );
	      }
	      catch (CloneNotSupportedException e)
	      { 
	         // This exception should not occur. But if it does, it would probably indicate a
	         // programming error that made super.clone unavailable. The most comon error
	         // The most common error would be forgetting the "Implements Cloneable"
	         // clause at the start of this class.
	         throw new RuntimeException
	         ("This class does not implement Cloneable");
	      }
	      
	      copyStack.stack.addAll(stack);
	      
		  return copyStack;
	  }
}
