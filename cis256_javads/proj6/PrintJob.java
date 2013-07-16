package cis256.proj6;

/**
 * The PrintJob which should be put on heap for printing.
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class PrintJob implements Comparable{

	private int printTime;
	private int priority;
	private int jobNumber;
	
	public PrintJob (int thetime,  int thenumber,  int thepriority){
		printTime = thetime;
		priority = thepriority;
		jobNumber = thenumber;
    }
	
	/**
	 * Getter for printTime
	 * @return
	 * 	printTime
	 */
	public int getPrintTime() {
		return printTime;
	}
	
	/**
	 * Getter for jobNumber
	 * @return
	 * jobNumber
	 */
	public int getJobNumber() {
		return jobNumber;
	}
	
	/**
	 * String representation of PrintJob
	 * @return
	 * 	String representation
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("JobNumber=");
		sb.append(jobNumber);
		sb.append(" PrintTime=");
		sb.append(printTime);
		sb.append(" Priority=");
		sb.append(priority);
		
		return sb.toString();
	}
	
	@Override
	public int compareTo(Object object) {
		
		return priority - ((PrintJob)object).priority;
	}
	
}
