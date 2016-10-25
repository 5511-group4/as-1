package As2;

public class As2 {
	public static void main(String[] args){
		//Build the tree
		BSTTree tree  = new  BSTTree();
		tree.Insert(new BSTNode(45));
		tree.Insert(new BSTNode(78));
		tree.Insert(new BSTNode(89));
		tree.Insert(new BSTNode(32));
		tree.Insert(new BSTNode(60));
		tree.Insert(new BSTNode(25));
		
		tree.Insert(new BSTNode(39));
		tree.Insert(new BSTNode(91));
		
		tree.Insert(new BSTNode(12));
		
		tree.Insert(new BSTNode(34));
		
		tree.Insert(new BSTNode(65));
		
		

		//TraversalInOrderLR
		System.out.println("TraversalInOrderLR start.....");
		tree.TraversalInOrderLR();
		
		//TraversalInOrderRL
		System.out.println("TraversalInOrderRL start.....");
		tree.TraversalInOrderRL();
	   }
}
