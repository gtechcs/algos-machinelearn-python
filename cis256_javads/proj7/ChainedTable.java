package cis256.proj7;

/**
 * An implementation of HashTable
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * 
 * Defines two new Hash functions :
 * First user defined hash function
 * Second user defined hash function
 * 1. Math.abs dilutes the hash function effectiveness.
 * 2. Modulus by length of ChainedHashNode[] also must be affecting effectiveness.
 * 
 * With these shortcomings, First hash function seems to perform little better.
 * Actual effectiveness is 1.2 vs 1.3, with current phone number data
 * 
 */
public class ChainedTable
{
   // Invariant of the ChainedTable class:
   //   1. An element with a given key is stored as part of the linked list at
   //      table[hash(key)].
   private ChainedHashNode[ ] table;
   private int manyItems;
   private int elementsSearched;
   private int elementsComparisons;
   

     
   /**
   * Initialize an empty ChainedTable with a specified table size.
   * @param <CODE>tableSize</CODE>
   *   the table size for this new chained hash table
   * <dt><b>Precondition:</b><dd>
   *   <CODE>tableSize > 0</CODE>
   * <dt><b>Postcondition:</b><dd>
   *   This ChainedTable is empty and has the specified table size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified table size. 
   * @exception IllegalArgumentException
   *   Indicates that tableSize is not positive.
   **/   
   public ChainedTable(int tableSize)
   {
      if (tableSize <= 0)
	   throw new IllegalArgumentException("Table size must be positive.");
      // Allocate the table which is initially all null head references.
      table = new ChainedHashNode[tableSize];
   }
   
   
   /**
   * Determines whether a specified key is in this ChainedTable.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   <CODE>true</CODE? (if this ChainedTable contains an object with the specified 
   *   key); <CODE>false</CODE> otherwise. Note that <CODE>key.equals( )</CODE>
   *   is used to compare the <CODE>key</CODE> to the keys that are in the 
   *   ChainedTable.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public boolean containsKey(Object key)
   {
	   ChainedHashNode cursor = null;

	   int i = hash(key);
	   System.out.println("containsKey index "+ i);
	   cursor = table[i];
	   System.out.println("containsKey cursor "+ cursor);
	   while(cursor != null){
		   if(cursor.key.equals(key)){
			   return true;
		   }
		   cursor = cursor.link;
	   }
	   
      return false;
   }
   
   
   /** Retrieves an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * @return
   *   a reference to the object with the specified <CODE>key</CODE (if this 
   *   ChainedTable contains an such an object);  null otherwise. Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the ChainedTable.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> is null.
   **/
   public Object get(Object key)
   {
      // The following return statement should be replaced by the student's code:
	   ChainedHashNode cursor = null;

	   int searchCount = 1;
	   int i = hash(key);
	   cursor = table[i];
	   while(cursor != null){
		   if(cursor.key == key){
			   elementsComparisons += searchCount;
			   elementsSearched++;
			   
			   return cursor.element;
		   }
		   
		   cursor = cursor.link;
		   searchCount++;
	   }
	   
      return null;
   }
   
   /*
    * Already coded hash function.
    * 
    */
//   private int hash(Object key)
//   // The return value is a valid index of the ChainedTable's table. The index is
//   // calculated as the remainder when the absolute value of the key's
//   // hash code is divided by the size of the ChainedTable's table.
//   {
//      return Math.abs(key.hashCode( )) % table.length;
//   }

   /*
    * First user defined hash function
    * http://www.concentric.net/~ttwang/tech/addrhash.htm
    * Knuth's multiplicative Method(multiply by large prime, 2654435761), 
    * 	cast to int, and then divided by range of Hashtable(71)
    * @note
    *   Results:
    *   Estimated Efficiency 1.0
	*	Actual Efficiency 1.201 	
    */
//   private int hash(Object key)
//   {
//	   int i = (Integer)key;
//	   return Math.abs((int)(i*2654435761l) % table.length);
//   }

   /*
    * Second user defined hash function
    * http://www.concentric.net/~ttwang/tech/inthash.htm
    * 	32 bit mix function
    * Results:
    * 	Estimated Efficiency 1.0
    * 	Actual Efficiency 1.314
    *   
    *   Math.abs, and 
    */
   private int hash(Object keyObj){
	   int key = (Integer) keyObj;
	   key = ~key + (key << 15); // key = (key << 15) - key - 1;
	   key = key ^ (key >>> 12);
	   key = key + (key << 2);
	   key = key ^ (key >>> 4);
	   key = key * 2057; // key = (key + (key << 3)) + (key << 11);
	   key = key ^ (key >>> 16);
	  return Math.abs(key% table.length);
 	}
   
