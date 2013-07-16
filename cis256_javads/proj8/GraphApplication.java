package cis256.proj8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * Application to test Graph
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 */
public class GraphApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GraphApplication application = new GraphApplication();
		application.initialize();
	}

	private Graph<String> courseGraph;
	private void initialize() {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputChoice = ""; 
		
		int totalCourses;
		int index = 0;
		
		
		try{
			System.out.println("Input the number of courses in this graph:");
			inputChoice = br.readLine();
			System.out.println("You input = "+ inputChoice);
			totalCourses = Integer.parseInt(inputChoice);
			System.out.println("This will create "+ totalCourses + " courses.");
			courseGraph = new Graph<String>(totalCourses);

		}catch(IOException e){
			System.out.println("You must input the number of minutes this simulation should run.");
			System.exit(1);
		}
		
		while(true){
			showOptions();
			try{
				inputChoice = br.readLine();
				System.out.println("You input = "+ inputChoice);
			}catch(IOException e){
		         System.exit(1);
			}
			
			if(inputChoice.equals("c")){
				System.out.println("Input label for course:");
				try {
					inputChoice = br.readLine();
					courseGraph.setLabel(index,inputChoice);
					index++;
				} catch (Exception e) {
					System.err.println("Unable to add "+ inputChoice);
				}
			} else if(inputChoice.equals("e")){
				System.out.println("Input two course name with space");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					if(st.countTokens() != 2){
						throw new Exception("Must be two courses");
					}
					int v1 = courseGraph.findVertexIndex((String)st.nextElement());
					int v2 = courseGraph.findVertexIndex((String)st.nextElement());
					if(v1 == -1 || v2 == -1){
						System.err.println("Both Courses must exist");
					}else
						courseGraph.addEdge(v1, v2);
				} catch (Exception e) {
					System.err.println("Unable to remove "+ inputChoice);
				}
			}else if(inputChoice.equals("r")){
				System.out.println("Input two course name with space");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					if(st.countTokens() != 2){
						throw new Exception("Must be two courses");
					}
					int v1 = courseGraph.findVertexIndex((String)st.nextElement());
					int v2 = courseGraph.findVertexIndex((String)st.nextElement());
					courseGraph.removeEdge(v1, v2);
				} catch (Exception e) {
					System.err.println("Unable to remove "+ inputChoice);
				}
			} else if(inputChoice.equals("n")){
				System.out.println("Input two course name with space");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					if(st.countTokens() != 2){
						throw new Exception("Must be two courses");
					}
					int v1 = courseGraph.findVertexIndex((String)st.nextElement());
					int v2 = courseGraph.findVertexIndex((String)st.nextElement());
					int[] neighbors = courseGraph.neighbors(v1);
					for(int i=0;i<neighbors.length;i++){
						if(neighbors[i] == v2){
							System.out.println("Course one is the immediate prerequisite of second.");
							continue;
						}
					}
					System.err.println("Course one is not immediate prerequisite of second.");
					
				} catch (Exception e) {
					System.err.println("Must be two seperate Strings: "+ inputChoice);
				}
			} else if(inputChoice.equals("p")){
				System.out.println("Input two course name with space");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					if(st.countTokens() != 2){
						throw new Exception("Must be two courses");
					}
					int v1 = courseGraph.findVertexIndex((String)st.nextElement());
					int v2 = courseGraph.findVertexIndex((String)st.nextElement());
					boolean isPrerequisite = courseGraph.isPath(v1, v2);
					System.out.println(" The courses are prerequite "+ isPrerequisite);
				} catch (Exception e) {
					System.err.println("Must be two seperate Strings: "+ inputChoice);
				}
			} else if(inputChoice.equals("a")){
				System.out.println("Input course name ");
				try {
					inputChoice = br.readLine();
					StringTokenizer st = new StringTokenizer(inputChoice);
					if(st.countTokens() != 1){
						throw new Exception("Must be one course");
					}
					int v1 = courseGraph.findVertexIndex((String)st.nextElement());
					
					int[] neighbors = courseGraph.neighbors(v1);
					for(int i=0;i<neighbors.length;i++){
						System.out.println("Course can be taken after: "+ courseGraph.getLabel(neighbors[i]));
					}
				} catch (Exception e) {
					System.err.println("Must be two seperate Strings: "+ inputChoice);
				}
			} else if(inputChoice.equals("o")){
				try{
					for(int i=0;i<courseGraph.size();i++){
						System.out.println("Course "+ courseGraph.getLabel(i));
					}
				} catch (Exception e) {
					System.err.println("Must be two seperate Strings: "+ inputChoice);
				}
			} else if(inputChoice.equals("q")){
				System.exit(1);
			} else{
				System.err.println("Unrecognised option "+ inputChoice );
			}
		}
	}

	

	/*
	 * Prints all the options available to user
	 * 
	 */
	private void showOptions(){
		System.out.println("\nUser Options: ");
		System.out.println("Enter a new course. Press c");
		System.out.println("Enter a prerequisite relationship between two courses. Press e");
		System.out.println("Remove a prerequisite relationship between two courses. Press r");
		System.out.println("Report if one course is the immediate prerequisite of another. Press n");
		System.out.println("Report if there is a prerequisite path between on course and another. Press p");
		System.out.println("Output all courses which can be taken directly after taking that course. Press a");
		System.out.println("Outputs all courses which have been entered. Press o");
		System.out.println("Quit. Press q");
		
	}
	
	
}
