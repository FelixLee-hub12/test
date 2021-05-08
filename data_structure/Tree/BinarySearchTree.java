package Tree;

public class BinarySearchTree {
	class Node {
		int key;
		Object element;
		Node left, right;
		
		public Node(Object element) {
			this.element = element;
		}
		public Node(Object element, int key) {
			this.element = element;
			this.key = key;
		}
		
		public int compareKey(int theKey) {
			if (key > theKey) 
				return 1;
			else if (key < theKey)
				return -1;
			else 
				return 0;
		}
		
		public String toString() {
			return element.toString();
		}
	}
	
	//root of the tree
	Node root;
	
	//constructors
	public BinarySearchTree() {
		root = null;
	}
	
	//get the object of the tree
	public Object get(int theKey) {
		Node p = root;
		
		while (p != null) {
			if (p.compareKey(theKey) < 0) 
				p = p.right;
			else if (p.compareKey(theKey) > 0)
				p = p.left;
			else 
				return p.element;
		}
		return null;
	}
	
	//operation put
	public void put(int theKey, Object theElement) {
		Node p = root;
		Node pp = null;
		while (p != null) {
			pp = p;
			if (p.compareKey(theKey) < 0) 
				p = p.right;
			else if (p.compareKey(theKey) > 0)
				p = p.left;
			else {
				p.element = theElement;
				return; // terminate the program if a element is updated
			}
		}
		
		if (pp == null) {
			root = new Node(theElement, theKey);
		} else {
			if (pp.compareKey(theKey) < 0) 
				pp.right = new Node(theElement, theKey);
			else 
				pp.left = new Node(theElement, theKey);
		}
	}
	
	public Object remove(int theKey) {
		Node p = root;
		Node pp = null;
		//find the element
		while (p!= null && !(p.compareKey(theKey) == 0)) {
			pp = p;
			if (p.compareKey(theKey) < 0) 
				p = p.right;
			else
				p = p.left;
		}
		
		//if the element is not found
		if (p == null) 
			return null;
		
		//save the element to be deleted
		Object deleteElement = p.element;
		
		//handle element with two child
		if (p.left != null && p.right != null) {
			Node bigLeft = p.left;
			Node bigLeftParent = p;
			
			//find the biggest element in the left subtree
			while (bigLeft.right != null) {
				bigLeftParent = bigLeft;
				bigLeft = bigLeft.right;
			}
			
			//replace the deleteElement by the biggest element in the left subtree
			p.element = bigLeft.element;
			//adjust the pointer to element deletion
			p = bigLeft;
			pp = bigLeftParent;
		}
		
		Node c;
		if (p.left == null)
			c = p.right;
		else
			c = p.left;
		
		//remove node p
		if (p == root)
			root = c;
		else {
			if (p == pp.left)
				pp.left = c;
			else 
				pp.right = c;
		}
		
		return deleteElement;
	}
	
	public static void inOrder(Node n) {
		if (n != null) {
			inOrder(n.left);
			visit(n);
			inOrder(n.right);
		}
	}
	
	public static void visit(Node n) {
		System.out.print(n.toString() + " ");
	}
	
	public static void main(String [] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		//inserting element
		tree.put(2, new Integer(5));
		tree.put(5, new Integer(12));
		tree.put(1, new Integer(4));
		tree.put(8, new Integer(7));
		tree.put(6, new Integer(6));
		tree.put(4, new Integer(9));
		
		System.out.print("Original data set: ");
		inOrder(tree.root);
		System.out.println();
		
		System.out.println("the removed element is "+ tree.remove(6).toString());
		System.out.print("new: ");
		inOrder(tree.root);
		
	}
}
