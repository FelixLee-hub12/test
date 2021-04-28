
/** array implementation of SortedList */

   package dataStructures;

   import java.util.*;
   import utilities.*;

   public class ArraySortedList implements SortedList
   {
   // data members
      protected Object [] element;  // array of elements
      protected int size;           // number of elements in array
   
   // constructors
   /** create a list with initial capacity initialCapacity
     * @throws IllegalArgumentException when
     * initialCapacity < 1 */
      public ArraySortedList(int initialCapacity)
      {
         if (initialCapacity < 1)
            throw new IllegalArgumentException
                  ("initialCapacity must be >= 1");
      // size has the default initial value of 0
         element = new Object [initialCapacity];
      }
   
   /** create a list with initial capacity 10 */
      public ArraySortedList()
      {// use default capacity of 10
         this(10);
      }
   
   // methods
   /** @return true iff list is empty */
      public boolean isEmpty()
      {
         return size == 0;}
   
   /** @return current number of elements in list */
      public int size()
      {
         return size;}
   
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
         return element[index];
      }
   
   /** @return index of first occurrence of theElement,
     * return -1 if theElement not in list */
      public int indexOf(Object theElement)
      {
      // search element[] for theElement
         for (int i = 0; i < size; i++)
            if (element[i].equals(theElement))
               return i;
      
      // theElement not found
         return -1;
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
      
      // valid index, shift elements with higher index
         Object removedElement = element[index];
         for (int i = index + 1; i < size; i++)
            element[i-1] = element[i];
      
         element[--size] = null;   // enable garbage collection
         return removedElement;
      }
   
   /** Overload remove() method. 
     * Remove the first occurrence of the specified element.
     * All elements after the removed element 
     * have their index reduced by 1. */
      public boolean remove(Object theElement)
      {
         boolean found = false; 
                 
         for (int i = 0; i < size; i++)
         {   // if the specified element is in the list, shift elements as follows:
              if (theElement.toString().equals(element[i].toString()))
                 found = true;
              if (found == true && i+1 < size)
                 element[i] = element[i+1];
         }
      
         if (found == true)
            element[--size] = null;   // enable garbage collection

         return found;
      }

   /** Preconditions: element[0] <= ... <= element[element.length - 1];
         Postconditions: element[0] <= ... <= element[element.length], and theElement is among them. */
     public void insert(Object theElement)
     {
      // valid index, make sure we have space
         if (size == element.length)
         // no space, double capacity
            element = ChangeArrayLength.changeLength1D(element, 2 * size);

         // make sure we have space

         int i = 0; // find the first index i for which element[i] > theElement
         while (element[i] != null && Integer.parseInt(element[i].toString()) <= Integer.parseInt(theElement.toString()))
             ++i;

         // shift element[i], ..., element[n-1] into [element[i+1], ..., element[n]
         for (int j = element.length - 1; j > i; j--)
            element[j] = element[j - 1];  
            // ---> // System.arraycopy(element, i, element, i + 1, element.length - i - 1);
    
         // insert theElement into element[i]
         element[i] = theElement;

         size++;
     }

   /** convert to a string */
      public String toString()
      {
         StringBuffer s = new StringBuffer("["); 
      
      // put elements into the buffer
         for (int i = 0; i < size; i++)
            if (element[i] == null)
               s.append("null, ");
            else
               s.append(element[i].toString() + ", ");
      
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
         SortedList x = new ArraySortedList();
      
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
   }
