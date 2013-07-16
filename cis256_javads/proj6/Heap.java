package cis256.proj6;

/**
 * The Heap
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 * @param <E>
 */
public class Heap<E>{

  private E [] elements;            // Array that holds heap elements
  private int lastIndex;          // index of last element in heap
  private int maxIndex;           // index of last position in array

  // Constructor
  @SuppressWarnings("unchecked")
  /**
   * Creates a heap of size maxSize
   * 
   */
public Heap(int maxSize)
  {
    elements = (E[]) new Object[maxSize];
    lastIndex = -1;
    maxIndex = maxSize - 1;
  }

  /**
   * Determines whether this heap is empty.
   * @return
   * 	returns true if heap is empty, false otherwise
   */
  public boolean isEmpty()
  {
    return (lastIndex == -1);
  }

  /**
   * Determines whether this heap is full.
   * @return
   * 	true if this heap is fill, false otherwise
   */
  public boolean isFull()
  {
    return (lastIndex == maxIndex);
  }

  /**
   * Adds item to this heap.
   * @param item
   * 	The item to be added
   * @throws PriQOverflowException 
   * 	if heap already full, and no more additions can be done
   */
  public void add(E item) throws PriQOverflowException
  {
        //COMPLETE THIS METHOD
	  if(isFull()){
		  throw new PriQOverflowException();
	  }
	  int addElementIndex = ++lastIndex;
	  elements[addElementIndex] = item;
	  while(isGreater(elements[addElementIndex],elements[(addElementIndex-1)/2])){
		  swap(addElementIndex, (addElementIndex-1)/2);
		  addElementIndex = (addElementIndex -1) /2;
	  }
	  
  }

  /**
   * Removes the root element from this heap
   * @return
   * @throws PriQUnderflowException  if heap is empty.
   */
public E remove () throws PriQUnderflowException
  {
     // COMPLETE THIS METHOD
	  if(isEmpty()){
		  throw new PriQUnderflowException();
	  }
    
	  E highestPriorityItem = elements[0];
	  elements[0] = elements[lastIndex];
	  lastIndex -= 1;
	  shiftDown(0);

	  return highestPriorityItem;  
  }

/**
 * Shift down the element 
 * @param index
 * 	Index of element to shift
 */
  private void shiftDown(int index) {
	  int currentIndex = index;
	  int rightIndex = 2*index + 2 ;
	  int leftIndex = 2*index + 1;
	  
	  if(rightIndex <= lastIndex){
		  if(isGreater(elements[leftIndex],elements[currentIndex])){
			  swap(currentIndex,leftIndex);
			  shiftDown(leftIndex);
		  }
		  if(isGreater(elements[rightIndex],elements[currentIndex])){
			  swap(currentIndex,rightIndex);
			  shiftDown(rightIndex);
		  }
	  }
  }

  /**
   * Verify that tree is complete
   * @param currentIndex
   * @return
   */
private boolean verifyCompleteness(int currentIndex){
	  int leftChild = leftChildIndex(currentIndex);
	  int rightChild = rightChildIndex(currentIndex);
	  
	  if(leftChild > lastIndex){
		  return true;
	  }
	  if(isGreater(elements[leftChild],elements[currentIndex])){
		  swap(leftChild, currentIndex);
		  verifyCompleteness(leftChild);
	  }
	  
	  if(rightChild > lastIndex){
		  return true;
	  }
	  if(isGreater(elements[rightChild],elements[currentIndex])){
		  swap(rightChild, currentIndex);
		  verifyCompleteness(leftChild);
	  }
	  
	  return true;
  }
  
  
  /**
   * Compares two elements and returns true if first element is greater than first
   * @param e
   *  first element
   * @param e2
   *  second element
   * @return
   *  true if e is greater than e2
   */
  private boolean isGreater(E e , E e2){
	  if((e instanceof Comparable) && (e2 instanceof Comparable)){
		  if (((Comparable<Comparable>)e).compareTo((Comparable)e2) < 0){
			  return true;
		  }
	  }
	  
	  return false;
  }
  
  /**
   * Swaps the two elements
   * @param e
   *  The first element to be swapped
   * @param e2
   *  The second element to be swapped
   */
  private void swap(int e, int e2) {
	E temp = elements[e];
	elements[e] = elements[e2];
	elements[e2] = temp;
  }

/**
 * 
 * @param arrayIndex
 * 	the index of element whose right child needs to be determined
 * @return
 * 	the index of left child
 */
  private int leftChildIndex(int thisElementIndex){
	  return 2*(thisElementIndex + 1);
  }
  
  /**
   * 
   * @param arrayIndex
   * 	the index of element whose right child needs to be determined
   * @return
   *  the index of right child
   */
  private int rightChildIndex(int thisElementIndex){
	  return 2*(thisElementIndex + 1) + 1;
  }
  
/**
 * Returns a string representation of all the heap elements
 * @return
 * 	String representation of this heap  
 */
  public String toString(){
    String theHeap = new String("The heap is:\n");
    for (int index = 0; index <= lastIndex; index++)
      theHeap = theHeap + index + ". " + elements[index] + "\n";
    return theHeap;
  }
}
