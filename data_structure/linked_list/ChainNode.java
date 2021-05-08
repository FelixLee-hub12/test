package linked_list;

public class ChainNode {
	ChainNode next;
	Object element;
	//Constructor
	public ChainNode() {};
	
	public ChainNode(Object theElement) {
		element = theElement;
	}
	
	public ChainNode(ChainNode nextNode, Object theElement) {
		next = nextNode;
		element = theElement;
	}
}
