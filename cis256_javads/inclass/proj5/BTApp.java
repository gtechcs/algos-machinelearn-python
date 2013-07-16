package inclass.proj5;


public class BTApp{
   
   public static void main (String [] args){
   	
   	BTNode<Integer> temp = new BTNode<Integer> (78, null, null);
   	BTNode<Integer> root = new BTNode<Integer> (101, temp, null);
   	root = new BTNode<Integer>(56, root, null);
   	root.setRight(new BTNode<Integer>(27,null, null));
   	
   	System.out.println("The number of nodes is " + countNodes(root));

   	root.inorderPrint( );
   	
   	System.out.println("There are " + countLeafs(root) + " leafs in this tree");
   		
   	System.out.println("The sum of values in the tree is " + sumNodes(root));
   		
   		
   	
   }
   
   public static int countNodes(BTNode<Integer> node){
   	
   	if (node == null)  	  
   	    return 0;
   	else 
   	    return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
   	
   }
   
   
   public static int sumNodes(BTNode<Integer> node){
   		if(node == null){
   			return 0;
   		}else{
   			return node.getData() + sumNodes(node.getLeft()) + sumNodes(node.getRight());
   		}
   	}
   	
   	
   public static int countLeafs(BTNode<Integer> node){
	   if(node == null){
			return 0;
	   }else{
		   return 1 + countLeafs(node.getLeft()) + countLeafs(node.getRight());
	   }
   	
   	}
}
           
