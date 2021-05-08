package StackQueue;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack implements Stack {

	int size;
	Object[] stack;

	public ArrayStack(int initialCapacity) {
		if (initialCapacity < 1)
			throw new IllegalArgumentException("initialCapacity must be >= 1");
		stack = new Object[initialCapacity];
	}

	/** create a stack with initial capacity 10 */
	public ArrayStack() {
		this(10);
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public Object peek() {
		return stack[size - 1];
	}

	public int size() {
		return size;
	}

	@Override
	public void push(Object theElement) {
		if (size == stack.length)
			stack = ChangeArrayLength1D(stack, 2 * stack.length);

		stack[size++] = theElement;
	}

	@Override
	public Object pop() {
		if (empty())
			throw new EmptyStackException();
		Object topElement = stack[--size];
		stack[size] = null; // enable garbage collection
		return topElement;
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

	/** test program */
	public static void main(String[] args) {
		ArrayStack s = new ArrayStack(3);
		// add a few elements
		s.push(new Integer(1));
		s.push(new Integer(2));
		s.push(new Integer(3));
		s.push(new Integer(4));

		// delete all elements
		while (!s.empty()) {
			System.out.println("The stack size is " + s.size());
			System.out.println("Top element is " + s.peek());
			System.out.println("Removed the element " + s.pop());
		}
	}
}
