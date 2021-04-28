
/** a stack class that uses a linked structure */

   package dataStructures;

   import java.util.*;
   import utilities.*;

   public class LinkedStack implements Stack
   {
   // data members
      protected ChainNode top;  // pointer to the top element in stack
      protected int size;           // number of elements in array
   
   // methods
   /** @return true iff list is empty */
      public boolean empty()
      { return size == 0; }
   

   /** @return top element of stack
     * @throws EmptyStackException when the stack is empty */
   public Object peek()
   {
      if (empty())
         throw new EmptyStackException();
      return top.element;
   }

   /** add theElement to the top of the stack */
   public void push(Object theElement)
   {        
      // put theElement at the top of the stack
      top = new ChainNode(theElement, top);
      size++;
   }

   /** remove top element of stack and return it
     * @throws EmptyStackException when the stack is empty */
   public Object pop()
   {
      if (empty())
         throw new EmptyStackException();
      Object topElement = top.element;
      top = top.next;   
      size--;
      return topElement;
   }

   /** @return current number of elements in stack */
      public int size()
      { return size; }
      
   /** test program */
   public static void main(String [] args)
   {  
      LinkedStack s = new LinkedStack();
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
