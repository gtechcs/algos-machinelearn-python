package inclass.proj4.GenericLinkedBag;



public class GLinkedBagApp2
{
  public static void main(String[] args) {
  	 GLinkedBag<String> mylist = new GLinkedBag<String>();
  	 mylist.insert("AA");
  	 mylist.insert("BB");
  	 mylist.insert("CC");
     mylist.insert(55);     // compiler will catch this
                                // if generic bag not used, error would result
                                // at run time when we try to cast as String
                                
  	 
  	 if (mylist.contains("DD"))
  	 	System.out.println("contains DD");
  	 else 
  	    System.out.println("DD is not there");
  	    
  	 
  	 mylist.reset();   
  	 for (int i = 0; i< mylist.lengthIs();  i++)
  	  System.out.println(((String)(mylist.getNextItem())).toUpperCase() ); 
  	    
  	    
  	
  	
  }

}