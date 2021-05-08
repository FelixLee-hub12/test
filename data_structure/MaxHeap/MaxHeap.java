package MaxHeap;

import java.lang.reflect.Array;

public class MaxHeap {
	// data member
	Comparable[] heap;
	int size;

	// Constructors
	public MaxHeap(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("init should be larger than 1");

		heap = new Comparable[initialCapacity];
		size = 0;
	}

	public MaxHeap() {
		this(10);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Comparable getMax(Comparable[] heap, int size) {
		return (size == 0) ? null : heap[0];
	}

	public void put(Comparable theElement) {
		// change the size automatically
		if (size == heap.length) {
			heap = (Comparable[]) ChangeArrayLength1D(heap, 2 * heap.length);
		}
		// set the currentNode to the leaf
		int currentNode = size++;

		while (currentNode > 0 && heap[(currentNode - 1) / 2].compareTo(theElement) < 0) {
			// move down the parent
			heap[currentNode] = heap[(currentNode - 1) / 2];
			// upstaging the currentNode
			currentNode = (currentNode - 1) / 2;
		}
		heap[currentNode] = theElement;
	}

	public Comparable removeMax(Comparable[] heap, int size) {
		if (size == 0)
			return null;

		Comparable removedElement = heap[0];

		heap[0] = heap[--size];
		heapify(heap, 0, size);
		this.size = size;

		return removedElement;
	}

	public void heapify(Comparable[] heap, int currentNode, int size) {
		// store the last element to compare with other element
		Comparable lastElement = heap[currentNode];
		int child = currentNode * 2 + 1; // left child
		while (child < size) {
			if (child + 1 < size && heap[child].compareTo(heap[child + 1]) < 0) {
				child++;
			}

			if (lastElement.compareTo(heap[child]) >= 0)
				break;

			heap[currentNode] = heap[child]; // move the child element to upper level
			currentNode = child; // currentNode move down one level
			child = currentNode * 2 + 1; // reset the child pointer to iterate
		}
		heap[currentNode] = lastElement;
	}

	public void initialize(Comparable[] heap, int size) {
		this.size = size;
		for (int j = (size - 2) / 2; j >= 0; j--) {
			heapify(heap, j, size);
		}
	}

	public static Object[] ChangeArrayLength1D(Object[] arr, int newLength) {
		int n = arr.length;
		if (n > newLength) {
			throw new IllegalArgumentException("new length is too small");
		}

		Object[] newArray = (Object[]) Array.newInstance(arr.getClass().componentType(), newLength);

		System.arraycopy(arr, 0, newArray, 0, n);
		return newArray;
	}

	// HeapSort function
	public static void HeapSort(Comparable[] a) {
		MaxHeap h = new MaxHeap();
		h.initialize(a, a.length);

		for (int i = a.length - 1; i > 0; i--) {
			a[i] = h.removeMax(a, i + 1);
		}
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("The " + size + " elements are [");
		if (size > 0) {// nonempty heap
						// do first element
			s.append(heap[0]);
			// do remaining elements
			for (int i = 1; i <= size - 1; i++)
				s.append(", " + heap[i]);
		}
		s.append("]");

		return new String(s);
	}

//	public static void main(String [] args)
//	   {
//	      Integer [] a = {new Integer(3),
//	                      new Integer(2),
//	                      new Integer(4),
//	                      new Integer(1),
//	                      new Integer(6),
//	                      new Integer(9),
//	                      new Integer(8),
//	                      new Integer(7),
//	                      new Integer(5),
//	                      new Integer(0)};
//
//	      // output elements to be sorted
//	      System.out.println("The elements are");
//	      for (int i = 0; i < a.length; i++)
//	         System.out.print(a[i] + " ");
//	      System.out.println();
//
//	      // sort the elements
//	      HeapSort(a);
//
//	      // output in sorted order
//	      System.out.println("The sorted order is");
//	      for (int i = 0; i < a.length; i++)
//	         System.out.print(a[i] + " ");
//	      System.out.println();
//	   }
	
	
	public static void main(String[] args) {
		// test constructor and put
		MaxHeap h = new MaxHeap(4);
		h.put(new Integer(10));
		h.put(new Integer(20));
		h.put(new Integer(5));

		// test toString
		System.out.println("Elements in array order are");
		System.out.println(h);
		System.out.println();

		h.put(new Integer(15));
		h.put(new Integer(30));

		System.out.println("Elements in array order are");
		System.out.println(h);
		System.out.println();

		// test remove max
		System.out.println("The max element is " + h.getMax(h.heap, h.size));
		System.out.println("Elements in array order are");
		System.out.println(h);
		System.out.println("Deleted max element " + h.removeMax(h.heap, h.size));
		// h.size--; // if "this.size = size;" statement is set in removeMax() method,
		// then no need to do "h.size--;" here
		System.out.println("Elements in array order are");
		System.out.println(h);
		System.out.println("Deleted max element " + h.removeMax(h.heap, h.size));
		// h.size--; // if "this.size = size;" statement is set in removeMax() method,
		// then no need to do "h.size--;" here
		System.out.println("Elements in array order are");
		System.out.println(h);
		System.out.println();

		// test initialize
		h = null;
		h = new MaxHeap(10);
		for (int i = 0; i <= 9; i++)
			h.heap[i] = new Integer(i + 1);
		h.size = 10;
		System.out.println("Elements in array order are");
		System.out.println(h);
		h.initialize(h.heap, h.size);
		System.out.println("After initializing the array to heap, the elements in array order are");
		System.out.println(h);
	}
}
