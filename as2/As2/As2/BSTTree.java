package As2;


/**
 * BSTTree
 *1.insertion
 *2. traversal LEFT-Right /Right-Left
 */
public class BSTTree {
	public BSTTree()
	{		
	}	
	
	private BSTNode  Root = null;	

	
	/**
	 * Insert the node to the tree
	 * 1.find the right place for the new node
	 * 2.update the reference for the node
	 * 3.attach the node to the tree
	 * @param node: the node wants to be inserted
	 */
	public void Insert( BSTNode node)
	{
		boolean hasInsert = false;
		//1.if the node is null, return;
		if(node == null)
			return;
		//2.if the root is null, make the rout
		else if(Root == null)
		{
			Root = node;
			hasInsert = true;
		}
		else
		{
			//compare the node from Root
			BSTNode current = Root;

			//Start the loop to find the new position to insert the new node
			do{
				//3.1 if the node is existed, change the indicator
				if(node.Data == current.Data)
				{
					hasInsert = true;		
				}
				//3.2 if the node greater then current node
				else if(node.Data > current.Data)
				{
					//3.2.1 if the current node has a right child(does not have right thread),
					if(current.IsRightThread== false)	
					{
						//set the Right child as the current node, then travel to the right node.
						current = current.Right;
					}
					//3.2.2 if the current node does not have a right child(have right thread),
					//attach the node the the right side as a child
					else
					{
						//3.2.2.1 prepare the node
						node.IsRightThread = true;//both the left and right children are thread for the new node
						node.IsLeftThread = true;
						node.Right = current.Right;// copy the Right reference of current as the Right child of the node
						node.Left = current;//set the current as the left child of node which is the  In order Left-Right successor 
												
						//3.2.2.2 attach the node to the right of current
						current.Right  = node;
						current.IsRightThread = false;


						//3.2.2.3 change the indicator
						hasInsert = true;
					}
				}
				//3.3 if the node smaller then current node
				//the detail logic is similar with 3.2 , but opposite
				else if(node.Data < current.Data)
				{
					if(current.IsLeftThread == false)	
						current = current.Left;
					else
					{
						node.Left = current.Left;
						node.IsLeftThread = true;
						node.Right = current;
						node.IsRightThread = true;
						
						current.Left = node;
						current.IsLeftThread = false;						
						
						hasInsert = true;
					}
				}				
				
			}while( hasInsert == false );
		}
		
		if(hasInsert)
			System.out.println("New Node inserted, its value is:" + node.Data);
		
	}	
	
	/**
	 * Traversal in order Left - Right
	 */
	public void TraversalInOrderLR()
	{
		if(Root == null)
			System.out.println("No items");
		else
		{
			//1.prepare the temporary variable 
			BSTNode current = Root;
			
			//it means that how program arrived at this Node
			//when isFromThread = false, it means from parent node. the access direction is from Up to Down in the tree.
			//when isFromThread = true, it means from child(or grand child...) node.  the access direction is from DOwn to Up in the tree.
			Boolean isFromThread = false;
			do{
				//2.1 from down to up
				//when left child is null, it means this is the most left child which is the smallest one.
				//or isFromThread == true, it means from child/grand child to parent 
				if(isFromThread || current.Left == null)
				{
					//2.1.1 output the current node
					System.out.println(current.Data);
					
					//2.1.2 set the right child as the current 
					isFromThread = current.IsRightThread;
					current = current.Right;
				}
				//2.2 from up to down
				else
				{
					//2.2.1 if current has a left child, then set the left child as the current
					if(current.IsLeftThread == false)
					{
						isFromThread = false;
						current = current.Left;//has real left child
					}
					//2.2.2 if current does not have a left child, then 
					// output current data
					// set right child as the current
					else
					{
						System.out.println(current.Data);
						isFromThread = current.IsRightThread;
						current = current.Right;
					}						
				}		
							
			}while(current!= null);			
		}
	}
		

	/**
	 * Traversal in order Left - Right
	 * The Idea is similar with TraversalInOrderLR, just have opposite direction
	 */
	public void TraversalInOrderRL()
	{
		if(Root == null)
			System.out.println("No items");
		else
		{
			BSTNode current = Root;
			Boolean isFromThread = false;
			do{

				if(isFromThread || current.Right == null)
				{
					//from down to up
					System.out.println(current.Data);
					isFromThread = current.IsLeftThread;
					current = current.Left;
				}
				else
				{
					//from up to down
					if(current.IsRightThread== false)
					{
						isFromThread = false;
						current = current.Right;//has real left child
					}
					else
					{
						//is  thead
						System.out.println(current.Data);
						isFromThread = current.IsLeftThread;
						current = current.Left;
					}						
				}						


			}while(current!=null);

		}
		
	}		
}
