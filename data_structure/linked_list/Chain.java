package linked_list;

public class Chain implements linear_list_interface {
	// member variables
	protected ChainNode firstNode;
	protected int size;

	// Constructors
	public Chain(int initialCapacity) {
	}

	public Chain() {
		this(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chain x = new Chain();

		// test size
		System.out.println("initial size is " + x.size);

		// test isEmpty
		if (x.isEmpty()) {
			System.out.println("The list is empty");
		} else {
			System.out.println("The list is not empty");
		}

		// test add
		x.add(0, new Integer(2));
		x.add(1, new Integer(6));
		x.add(0, new Integer(1));
		x.add(2, new Integer(4));
		x.add(1, new Integer(7));
		System.out.println("List size is " + x.size());

		// test toString
		System.out.println("The list is " + x);

		// test indexOf
		int index = x.indexOf(new Integer(4));
		if (index < 0)
			System.out.println("4 not found");
		else
			System.out.println("The index of 4 is " + index);

		index = x.indexOf(new Integer(3));
		if (index < 0)
			System.out.println("3 not found");
		else
			System.out.println("The index of 3 is " + index);

		//test get
		System.out.println("Element at 0 is " + x.get(0));
	      System.out.println("Element at 3 is " + x.get(3));
	      
	      //test removed
	      System.out.println(x.remove(1) + " removed");
	      System.out.println("The list is " + x);
	      System.out.println(x.remove(2) + " removed");
	      System.out.println("The list is " + x);
	   
	      if (x.isEmpty())
	         System.out.println("The list is empty");
	      else System.out.println("The list is not empty");
	   
	      System.out.println("List size is " + x.size());

	         if (x.remove(new Integer(9)) == true)
	            System.out.println("9 removed");
	         else
	            System.out.println("9 is not in the list");
	         System.out.println("Then, the list is " + x);

	         if (x.remove(new Integer(2)) == true)
	            System.out.println("2 removed");
	         else
	            System.out.println("2 is not in the list");
	         System.out.println("Then, the list is " + x);

	         if (x.remove(new Integer(6)) == true)
	            System.out.println("6 removed");
	         else
	            System.out.println("6 is not in the list");
	         System.out.println("Then, the list is " + x);

	         if (x.remove(new Integer(1)) == true)
	            System.out.println("1 removed");
	         else
	            System.out.println("1 is not in the list");
	         System.out.println("Then, the list is " + x);

	         if (x.isEmpty())
	            System.out.println("The list is empty");
	         else System.out.println("The list is not empty"); 
	}

	void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int indexOf(Object theElement) {
		ChainNode currentNode = firstNode;
		int index = 0;
		// while currentnode is not null and the element of currentNode does not equal
		// to the target element
		while (currentNode != null && !currentNode.element.equals(theElement)) {
			currentNode = currentNode.next;
			index++;
		}

		if (currentNode == null) {
			return -1;
		} else {
			return index;
		}
	}

	@Override
	public Object get(int index) {
		checkIndex(index);

		ChainNode currentNode = firstNode;

		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode.element;
	}

	@Override
	public Object remove(int index) {
		checkIndex(index);
		Object removedElement;

		if (index == 0) {
			this.firstNode = this.firstNode.next;
			removedElement = firstNode.element;
		} else {
			ChainNode currentNode = firstNode;

			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}

			removedElement = currentNode.next.element;
			currentNode.next = currentNode.next.next;
		}
		size--;
		return removedElement;

	}

	@Override
	public boolean remove(Object theElement) {
		boolean found = firstNode.element.equals(theElement);

		if (found == true) {
			firstNode = firstNode.next;
		} else {
			ChainNode currentNode = firstNode;
			while (!found && currentNode.next != null) {
				if (currentNode.next.element.equals(theElement)) {
					found = true;
				} else {
					currentNode = currentNode.next;
				}
			}

			if (found == true) {
				currentNode.next = currentNode.next.next;
			}
		}
		// reduce size if the element found
		if (found == true) {
			size--;
		}

		return found;

	}

	@Override
	public void add(int index, Object theElement) {
		// TODO Auto-generated method stub
		if (index < 0 || index > size)
			// invalid list position
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);

		if (index == 0) {
			firstNode = new ChainNode(firstNode, theElement);
		} else {
			ChainNode currentNode = firstNode;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = new ChainNode(currentNode.next, theElement);
		}

		size++;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("[");

		// put elements into the buffer
		ChainNode currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode.element == null)
				s.append("null, ");
			else
				s.append(currentNode.element.toString() + ", ");
			currentNode = currentNode.next;
		}
		if (size > 0)
			s.delete(s.length() - 2, s.length()); // remove last ", "
		s.append("]");

		// create equivalent String
		return new String(s);
	}

}
