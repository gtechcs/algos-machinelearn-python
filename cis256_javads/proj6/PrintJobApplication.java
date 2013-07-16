package cis256.proj6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Application for Project 6
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class PrintJobApplication {

	private static final int HEAP_SIZE = 100;
	
	private Heap<PrintJob> printerQueue;
	private PrintJob currentJob;
	private boolean currentJobDone = true;
	private int currentJobTimer = 0;
	private int currentJobDuration = -1;
	private int jobNumber = 0;
	private int totalJobsSubmitted = 0;
	private int totalJobsCompleted = 0;
	
	private PrintWriter outWriter;
    private Random randomGenerator;
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintJobApplication application = new PrintJobApplication();
		application.initialize();
	}

	private void initialize() {
		randomGenerator = new Random();
		
		printerQueue = new Heap<PrintJob>(HEAP_SIZE);
		
		try {
			File f =new File("outputfile.txt"); 
//			System.out.println("outfle path "+ f.getAbsolutePath());
			outWriter = new PrintWriter(new FileWriter(f));
		} catch (IOException e1) {
			System.out.println("Error opening outputfile.txt file");
			System.exit(1);	
		} 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputChoice = ""; 
		int minutesToSimulate = 0;

		try{
			System.out.println("Input the number of minutes this simulation should run:");
			inputChoice = br.readLine();
			System.out.println("You input = "+ inputChoice);
			minutesToSimulate = Integer.parseInt(inputChoice);
			System.out.println("This input will run for "+ minutesToSimulate + " minutes.");
		}catch(IOException e){
			System.out.println("You must input the number of minutes this simulation should run.");
			System.exit(1);
		}
		
		for(int i =0;i< minutesToSimulate;i++){
			runMinuteSimulation();
		}
		
		outWriter.println("Total Jobs submitted: " + totalJobsSubmitted);
		outWriter.println("Total Jobs completed: " + totalJobsCompleted );

		outWriter.flush();
		outWriter.close();
	}

	/**
	 * Runs the simulation one time!
	 */
	private void runMinuteSimulation(){
		if(getRandom(5)==0){// generates no between 0 to 4, checking for one specific no means one-fifth probability 
			createNewPrintJob();
		}
		
		if(currentJobDone){
			if(!printerQueue.isEmpty()){
				currentJob = printerQueue.remove();
				currentJobDuration = currentJob.getPrintTime();
				outWriter.println("currentJobNumber:"+ currentJob.getJobNumber());
				currentJobTimer = 0;
				currentJobDone = false;
			}
		}
		
		if(!currentJobDone){
			currentJobTimer++;
			outWriter.println("currentJobNumber:"+ currentJob.getJobNumber()+ " currentJobTimer:"+ currentJobTimer);
		}	
		
		if(currentJobTimer == currentJobDuration){
			currentJobDone = true;
			totalJobsCompleted++;
			currentJobDuration = -1;
			outWriter.println("CurrentJob Completed!");
		}
	}
	
	/**
	 * Create a new Print Job
	 * @return
	 * 	the PrintJob created
	 */
	private PrintJob createNewPrintJob(){
		int jobDuration = getRandom(11) + 1;//Job duration between 1 and 11
		jobNumber++;

		int jobPriority = getRandom(7) + 1;
		
		PrintJob newJob = new PrintJob(jobDuration, jobNumber, jobPriority); 
		printerQueue.add(newJob);
		
		outWriter.println(newJob.toString());
		totalJobsSubmitted++;
		return newJob;
	}
	
	
	/**
	 * Generate a random number 
	 * @param randomRange
	 * 	the max number(exclusive) of generated random number 
	 * @return
	 * 	the random number generated
	 */
	private int getRandom(int randomRange){
		return randomGenerator.nextInt(randomRange);
	}
	
}
