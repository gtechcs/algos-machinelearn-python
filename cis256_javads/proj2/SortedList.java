package cis256.proj2;

/*
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * @note
 * 	Objects of type SortedList can store a collection of objects in a sorted order.  
 * 	The type of object being stored is String.
 * 
 */
public class SortedList {

	private String[ ] data;
	private int manyItems; 

   /**
   * Initialize an empty list with an initial capacity of 5. 
   * @param - none
   * @postcondition
   *   This sorted list is empty and has an initial capacity of 5.
   *   this list is ready for objects to be inserted
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new String[5].
   **/   
	public SortedList(){
		final int INITIAL_CAPACITY = 5;
		manyItems = 0;
		data = new String[INITIAL_CAPACITY];
	}

   /**
   * Initialize an empty sorted list with a specified capacity.
   * @param max
   *   the capacity of sorted list
   * @precondition
   *   max is non-negative.
   * @postcondition
   *   This sorted list is empty and has the given capacity.
   *   this list is ready for objects to be inserted
   * @exception IllegalArgumentException
   *   Indicates that initialCapacity is negative.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new String[max].
   **/
	public SortedList(int max){

		if (max < 0)
			throw new IllegalArgumentException
				("The initialCapacity is negative: " + max);
		if (max > Integer.MAX_VALUE)
			throw new IllegalArgumentException
				("The initialCapacity is more than: " + Integer.MAX_VALUE);
		data = new String[max];
		manyItems = 0;
	}
	
   /**
   * Determine the number of items currently stored in this list
   * @param - none
   * @postcondition
   * 	the object is not changed
   * @return
   *   the number of items in this sorted list
   **/ 
	public int size(){
		return manyItems;
	}

   /**
   * Determine if this list is empty
   * @param - none
   * @postcondition
   * 	the object is not changed
   * @return
   *   boolean to show if list is empty
   **/ 
	public boolean isEmpty(){
		
		return (manyItems <= 0) ;
	}

   /**
   * Add a new String to the list.
   * @param element
   *   the new String that is being inserted
   * @postcondition
   *   the new object has been inserted by order for that type
   * @exception SortedList exception
   *   If the list is full, a SortedListException is thrown
   **/
	public void add(String tobeAddedString) throws SortedListException{
		/*
		 * next block should be used if this was dynamic list.
		 */
//		if (manyItems == data.length)
//		{  // Ensure twice as much space as we need.
//			ensureCapacity((manyItems + 1)*2);
//		}

		if (manyItems == data.length){
			throw new SortedListException("Unable to add. SortedList at maximum size.");
		}
		
		if(manyItems == 0){
			data[0] = tobeAddedString;
			manyItems = 1;
			return;
		}
		
		for(int i = manyItems -1; i >= 0 ;i--){
			
//	    	System.out.println("Checking "+ i+ " data[i].compareTo(obj) is "+ data[i].compareTo(tobeAddedString));
			if(data[i].compareTo(tobeAddedString) > 0){//argument is less-than/equal to the compared string
				data[i+1] = data[i];//keep on moving the items one step to right
//		    	System.out.println("Moved "+ data[i+1]+ " to position "+ (i+1));

		    	if(i == 0){
		    		data[0] = tobeAddedString;
		    		manyItems++;
				}
			}else{
				data[i+1] = tobeAddedString;
				manyItems++;
				break;
			}
		}
		
	}

	/*
	 * @note
	 * 	Makes sure that the List size is increased to minimumCapacity
	 * 	This will be useful if list was dynamically expanding
	 * @param - minimumCapacity
	 * 	
	 */
/*	private void ensureCapacity(int minimumCapacity) {
	      String[ ] biggerArray;
	      
	      if (data.length < minimumCapacity)
	      {
	         biggerArray = new String[minimumCapacity];
	         System.arraycopy(data, 0, biggerArray, 0, manyItems);
	         data = biggerArray;
	      }
		
	}
*/
	
	
	/*
	 * 
	 * @note
	 * 	Removes the list object matching parameter 'obj' from the list
	 * @param - tobeRemovedString
	 * 	The String that neds to be removed
	 * @postcondition 
	 * 	if the object was present in this list it has been removed,  
	 * 	otherwise a SortedList exception is thrown
	 * 
	 */
	public void remove(String tobeRemovedString) throws SortedListException{
		int foundIndex = indexOf(tobeRemovedString);
		System.out.println("Index of "+ tobeRemovedString + " is "+ foundIndex);

		if(foundIndex == -1){
			throw new SortedListException("String "+ tobeRemovedString + " is not present in list, so cannot be removed.");
		}else{
			for(int i = foundIndex; i < manyItems  ;i++){
				data[i] = data[i+1];
			}
			manyItems--;
		}
		
	}
	

