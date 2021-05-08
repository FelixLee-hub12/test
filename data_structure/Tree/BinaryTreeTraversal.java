package Tree;

public class BinaryTreeTraversal {
	
	public static void visit(BinaryTreeNode node) {
		System.out.print(node.toString() + " ");
	}
	
	//preOrder traversal
	public static void preOrder(BinaryTreeNode node) {
		if (node != null) {
			visit(node);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}
	
	//inOrder traversal
	public static void inOrder(BinaryTreeNode node) {
		if (node != null) {
			inOrder(node.leftChild);
			visit(node);
			inOrder(node.rightChild);
		}
	}
	
	public static void postOrder(BinaryTreeNode node) {
		if (node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			visit(node);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode y = new BinaryTreeNode(new Integer(2));
	      BinaryTreeNode z = new BinaryTreeNode(new Integer(3));
	      BinaryTreeNode x = new BinaryTreeNode(new Integer(1), y, z);

	      System.out.println("The elements in preorder are");
	      preOrder(x);
	      System.out.println();

	      System.out.println("The elements in inorder are");
	      inOrder(x);
	      System.out.println();

	      System.out.println("The elements in postorder are");
	      postOrder(x);
	      System.out.println();

	}
}
