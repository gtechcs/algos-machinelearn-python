package inclass.proj4.ComparableE;


public class GBox implements Comparable<GBox>{
	
	//using the Generic implementation of Comparable allows the compiler to
	//to catch a call to compareTo with a parameter of the wrong type
	//-- the non-generic version of Comparable used in the Box class 
	// did not provide for compile time checking, and results in a 
	// Class Cast exception 

    private int side = 1;

public GBox (){}

public GBox (int newside) {
    side = newside;
}

public String toString() {
   return "Side is " + side;
}

public int compareTo(GBox obj) {   
                 
      return side - obj.side;
}
}
                          