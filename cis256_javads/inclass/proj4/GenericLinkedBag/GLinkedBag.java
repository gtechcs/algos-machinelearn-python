package inclass.proj4.GenericLinkedBag;



public  class GLinkedBag<E> {
  
  
  private GNode<E> head;         // reference to the first GNode on the list
  private int numItems;          // Number of elements in the list
  private GNode<E> current;      // internal pointer for iteration

  public GLinkedBag()
  // Creates an empty list object.
  { }

  public boolean isFull()
  // Determines whether this list is full.
  {
    return false;
  }

  public int lengthIs()
  // Determines the number of elements on this list.
  {
    return numItems;
  }

  public boolean contains (E item){
  // Determines if element matching item is on this list.
    GNode location = head;
    boolean found = false;

    while (location != null && !found) 
    {
      if (item.equals(location.getItem()))  // if they match
        found = true;
      else
        location = location.getNext();
    }

   return found;
  }

 
  public void insert (E item){
  // Adds  item to front of this list.
    GNode<E> temp = new GNode<E>(item,head);
    head = temp;
    numItems++;
  }
    

  public void remove (E item)
  // Deletes the element of this list whose key matches item’s key.
  {
  	GNode<E> previous = null;
    GNode<E> location = head;
    

    // Locate GNode to be deleted.
      while ( location != null && !item.equals(location.getItem()) ){
      	 previous = location;
      	 location = location.getNext();
      }
                                                   
      if( location != null && previous == null) {  // found at front,delete first GNode
          head = head.getNext();
          numItems--;
      }
      else if (location != null){  //found it elsewhere, remove from middle
          previous.setNext(location.getNext());
          numItems--;
      }
  
  }
  
   public void reset() {
  	// resets internal pointer to start of list
  	  current = head;
  }
  
  public E getNextItem() {
  	 // returns next Object in list
  	 E data = current.getItem();
  	 if (current.getNext() ==  null)
  	     current = head;
  	 else 
  	     current = current.getNext();
  	 
  	 return data;
  }
 
  

}