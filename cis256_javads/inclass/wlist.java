
  public class wlist {
     private final int MAXSIZE = 50;   // capacity for this list
     private String[] list;            // word storage
     private int quantity;             // number of words in this list

     public wlist () {
       list = new String[MAXSIZE];
     }

     public void add(String aword) {
        for ( int i = quantity; i>0; i--)
        	list[i] = list[i-1];
        
		list[0] = aword;
		quantity++;

     }

     public boolean isThere (String aword) {
        int index = 0;
	    while (index < quantity && !list[index].equals(aword))
		    index++;
	    
	    return index < quantity;
     }

     public String toString () {
        String str = "";
        for (int index = 0; index < quantity; index++)
        	str = str +  list[index] + " ";
        
        return str;
     }

     public int getCap() {
        return MAXSIZE;
     }

     public void delete(String obj){
    	 
     }

     /*
      * O(1) method
      * 
      */
     public int length() {
    	 return quantity;
     }
     
     /*
      * O(N) method
      * 
      */
     public int slowLength() {
    	 int quantity = 0;
    	 for(int i=0;i< MAXSIZE && (list[i] != null) ;i++){
    		 quantity++;
    	 }
    	 return quantity;
     }

  }