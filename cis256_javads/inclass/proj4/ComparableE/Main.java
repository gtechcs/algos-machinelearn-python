package inclass.proj4.ComparableE;


public class Main{

  public static void main (String[] args){
  
       //GBox mybox = new GBox(5);  // compiler will catch error
       //GBox mybox2 = new GBox(7);
       
        Box mybox = new Box(5);    // error won't happen until run time
        Box mybox2 = new Box(7);
       
       
       if (mybox.compareTo("aab") > 0)
              System.out.println(mybox + " is larger ");
       else
              System.out.println(mybox2 + " is larger ");
  	
  	}
  }

// Note that if GBox is used, the compiler will notice when an object of an
// improper type is passed to compareTo
//  If Box is used as the object type,  this will be a runtime error.