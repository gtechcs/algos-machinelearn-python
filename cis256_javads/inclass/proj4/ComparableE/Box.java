package inclass.proj4.ComparableE;


public class Box implements Comparable{

    private int side = 1;

public Box (){}

public Box (int newside) {
    side = newside;
}

public String toString() {
   return "Side is " + side;
}

public int compareTo(Object obj) {   // will crash if param is not Box
      Box temp = (Box) obj;                // due to class cast exception
      return side - temp.side;
}
}
                           // If compareTo is passed a non-Box run time error will occur
                           // compiler cannot catch this because w/ parameter of type Object
                           // any type object is 'legal'

                          // parameter must be Object to satisfy Comparable interface