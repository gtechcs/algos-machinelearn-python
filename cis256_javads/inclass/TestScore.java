public class TestScore {

 
  public static void main (String[] xx){
  	    
  	 Scores myscores, myscores2, myscores3;
  	 myscores = new Scores(60,30,75);
  	 myscores2 = new Scores(46,75,34);
  	 myscores3 = new Scores();
  	 
  	 //what is the highest score of each object
  	 System.out.println("myscores:highest score is " + myscores.highScore());
     System.out.println("myscores2 :highest score is " + myscores2.highScore());
  	 System.out.println("myscores3:  highest score is " + myscores3.highScore());
  	
  
  	// which are equal	
  	if (myscores.equals(myscores2))
  	   System.out.println( "" + myscores2 + " and " + myscores + " are equal");
  	else
  	      System.out.println( "" + myscores2 + " and " + myscores + " are NOT equal");
  	      
  	if (myscores.equals(myscores3))
  	   System.out.println( "" + myscores3 + " and " + myscores + " are equal");
  	else
  	      System.out.println( "" + myscores3 + " and " + myscores + " are NOT equal");
  	
  	
  	//which is greater
  	if (myscores.compareTo(myscores3) > 0)
  	   System.out.println("" + myscores + " is greater" );
  	else
  	 System.out.println("" + myscores3 + " is greater" );
  	 
  	 // make a copy
  	 Scores newObj = myscores.copy();
  	 System.out.println("the copies object is " + newObj);
  	 
  	 // add all scores
  	 System.out.println("sum of all scores of this object is " + Scores.sumScores(myscores));
  	 
  	 
  }

}