   /**
   * Add a new element to this ChainedTable, using the specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to use for the new element
   * @param <CODE>element</CODE>
   *   the new element that's being added to this ChainedTable
   * <dt><b>Precondition:</b><dd>
   *   Neither <CODE>key</CODE> nor </CODE>element</CODE> is null.
   * <dt><b>Postcondition:</b><dd>
   *   If this ChainedTable already has an object with the specified <CODE>key</CODE>,
   *   then that object is replaced by </CODE>element</CODE>, and the return 
   *   value is a reference to the replaced object. Otherwise, the new 
   *   </CODE>element</CODE> is added with the specified <CODE>key</CODE>
   *   and the return value is null.
   * @exception NullPointerException
   *   Indicates that <CODE>key</CODE> or <CODE>element</CODE> is null.   
   **/
   public Object put(Object key, Object element)
   {
      ChainedHashNode cursor = null;
      Object answer = null;

      // Student code should be placed here to set cursor so that it refers to
      // the node that already contains the specified key. If there is no such
      // node, then the student code should set cursor to null.

      if (cursor == null)
      {  // Add a new node at the front of the list of table[hash(key)].
		 int i = hash(key);
		 cursor = new ChainedHashNode( );
		 cursor.element = element;
		 cursor.key = key;
		 cursor.link = table[i];
		 table[i] = cursor;
		 
		 manyItems++;
      }
      else
      {  // The new element replaces an old node.
         answer = cursor.element;
         cursor.element = element;
      }

      return answer;
   }
      
   
   /**
   * Removes an object for a specified key.
   * @param <CODE>key</CODE>
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *   <CODE>key</CODE> cannot be null.
   * <dt><b>Postcondition:</b><dd>
   *   If an object was found with the specified </CODE>key</CODE>, then that
   *   object has been removed from this ChainedTable and a copy of the removed object
   *   is returned; otherwise, this ChainedTable is unchanged and the null reference
   *   is returned.  Note that 
   *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
   *   to the keys that are in the ChainedTable.
   * @exception NullPointerException
   *   Indicates that </CODE>key</CODE> is null.
   **/
   public Object remove(Object key)
   {
      // The following return statement should be replaced by the student's code:
	   ChainedHashNode cursor = null;
	   ChainedHashNode prev = null;

	   int i = hash(key);
	   cursor = table[i];
	   
	   while(cursor != null){
		   if(cursor.key == key){
			   //Special case, first node is to be removed.
			   if(prev == null){
				   table[i] = cursor.link;
				   manyItems--;
				   return cursor;
			   }
			   
			   prev = cursor.link;
			   manyItems--;
			   return cursor;
		   }
		   prev = cursor;
		   cursor = cursor.link;
	   }
	   
      return null;
   }
        

	/**
	 * Determines the average number of comparisons (estimate) which must be made 
	 * in a successful search of this hashtable (assumes a hash function which distributes well))
	 * <dt><b>Precondition:</b><dd>
	 *   the table is not empty  
	 * <dt><b>Postcondition:</b><dd>
	 * @return
	 *   	the value calculated using formula below
	 *   	1 + @/2 where @ =  (number of elements in the table/The size of the table’s array)
	 *   	Note: this is NOT integer division
	 **/
	public double estimateEfficiency(){
		double efficiency = 1.0 + ( manyItems/table.length);
		return efficiency;
	}
	
	/**
	 * Determines the average number of elements (actual) which were examined 
	 * in a successful search of this hashtable
	 * <dt><b>Precondition:</b><dd>
	 *   the table is not empty  
	 * <dt><b>Postcondition:</b><dd>
	 * @return
	 *   the average number of values examined for all successful 
	 *   searches this hashtable has performed.
	 * @note
	 * This value must be determined by actually calculating the average number 
	 * of comparisons which take place in a search in your hash table.
	 * 
	 **/
    public double actualEfficiency(){
    	
		return (double)elementsComparisons/elementsSearched;
	}
}


class ChainedHashNode
{
   Object element;
   Object key;
   ChainedHashNode link;
}
