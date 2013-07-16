package cis256.proj7;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * The application to test ChainedTable which is a Hashtable.
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class ChainedTableApplication {

	private static final int TOTAL_CUSTOMERS = 50;
	private static final int TABLE_SIZE = 71;
	private static final int MAXRANDOM_SEARCHES = 1000;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ChainedTableApplication ct = new ChainedTableApplication();
		
	}

	public ChainedTableApplication() throws IOException{
		Customer customers[] = new Customer[TOTAL_CUSTOMERS];
		
	    Scanner sc = new Scanner(new File("./customers.txt"));
	    for(int i=0;i<50;i++){
	    	String name = sc.next();
	    	Integer integ = new Integer(sc.next().substring(4));
	    	String add = sc.next();
	    	customers[i] = new Customer(name, add, integ);
	    	System.out.println(customers[i]);
	    }
	    
		ChainedTable hashTable = new ChainedTable(TABLE_SIZE);
	    for(int i=0; i< TOTAL_CUSTOMERS ;i++){
	    	hashTable.put(customers[i].getPhoneNumber(), customers[i]);
	    }
		
	    //Search a no of times
	    Random random = new Random();
	    Customer current; 	
	    for(int i=0; i< MAXRANDOM_SEARCHES ;i++){
	    	current = (Customer)hashTable.get(customers[random.nextInt(TOTAL_CUSTOMERS)].getPhoneNumber());
//	    	System.out.println(current.getName());	
	    }
	    
	    System.out.println("Estimated Efficiency " +hashTable.estimateEfficiency());
	    System.out.println("Actual Efficiency " +hashTable.actualEfficiency());
	    
	    
	}
	
}