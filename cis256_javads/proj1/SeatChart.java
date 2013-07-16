package cis256.proj1;

/*
 *
 * author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 * 
 * 
 * This class provides an object which maintains up to N seat reservations.
 * seats are numbered from 0 to N-1
 * 
 */
public class SeatChart {

    private final int MAXSIZE = 10;   // capacity for this list
	private boolean[] seats;// true represent full seat, false is empty
	
	/*
	 * Effect:  initializes 10 seats
	 * Precondition: None
	 * Postcondition:  10 empty seats exist
	 */
	public SeatChart(){
		seats = new boolean[MAXSIZE];
	}
	
	/*
	 * Effect:  initializes max seats
	 * Precondition: max is a positive value
	 * Postcondition: max empty seats exist 
	 */
	public SeatChart(int max) throws Exception{
		if(max <=0){
			throw new Exception("Not a valid Seat no");
		}
		
		seats = new boolean[max];
	}
	
	/*
	 * Effect: reserves seat num
	 * Precondition: num is a valid seat number of an empty seat
	 * Postcondition: seat num is set to fulll
	 */
	public void reserve(int num){
		seats[num - 1] = true;
	}
	
	/*
	 * Effect: releases seat num
	 * Precondition: NONE
	 * Postcondition: seat num is now empty
	 *    if num is not valid number, no change made, error message to console
	 *    if num was not previously reserved,  message given to console
	 */
	public void release(int num) throws Exception{
		if(seats[num - 1] == false){
			throw new Exception("Seat was not reserved");
		}
		
		seats[num - 1] = false;
	}

	/*
	 * Effect: determines if seat num is available
	 * Precondition: None
	 * Postcondition: No change to SeatChart object
	 * Returns: returns true if seat num is available, false otherwise
	 *     IF num is invalid ArrayOutOfBounds exception will be thrown 
	 */
	public boolean available(int num) throws ArrayIndexOutOfBoundsException{
		return seats[num - 1];
	}
	
	/*
	 * Effect: determines if all seats are full
	 * Precondition: None 
	 * Postcondition: No change to SeatChart object
	 * Returns: returns true if no seats are available, false otherwise
	 * 
	 */
	public boolean isFull(){
		boolean isFull = true;
		for(int i = 0;i < seats.length;i++){
			if(seats[i] == false){
				isFull = false;
				break;
			}
		}
		
		return isFull;
	}
	
	/*
	 * Effect:  access method ; provides number of seats
	 * Precondition: None
	 * Postcondition: No change to SeatChart object
	 * Returns: returns number of seats in this object
	 */
	public int getmax(){
		return seats.length;
	}
	
	/* 
	 * Effect:  access method ; provides number of seats taken
	 * Precondition: None
	 * Postcondition: No change to SeatChart object
	 * Returns: returns number of seats currently taken
	 */
	public int numtaken(){
		int taken = 0;
		for(int i = 0;i < seats.length;i++){
			if(seats[i] == true){
				taken++;
			}
		}
		
		return taken;
	}
	
	/*
	 * Effect: empties all seats
	 * Precondition: aChart  is a non-null SeatChart object
	 * Postcondition:  all seats in aChart  have been emptied
	 */
	public static void clearAll(SeatChart aChart){
		if(aChart == null){
			return;
		}
		
		for(int i = 0;i < aChart.getmax();i++){
			try {
				aChart.release(i);
			} catch (Exception e) {
				// Not an issue
			}
		}
	}
	
	/*
	 * Effect:  determines the validity of a seat number
	 * Precondition: None
	 * Precondition: No change to SeatChart object
	 * Returns: true if num is a valid seat number, false otherwise
	 */
	public boolean validSeat(int num){
		if(num > 0 && num <= getmax()){
			return true;
		}
		
		return false;
	}
	
	/*
	 * Effect: determines equality of two SeatChart objects
	 * Precondition: obj is non-null object
	 * Postcondition:  SeatChart object is unchanged
	 * Returns:  true if all obj is SeatChart with same capacity and reserved seat as implied       
	 *           object,  false otherwise
	 *           Overrides:  Object class equals method
	 */
	public boolean equals(Object obj){
		if(obj == null || !(obj instanceof SeatChart)){
			return false;
		}
		
		SeatChart sc = (SeatChart)obj;
		if(sc.getmax() != this.getmax()){
			return false;
		}
		
		for(int i =0;i< this.getmax();i++){
			if(this.available(i+1) != sc.available(i+1)){
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Effect: creates a string containing numbers of all reserved seats in this SeatChart object
	 * Precondition:   None
	 * Postcondition:   the SeatChart object is unchanged
	 * Returns:  a string representation of the SeatChart object
	 * Overrides: Object class toString
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i =0;i< this.getmax();i++){
			sb.append("Seat "+ (i+1) + this.available(i)+ "\n");
		}
		
		return sb.toString();
	}
	
	/*
	 * Effect: a copy of the implied object is created
	 * Precondition:   None
	 * Postcondition:  SeatChart object is unchanged
	 * Returns:  a new SeatChart object with the same capacity and seat reservations
	 *      the implied object
	 */
	public SeatChart clone(){
		SeatChart sclone;
		try {
			sclone = new SeatChart(this.getmax());
			System.arraycopy( this.seats, 0, sclone.seats, 0, this.seats.length );
			return sclone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
