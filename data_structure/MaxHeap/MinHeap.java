package MaxHeap;

import java.lang.reflect.Array;

public class MinHeap {
	Comparable [] heap;
	int size;
	
	public MinHeap(int initialCapacity) {
		if(initialCapacity < 1)
			throw new IllegalArgumentException ("init should be larger than 1");
		
		heap = new Comparable[initialCapacity];
		size = 0;
	}
	
	public MinHeap() {
		this(10);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Comparable getMin(Comparable[] heap, int size) {
		return (size == 0)?null:heap[0];
	}
	
	public void put(Comparable theElement) {
		if (size == heap.length) {
			heap = (Comparable []) ChangeArrayLength1D(heap, 2*heap.length);
		}
		
		//set the currentNode to the leaf
		int currentNode = size++;
		
		while (currentNode > 0 && heap[(currentNode - 1)/2].compareTo(theElement) > 0) {
			heap[currentNode] = heap[(currentNode - 1)/2];
			currentNode = (currentNode - 1)/2;
		}
		heap[currentNode] = theElement;
	}
	
	public Comparable removeMin(Comparable [] heap, int size) {
		if (size == 0) return null;
		
		Comparable removedElement = heap[0];
		heap[0] = heap[--size];
		heapify(heap, 0, size);
		this.size = size;
		
		return removedElement;
	}
	
	
	public void heapify(Comparable [] heap, int currentNode, int size) {
		Comparable lastElement = heap[currentNode];
		int child = currentNode * 2 + 1; // left child
		while (child < size) {
			if (child + 1 < size && heap[child].compareTo(heap[child + 1]) > 0) {
				child ++;
			}
			
			if (lastElement.compareTo(heap[child]) <= 0) {
				break;
			}
			
			heap[currentNode] = heap[child];
			currentNode = child;
			child = currentNode * 2 + 1;
		}
	}
	
	
	public static Object[] ChangeArrayLength1D(Object [] arr, int newLength) {
		int n = arr.length;
		if (n > newLength) {
			throw new IllegalArgumentException
            ("new length is too small");
		}
		
		Object [] newArray = (Object[]) Array.newInstance(arr.getClass().componentType(), newLength);
		
		System.arraycopy(arr, 0, newArray, 0, n);
		return newArray;
	}
}
