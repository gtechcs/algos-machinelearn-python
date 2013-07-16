package cis256.proj5;

import java.util.Stack;

/**
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class IntTreeBag implements Cloneable
{
   // Invariant of the IntTreeBag class:
   //   1. The elements in the bag are stored in a binary search tree.
   //   2. The instance variable root is a reference to the root of the
   //      binary search tree (or null for an empty tree).
   private IntBTNode root;   


   /**
   * Insert a new element into this bag.
   * @param <CODE>element</CODE>
   *   the new element that is being inserted
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this bag.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory a new IntBTNode.
   **/
   public void add(int element)
   {      
	   iteratorStack.clear();
	   
      // Implemented by student.
	   if(root == null){
		   root = new IntBTNode(element, null, null);
		   return;
	   }
	   
	   boolean done = false;
	   IntBTNode cursor = root;
	   
	   while(!done){
		   if(element <= cursor.getData()){
			   if(cursor.getLeft() == null){
				   IntBTNode newNode = new IntBTNode(element, null, null);
				   cursor.setLeft(newNode);
				   done = true;
			   }else{
				   cursor = cursor.getLeft();
			   }
		   }
		   if(element > cursor.getData()){
			   if(cursor.getRight() == null){
				   IntBTNode newNode = new IntBTNode(element, null, null);
				   cursor.setRight(newNode);
				   done = true;
			   }else{
				   cursor = cursor.getRight();
			   }
		   }
	   }
   }


   /**
   * Add the contents of another bag to this bag.
   * @param <CODE>addend</CODE>
   *   a bag whose contents will be added to this bag
   * <dt><b>Precondition:</b><dd>
   *   The parameter, <CODE>addend</CODE>, is not null.
   * <dt><b>Postcondition:</b><dd>
   *   The elements from <CODE>addend</CODE> have been added to this bag.
   * @exception IllegalArgumentException
   *   Indicates that <CODE>addend</CODE> is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of the bag.
   **/
   public void addAll(IntTreeBag addend)
   {
      // Implemented by student.
	   IntBTNode addroot;
	   
	   if(addend == null){
		   throw new IllegalArgumentException("The IntTreeBag is null.");
	   }
	   
	   if(root == addend.root){
		   addroot = IntBTNode.treeCopy(addend.root);
		   addTree(addroot);
	   }else{
		   //Use Helper method 
		   addTree(addend.root);
	   }
   }
   
   /**
    * Helper Method
    * @param addroot
    * 	The IntBTNode/treeBag to be added to this IntTreeBag
    */
   private void addTree(IntBTNode addroot){
	   if(addroot != null){
		   add(addroot.getData());
		   addTree(addroot.getLeft());
		   addTree(addroot.getRight());
	   }
   }
   
   /**
   * Generate a copy of this bag.
   * @param - none
   * @return
   *   The return value is a copy of this bag. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to an <CODE>IntTreeBag</CODE> before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public Object clone( )
   {  // Clone an IntTreeBag object.
      // Student will replace this return statement with their own code:
	   IntTreeBag intTreeBag;
	   
	   try
	   {
		   intTreeBag = (IntTreeBag) super.clone( );
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
	   
	   intTreeBag.root = IntBTNode.treeCopy(root); 
	   
      return intTreeBag; 
   }
   

   /**
   * Accessor method to count the number of occurrences of a particular element
   * in this bag.
   * @param <CODE>target</CODE>
   *   the element that needs to be counted
   * @return
   *   the number of times that <CODE>target</CODE> occurs in this bag
   **/
   public int countOccurrences(int target)
   {
      // Student will replace this return statement with their own code:
      return countNodes(root, target);
   }
   
   /**
    * 
    * @param node
    * @return
    */
   private static int countNodes(IntBTNode node, int target){
//	   	System.out.println("Node = "+node + " target= "+target);
	   	if (node == null)  	  
	   	    return 0;
	   	else 
	   	    return ((node.getData() == target)? 1: 0) + 
	   	    	countNodes(node.getLeft(), target) + 
	   	    	countNodes(node.getRight(), target);
   }
             
   /**
   * Remove one copy of a specified element from this bag.
   * @param <CODE>target</CODE>
   *   the element to remove from the bag
   * <dt><b>Postcondition:</b><dd>
   *   If <CODE>target</CODE> was found in the bag, then one copy of
   *   <CODE>target</CODE> has been removed and the method returns true. 
   *   Otherwise the bag remains unchanged and the method returns false. 
   **/
   public boolean remove(int target)
   {
	   
	   iteratorStack.clear();

      // Student will replace this return statement with their own code:
	   if(root == null){
		   return false;
	   }
	   
	   IntBTNode cursor = root;
	   IntBTNode parentOfCursor = null;
	   while(cursor != null && cursor.getData() != target ){
		   parentOfCursor = cursor;
		   if(target < cursor.getData()){
			   cursor = cursor.getLeft();
		   }else{
			   cursor = cursor.getRight();
		   }
//		   System.out.println("cursor "+ cursor.getData() + " parentOfCursor "+ parentOfCursor.getData());
	   }
	   
	   //Case 1
	   if(cursor == null){
		   return false;
	   }
	   
	   //Case 2:
	   if(cursor == root && cursor.getLeft() == null){
		   root = root.getRight();
		   return true;
	   }
	   
	   //Case 3:
	   if(cursor.getLeft() == null){
		   if(cursor == parentOfCursor.getLeft()){
			   parentOfCursor.setLeft(cursor.getRight());
		   }else{
			   parentOfCursor.setRight(cursor.getLeft());
		   }
		   
		   return true;
	   }
	   
//	   System.out.println("Case 4 "+ cursor.getData());
	   //Case 4:
	   cursor.setData(cursor.getLeft().getRightmostData());
	   cursor.setLeft(cursor.getLeft().removeRightmost());
	   return true;
   }
   
      
   /**
   * Determine the number of elements in this bag.
   * @param - none
   * @return
   *   the number of elements in this bag
   **/                           
   public int size( )
   {
      return IntBTNode.treeSize(root);
   }
   

   /**
   * Create a new bag that contains all the elements from two other bags.
   * @param <CODE>b1</CODE>
   *   the first of two bags
   * @param <CODE>b2</CODE>
   *   the second of two bags
   * <dt><b>Precondition:</b><dd>
   *   Neither b1 nor b2 is null.
   * @return
   *   the union of b1 and b2
   * @exception IllegalArgumentException
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new bag.
   **/   
   public static IntTreeBag union(IntTreeBag b1, IntTreeBag b2)
   {
      // Student will replace this return statement with their own code:
	   IntTreeBag intTreeBag = new IntTreeBag();
	   
	   intTreeBag.addTree(b1.root);
	   intTreeBag.addTree(b2.root);
	   
	   return intTreeBag;
   }
    
   
   /**
    * Outputs the contents of the IntTreeBag to standard output.
    *  
    * 
    */
   public void print(){
	   if(root != null){
		   root.print(1);
	   }else{
		   System.out.println("The List is empty.");
	   }
//	   if(root != null){
//		   System.out.println("XXXXXXXXXX INORDER XXXXXXXXXXXXXXXXXXXX");
//		   root.inorderPrint();
//		   System.out.println("XXXXXXXXXX PREORDER XXXXXXXXXXXXXXXXXXXX");
//		   root.preorderPrint();
//		   System.out.println("XXXXXXXXXX POSTORDER XXXXXXXXXXXXXXXXXXXX");
//		   root.postorderPrint();
//	   }
   }
   
   private Stack<Integer> iteratorStack = new Stack<Integer>();
   
   /**
    * Returns an iterator over the elements in this IntTreeBag
    * @return
    */
   public Iterator iterator(){
	   return new Iterator();
   }
   
   /**
    * Internal Iterator
    * @author Administrator
    *
    */
   public class Iterator{
	   public void start(){
		   iteratorStack.clear();
		   putInStack(root);
	   }
	   
	   private void putInStack(IntBTNode node){
		   if(node == null){
			   return;
		   }
		   putInStack(node.getLeft());
		   iteratorStack.add(node.getData());
		   putInStack(node.getRight());
	   }
	   
	   public Integer advance(){
		   if(!iteratorStack.isEmpty()){
			   return iteratorStack.pop();
		   }
		   return null;
	   }

	   public boolean isCurrent(){
		   return !iteratorStack.isEmpty();
	   }

	   public Integer getCurrent(){
		   if(!iteratorStack.isEmpty()){
			   return iteratorStack.peek();
		   }
		   return null;
	   }
   }
   
}
           
