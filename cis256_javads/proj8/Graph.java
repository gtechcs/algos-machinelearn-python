package cis256.proj8;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 
 * Graph implementation with Edge lists
 * 
 * @author: Puneet Kumar
 * studentId: G00905264
 * CIS 256 
 *
 * @param <E>
 * This is list implementation of a labeled graph with a fixed number of vertices 
 * and labels of type E
 * 
 */
public class Graph <E>{

	private E[] vertexlist; //array which stores Vertex labels
    private LinkedList[]  edges;   // array which stores edge lists, one for each vertex
    
    /**
     * Initializes a Graph with n vertices, and null labels
     * @param n
     * The number of vertices in this graph
     */
	@SuppressWarnings("unchecked")
	public Graph(int n){
    	vertexlist = (E[])new Object[n];
    	System.out.println("test");	
    	edges = new LinkedList[n];
    }

	/**
	 * Add an edge
	 * @param source
	 * 	the vertex number of source of the edge
	 * @param target
	 * 	the vertex number of targer of the edge
	 */
    public void addEdge(int source, int target){
    	System.out.println("Adding to node "+ source + " target " + target);	
    	if(edges[source] == null){
        	System.out.println("Adding node "+ source + " is null ");	
    		edges[source] = new LinkedList<EdgeNode>();
    	}
    	
    	EdgeNode edgeNode = new EdgeNode(target);
    	edges[source].add(edgeNode);
    }
    
    /**
     * Generate a copy of this Graph
     */
    @SuppressWarnings("unchecked")
	public Graph<E> clone(){
    	Graph<E> answer;
    	
    	try{
    		answer = (Graph<E>) super.clone();
    	}catch(CloneNotSupportedException e){
    		throw new RuntimeException("This class does not implement Cloneable");
    	}
    	
    	answer.edges = edges.clone();
    	answer.vertexlist = vertexlist.clone();
    	
    	return answer;
    }

    /**
     * Accessor method to get the label of a vertex of this Graph
     * @param vertex
     * 	vertex number
     * @return
     * 	the label of specified vertex
     */
    public E getLabel(int vertex){
    	return vertexlist[vertex];
    }
    
    /**
     * test whether an edge exists
     * @param source
     * 	the vertex number of source
     * @param target
     * 	the vertex number of target
     * @return
     * 	
     */
    public boolean isEdge(int source, int target){
    	if(edges[source] != null){
    		for(int i=0; i<edges[source].size(); i++){
    			if( ((EdgeNode)edges[source].get(i)).getvnum() == target){
    				return true;
    			}
    		}
    	}
    	
    	return false;
    }
    
    /**
     * Accessor method to obtain list of neighbors of a specified vertex of this Graph
     * @param vertex
     * @return
     * 	array of neighbors
     */
    public int [ ] neighbors (int vertex){
    	int[] neighbors = null;
    	if(edges[vertex] != null){
    		neighbors = new int[edges[vertex].size()];
    		for(int i=0; i<edges[vertex].size(); i++){
    			neighbors[i] = ((EdgeNode)edges[vertex].get(i)).getvnum();
    		}
    	}else{
    		neighbors = new int[0];
    	}
    	
    	return neighbors;
    }

    /**
     * Remove an edge of this Graph
     * @param source
     * @param target
     */
    public void removeEdge(int source, int target){
    	if(edges[source] != null){
    		for(int i=0; i<edges[source].size(); i++){
    			if( ((EdgeNode)edges[source].get(i)).getvnum() == target){
    				edges[source].remove(i);
    			}
    		}
    	}
    }
    
    /**
     * change label of a vertex of this Graph
     * @param vertex
     * @param newLabel
     */
    public void setLabel(int vertex, E newLabel){
    	vertexlist[vertex] = newLabel;
    }
    
    /**
     * The number of vertices in this Graph
     * @return
     */
    public int size( ){
    	return vertexlist.length;
    }

    /**
     * Determines if a pth exists between two vertices
     * @param source
     * @param target
     * @return
     */
    public boolean isPath(int source, int target){
    	String[] vertexlabels = new String[size()]; //array which stores processing labels

    	String processedTag = "PROCESSED";	
    	Queue queue = new LinkedList();
    	
    	vertexlabels[source] = processedTag;
    	queue.add(source);
    	
		System.out.println("\nChecking Path for "+ source);
    	while(!queue.isEmpty()){
    		int current = (Integer) queue.remove();
    		System.out.println("Processing "+ current);
    		int[] n = neighbors(current);
    		for(int i=0; i<n.length; i++){
    			int currentNeighbour = n[i];
    			System.out.println("has neighbour "+currentNeighbour + " with label " + vertexlabels[currentNeighbour]);

    			if(processedTag.equals(vertexlabels[currentNeighbour])){
    				//Process 
    				if(currentNeighbour == source){
    	    			System.out.println("PATH EXISTS : "+ currentNeighbour + " and "+current);
    					return true;
    				}
    			}else{
    				vertexlabels[currentNeighbour] = processedTag;
    				queue.add(currentNeighbour);
    			}
    		}
    	}
		System.out.println("\n");
    	
    	return false;
    }
    
    public String printGraph(){
    	StringBuffer sb = new StringBuffer();
    	System.out.println("PrintGraph Total nodes are "+ vertexlist.length);	
    	for(int i =0; i<vertexlist.length; i++){
    		sb.append(i + ": ");
        	if(edges[i] != null){
        		for(int ii=0; ii<edges[i].size(); ii++){
        			sb.append(((EdgeNode)edges[i].get(ii)).getvnum()+ " ");
        		}
        	}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	
    	return sb.toString();
    }
    
    public int findVertexIndex(E courseName){
    	for(int i=0; i< vertexlist.length;i++){
    		if(courseName.equals(vertexlist[i])){
    			return i;
    		}
    	}
    	return -1;
    }
    
    
    /**
     * A object of this class represents one edge in the graph
     * vertex it is going TO
     * @author Administrator
     *
     */
    class EdgeNode{                       
        private int vertexNum;
        
        public EdgeNode(int vnum){
        	vertexNum = vnum;	
		}
        
        public void setvnum(int vnum){
        	vertexNum = vnum;
        }
        
        public int getvnum(){
			return vertexNum;
		}
        
        public boolean equals(Object obj){
        	if(!(obj instanceof Graph.EdgeNode)){
        		return false;
        	}
        	if(((Graph.EdgeNode)obj).vertexNum == vertexNum){
        		return true;
        	}
        	
			return false;
		}
    }   
    
    
}
