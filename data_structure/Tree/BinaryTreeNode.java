package Tree;

public class BinaryTreeNode {
	Object element;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	//constructors
	public BinaryTreeNode () {
		
	}
	
	public BinaryTreeNode(Object element) {
		this.element = element;
	}
	
	public BinaryTreeNode(Object element, BinaryTreeNode leftNode, BinaryTreeNode rightNode) { 
		this.element = element;
		this.leftChild = leftNode;
		this.rightChild = rightNode;
	}
	
	// set methods
	public void setLeftChild(BinaryTreeNode leftNode) {
		this.leftChild = leftNode;
	}

	public void setRightChild(BinaryTreeNode rightNode) {
		this.leftChild = rightNode;
	}
	
	public void setElement(Object theElement) {
		this.element = theElement;
	}
	
	//Turn the element to string 
	public String toString() {
		return this.element.toString();
	}
	

}
