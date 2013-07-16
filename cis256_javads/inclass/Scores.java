public class Scores {

  private int[] grades;
 
  public Scores() {
     grades = new int[3];
  }

 public Scores(int a, int b, int c) {
    grades = new int[3];
    grades[0] = a;
    grades[1] = b;
    grades[2] = c;
 }
 
 
 public Scores copy( ) {
 	      // create new Scores object
 	Scores temp = new Scores();
 	       // make it identical to 'this' object
 	for (int i=0; i<grades.length; i++)
 	    temp.grades[i] = grades[i];
 	       // return the copy
 	return temp;
 	
 }
         
public int highScore() {
    return high(0);
}

private int high(int startindex) {
   if (startindex == grades.length-1)
       return grades[startindex];
   else{
       int highRest = high(startindex+1);
       if (grades[startindex] > highRest)
          return grades[startindex];
       else
          return highRest;
   }
         
}

public int compareTo(Object obj){
	Scores sobj = (Scores) obj;
	int thisHigh = highScore();
	int objHigh = sobj.highScore();
	return thisHigh - objHigh;
}

public boolean equals(Object obj){
	if (obj == null) return false;
	if (obj instanceof Scores){
		Scores sobj = (Scores) obj;
	   return highScore() == sobj.highScore();
	}	
	else
       return false;	
}

public static int sumScores(Scores obj){
	int total = 0;  
	   // total up all the stored scoreds in the paramter object
	for (int i = 0; i< obj.grades.length; i++)
	   total = total + obj.grades[i];
	   
	return total;
}
	       
	
	
public String toString() {
  return "[" + grades[0] + " " + grades[1] + " " + grades[2] + "]" ;	
}
}

