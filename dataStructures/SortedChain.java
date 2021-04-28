

/** linked implementation of SortedList */

package dataStructures;

import java.util.*;

public class SortedChain implements SortedList
{
   // data members
   protected ChainNode firstNode;
   protected int size;

   // constructors
   /** create a list that is empty */
   public SortedChain(int initialCapacity)
   {
    // the default initial values of firstNode and size
    // are null and 0, respectively
   }

   public SortedChain()
      {this(0);}

   // methods
   /** @return true iff list is empty */
   public boolean isEmpty()
      {return size == 0;}

   /** @return current number of elements in list */
   public int size()
      {return size;}

   /** @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1 */
   void checkIndex(int index)
   {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException
               ("index = " + index + "  size = " + size);
   }

   /** @return element with specified index
     * @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1 */
   public Object get(int index)
   {
      checkIndex(index);
   
      // move to desired node
      ChainNode currentNode = firstNode;
      for (int i = 0; i < index; i++)
         currentNode = currentNode.next;
   
      return currentNode.element;
   }

   /** @return index of first occurrence of theElement,
     * return -1 if theElement not in list */
   public int indexOf(Object theElement)
   {
      // search the chain for theElement
      ChainNode currentNode = firstNode;
      int index = 0;  // index of currentNode
      while (currentNode != null &&
            !currentNode.element.equals(theElement))
      {
         // move to next node
         currentNode = currentNode.next;
         index++;
      }
   
      // make sure we found matching element
      if (currentNode == null)
         return -1;
      else
         return index;
   }

   /** Remove the element with specified index.
     * All elements with higher index have their
     * index reduced by 1.
     * @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1
     * @return removed element */
   public Object remove(int index)
   {
      checkIndex(index);
   
      Object removedElement;
      if (index == 0) // remove first node
      {
         removedElement = firstNode.element;
         firstNode = firstNode.next;
      }
      else 
      {  // use q to get to predecessor of desired node
         ChainNode q = firstNode;
         for (int i = 0; i < index - 1; i++)
            q = q.next;
      
         removedElement = q.next.element;
         q.next = q.next.next; // remove desired node
      }
      size--;
      return removedElement;
   }

   /** Overload remove() method. 
     * Remove the first occurrence of the specified element.
     * All elements after the removed element 
     * have their index reduced by 1. */
      public boolean remove(Object theElement)
      {
         boolean found = (theElement.toString().equals(firstNode.element.toString())); 
        
         if (found == true)
              firstNode = firstNode.next;  // remove first node
         else
         {
              ChainNode q = firstNode;
              while (!found && q.next != null)
              {
                   if (theElement.toString().equals(q.next.element.toString()))
                      found = true;
                   else
                      q = q.next;
               }
               if (found == true)
                   q.next = q.next.next;   // remove desired node
         }
         
         if (found == true)
            size--;
         return found;
      }

     public void insert(Object theElement)
     {
         if (firstNode == null) 
            firstNode = new ChainNode(theElement, null);
         else
             if (firstNode.element != null && Integer.parseInt(firstNode.element.toString()) > Integer.parseInt(theElement.toString())) 
                 firstNode = new ChainNode(theElement, firstNode);
         else
         {
         
             ChainNode q = firstNode;

             while (q.next != null && q.next.element != null && Integer.parseInt(q.next.element.toString()) < Integer.parseInt(theElement.toString()))
                q = q.next;

             q.next = new ChainNode(theElement, q.next);
         }
         size++;
     }
         

   /** convert to a string */
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
   
      // put elements into the buffer
      ChainNode currentNode = firstNode;
      while(currentNode != null)
      {
         if (currentNode.element == null)
            s.append("null, ");
         else
            s.append(currentNode.element.toString() + ", ");
         currentNode = currentNode.next;
      }
      if (size > 0)
         s.delete(s.length() - 2, s.length());  // remove last ", "
      s.append("]");
   
      // create equivalent String
      return new String(s);
   }

   /** test program */
   public static void main(String [] args)
   {
      // test default constructor
      SortedChain x = new SortedChain();
   
      // test size
      System.out.println("Initial size is " + x.size());
   
      // test isEmpty
      if (x.isEmpty())
         System.out.println("The list is empty");
      else System.out.println("The list is not empty");
   
      // test put
      x.insert(new Integer(2));
      x.insert(new Integer(6));
      x.insert(new Integer(1));
      x.insert(new Integer(4));
      x.insert(new Integer(7));
      System.out.println("List size is " + x.size());
   
      // test toString
      System.out.println("The list is " + x);
   
      // test indexOf
      int index = x.indexOf(new Integer(4));
      if (index < 0)
         System.out.println("4 not found");
      else System.out.println("The index of 4 is " + index);
   
      index = x.indexOf(new Integer(3));
      if (index < 0)
         System.out.println("3 not found");
      else System.out.println("The index of 3 is " + index);
   
      // test get
      System.out.println("Element at 0 is " + x.get(0));
      System.out.println("Element at 3 is " + x.get(3));
      
      // test remove
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

         if (x.remove(new Integer(7)) == true)
            System.out.println("7 removed");
         else
            System.out.println("7 is not in the list");
         System.out.println("Then, the list is " + x);

         if (x.remove(new Integer(4)) == true)
            System.out.println("4 removed");
         else
            System.out.println("4 is not in the list");
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
}
