

public class Heap<E>{


  private E[] elements;            // Array that holds heap elements
  private int lastIndex;          // index of last element in heap
  private int maxIndex;           // index of last position in array

  // Constructor
  public Heap(int maxSize)
  {
    elements = (E[]) new Object[maxSize];
    lastIndex = -1;
    maxIndex = maxSize - 1;
  }

  public boolean isEmpty()
  // Determines whether this heap is empty.
  {
    return (lastIndex == -1);
  }

  public boolean isFull()
  // Determines whether this heap is full.
  {
    return (lastIndex == maxIndex);
  }

  

  public void add(E item) throws PriQOverflowException
  // Adds item to this heap.
  // Throws PriQOverflowException if heap already full
  {
  	
  	
        //COMPLETE THIS METHOD
    
    
  }

 
  public E remove () throws PriQUnderflowException
  // Removes the root element from this heap
  // Throws PriQUnderflowException if heap is empty.
  {
    
     // COMPLETE THIS METHOD
    
                   
    return null;  
  }

  public String toString()
  // returns a string of all the heap elements
  {
    String theHeap = new String("the heap is:\n");
    for (int index = 0; index <= lastIndex; index++)
      theHeap = theHeap + index + ". " + elements[index] + "\n";
    return theHeap;
  }
}
