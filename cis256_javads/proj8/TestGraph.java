package cis256.proj8;

import junit.framework.TestCase;

public class TestGraph extends TestCase {

	public void test2(){
		
		int NO_OF_COURSES = 10;
		Graph<String> courseGraph = new Graph<String>(NO_OF_COURSES);
		assertNotNull(courseGraph);
		
		courseGraph.addEdge(0, 1);
		courseGraph.addEdge(0, 2);
		courseGraph.printGraph();
		
		assertFalse(courseGraph.isPath(0,1));
		assertFalse(courseGraph.isPath(1,1));
		assertFalse(courseGraph.isPath(0,2));

		courseGraph.addEdge(2, 0);
		courseGraph.printGraph();
		assertTrue(courseGraph.isPath(0,2));
	}
	
	
/*	public void test1(){
		
		int NO_OF_COURSES = 10;
		Graph<String> courseGraph = new Graph<String>(NO_OF_COURSES);
		assertNotNull(courseGraph);
		
		courseGraph.addEdge(0, 1);
		courseGraph.addEdge(0, 2);
		courseGraph.printGraph();
		
		int index = 0;
		String e = courseGraph.getLabel(index);
		System.out.println("label for "+ index + " is "+ e);	
	
		System.out.println("isEdge 0 1 "+ courseGraph.isEdge(0, 1));	
		System.out.println("isEdge 0 2 "+ courseGraph.isEdge(0, 2));	
		System.out.println("isEdge 0 3 "+ courseGraph.isEdge(0, 3));
		
		int[] n = courseGraph.neighbors(0);
		System.out.println("Neighbours of 0 :");
		for(int i=0;i< n.length;i++){
			System.out.println("Neigh: "+ n[i]);
		}

		int[] n1 = courseGraph.neighbors(1);
		System.out.println("Neighbours of  1 :");
		for(int i=0;i< n1.length;i++){
			System.out.println("Neigh: "+ n1[i]);
		}

		courseGraph.removeEdge(0, 1);
		
		int[] n2 = courseGraph.neighbors(0);
		System.out.println("Neighbours of 0 :");
		for(int i=0;i< n2.length;i++){
			System.out.println("Neigh: "+ n2[i]);
		}
	
		courseGraph.setLabel(0,"T");
		String e1 = courseGraph.getLabel(index);
		System.out.println("label for "+ index + " is "+ e1);	
		
	}
*/	
	
}
