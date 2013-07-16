package cis256.proj6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class CopyOfPrintJobApplication {

	private static final int HEAP_SIZE = 10;
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
		CopyOfPrintJobApplication application = new CopyOfPrintJobApplication();
		application.initialize();
	}

	private void initialize() {
		randomGenerator = new Random();
		
		printerQueue = new Heap<PrintJob>(HEAP_SIZE);
		
		try {
			File f =new File("outputfile.txt"); 
			System.out.println("outfle path "+ f.getAbsolutePath());
			outWriter = new PrintWriter(new FileWriter(f));
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);	
		} 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputChoice = ""; 
		
		System.out.println("Input number of minutes to simulate \n");
		try{
			inputChoice = br.readLine();
			System.out.println("You input = "+ inputChoice);
		}catch(IOException e){
	         System.exit(1);
		}
		
		int minutesToSimulate = Integer.parseInt(inputChoice);
		
		System.out.println("minutesToSimulate: "+ minutesToSimulate);
		for(int i =0;i< minutesToSimulate;i++){
			System.out.println("Simulation: Minute "+ i);
			runMinuteSimulation();
		}
		
		outWriter.println("Total Jobs submitted: " + totalJobsSubmitted);
		outWriter.println("Total Jobs completed: " + totalJobsCompleted );

		System.out.println("Total Jobs submitted: " + totalJobsSubmitted);
		System.out.println("Total Jobs completed: " + totalJobsCompleted );
		
		outWriter.flush();
		outWriter.close();
	}

	private void runMinuteSimulation(){
		if(getRandom(5)==0){// generates no between 0 to 4, checking for one specific no means one-fifth probability 
			createNewPrintJob();
				
		}
		
		System.out.println("current Priority Queue : "+ printerQueue.toString());
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
			System.out.println("CurrentJob Completed!");
		}
		
	}
	
	private PrintJob createNewPrintJob(){
		int jobDuration = getRandom(11) + 1;//Job duration between 1 and 11
		jobNumber++;
//		System.out.println("Created jobNumber "+ jobNumber);

		int jobPriority = getRandom(7) + 1;
		
		PrintJob newJob = new PrintJob(jobDuration, jobNumber, jobPriority); 
		System.out.println("Created new Job "+ newJob.toString());
		printerQueue.add(newJob);
		
		outWriter.println(newJob.toString());
		totalJobsSubmitted++;
		return newJob;
	}
	
	
	
	private int getRandom(int randomRange){
		
		return randomGenerator.nextInt(randomRange);
	}
	
}
