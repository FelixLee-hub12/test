
/** a stack class that uses a one-dimensional array */

package dataStructures;

import java.util.EmptyStackException;
import utilities.*;

public class ArrayStack implements Stack
{
   // data members
   int size;          // number of elements in stack
   Object [] stack;  // element array

   // constructors
   /** create a stack with the given initial capacity
     * @throws IllegalArgumentException when initialCapacity < 1 */
   public ArrayStack(int initialCapacity)
   {
      if (initialCapacity < 1)
         throw new IllegalArgumentException
               ("initialCapacity must be >= 1");
      stack = new Object [initialCapacity];
   }

   /** create a stack with initial capacity 10 */
   public ArrayStack()
      {this(10);}

   // methods
   /** @return true iff stack is empty */
   public boolean empty()
      {return size == 0;}

   /** @return top element of stack
     * @throws EmptyStackException when the stack is empty */
   public Object peek()
   {
      if (empty())
         throw new EmptyStackException();
      return stack[size-1];
   }

   /** add theElement to the top of the stack */
   public void push(Object theElement)
   {
      // increase array size if necessary
      if (size == stack.length)
         stack = ChangeArrayLength.changeLength1D(stack, 2 * stack.length);
         
      // put theElement at the top of the stack
      stack[size++] = theElement;
   }

   /** remove top element of stack and return it
     * @throws EmptyStackException when the stack is empty */
   public Object pop()
   {
      if (empty())
         throw new EmptyStackException();
      Object topElement = stack[--size];
      stack[size] = null;   // enable garbage collection
      return topElement;
   }

   /** get the number of elements in stack */
   public int size()
   {
      return size;
   }
   
   /** test program */
   public static void main(String [] args)
   {  
      ArrayStack s = new ArrayStack(3);
      // add a few elements
      s.push(new Integer(1));
      s.push(new Integer(2));
      s.push(new Integer(3));
      s.push(new Integer(4));

      // delete all elements
      while (!s.empty())
      {
         System.out.println("The stack size is " + s.size());
         System.out.println("Top element is " + s.peek());
         System.out.println("Removed the element " + s.pop());
      }
   }  
}