	/*
	 * @note
	 * 	finds the location of list object matching parameter 'obj'
	 * @postcondition  
	 * 	returns the index of 'obj', or -1 if it is not present this list is unchanged
	 * 
	 */
	public int indexOf(String obj){
		for(int i = 0; i < manyItems ;i++){
			if(data[i].compareTo(obj) < 0){// argument is a string lexicographically greater than this string
				//Do nothing
			}else if(data[i].compareTo(obj) == 0){
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * @note
	 * 	returns the list object at the specified index
	 * @precondition   
	 * 	index is a valid index for this list
	 * @postcondition   
	 * 	this list is unchanged
	 */
	public String get(int index) throws SortedListException{
		if(index < 0 || index >= manyItems){
			throw new SortedListException();
		}
		return data[index];
	}
	
	/*
	 * @note  
	 * 	empties this list
	 * @postcondition  
	 * 	this list is empty, ready for reuse
	 */
	public void clear(){
		int oldSize = this.data.length;
		data = new String[oldSize];
		manyItems = 0;
	}
	
	/*
	 * @note  
	 * 	determines if list object matching parameter obj is in the list
	 * @postcondition  
	 * 	returns true or false,  this list is unchanged
	 */
	public boolean contains(String obj){
	
		return (indexOf(obj) != -1);
	}
	
	/*
	 * Determines if this list is equal to list parameter 'obj'
	 * @note 
	 * 	parameter type  allows this method to override Object equals method
	 * @param obj
	 * 	the SortedList to be tested for equality
	 * @exception SortedListException
	 * 	If the param object is not a SortedList object
	 * 
	 * 
	 */
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(! (obj instanceof SortedList)){
			return false;
		}
		
		if(((SortedList)obj).size() != this.size()){
			return false;
		}
		
		SortedList comprisonlist = (SortedList)obj;
		for(int i=0;i < this.size();i++){
			try {
				if(!this.get(i).equals(comprisonlist.get(i))){
					return false;
				}
			} catch (SortedListException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Removes all objects OBJ from this list such that
	 *          startElementToRemove <= OBJ <= lastElementToRemove
	 * @param startElementToRemove
	 * 	
	 * @param lastElementToRemove
	 * 	
	 * @postcondition 
	 * 	this list may have been reduced
	 * 
	 */
	public void erase(String startElementToRemove,  String lastElementToRemove) throws SortedListException{
		if(startElementToRemove.compareTo(lastElementToRemove) > 0 ){
			throw new SortedListException("First Object is lexicographically greated than second Object!");
		}
		
//		System.out.println("This = "+this.toString());
//		System.out.println("object1= "+startElementToRemove);
//		System.out.println("object2= "+lastElementToRemove);
		boolean firstIndexfound = false;

		
		int firstIndexToRemove = -1;
		int lastIndexToRemove = -1;

		for(int i = 0; i < manyItems ;i++){
//			System.out.println("i= "+i);
			if(!firstIndexfound){
				if(data[i].compareTo(startElementToRemove) < 0){// startElementToRemove is a string lexicographically greater than this string
					//Do nothing
				}else {
					firstIndexfound = true;
					firstIndexToRemove = i;
				}
			}
			
			if(firstIndexfound){
				if(data[i].compareTo(lastElementToRemove) <= 0){// lastElementToRemove is a string lexicographically greater than this string
					//Do nothing
					lastIndexToRemove = i;
				}
			}
		}

		System.out.println("lastIndexToRemove= "+ lastIndexToRemove + ". firstIndexToRemove = " + firstIndexToRemove);

		if(firstIndexToRemove == -1 || lastIndexToRemove == -1){
			return;
		}
		
		//Special case
		if((lastIndexToRemove - firstIndexToRemove) ==  (manyItems -1)){
			this.clear();
			return;
		}

		int oldSize = this.data.length;
		String[] tempData = new String[oldSize];

		System.arraycopy(data, 0, tempData, 0, firstIndexToRemove);
		System.arraycopy(data, lastIndexToRemove+1, tempData, firstIndexToRemove, (manyItems - 1 - lastIndexToRemove) );

		data = tempData;
		manyItems = manyItems - (lastIndexToRemove - firstIndexToRemove +1);
		
//		System.out.println("Now size = " + manyItems);
	}
	
	/*
	 * Returns String representation of all list contents
	 * @postcondition  
	 * 	this String is unchanged
	 */
    public String toString (){
    	StringBuffer sb = new StringBuffer();
		sb.append("{");
		for(int i = 0; i < manyItems ;i++){
			sb.append("[");
			try {
				sb.append(this.get(i));
			} catch (SortedListException e) {
				e.printStackTrace();
			}
			sb.append("]");
		}
		sb.append("}");
		
    	return sb.toString();
    }
	
}
