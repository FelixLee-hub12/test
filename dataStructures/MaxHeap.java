   
/** max heap */

package dataStructures;

import utilities.*;

public class MaxHeap 
{
   // data members
   Comparable [] heap;   // array for complete binary tree
   int size;             // number of elements in heap

   // constructors
   /** create a heap with the given initial capacity
     * @throws IllegalArgumentException when
     * initialCapacity < 1 */
   public MaxHeap(int initialCapacity)
   {
      if (initialCapacity < 1)
         throw new IllegalArgumentException
                   ("initialCapacity must be >= 1");
      heap = new Comparable [initialCapacity];
      size = 0;
   }
   
   /** create a heap with initial capacity 10 */
   public MaxHeap()
      {this(10);}

   // methods
   /** @return true iff the heap is empty */
   public boolean isEmpty()
      {return size == 0;}

   /** @return number of elements in the heap */
   public int size()
      {return size;}

   /** @return maximum element
     * @return null if the heap is empty */
   public Comparable getMax(Comparable[] heap, int size)
      {return (size == 0) ? null : heap[0];}

   /** put theElement into the heap */
   public void put(Comparable theElement)
   {
      // increase array size if necessary
      if (size == heap.length)
         heap = (Comparable []) ChangeArrayLength.changeLength1D
                                    (heap, 2 * heap.length);
   
      // find place for theElement
      // currentNode starts at new leaf and moves up tree
      int currentNode = size++;
      while (currentNode > 0 &&
             heap[(currentNode-1) / 2].compareTo(theElement) < 0)
      {
         // cannot put theElement in heap[currentNode]
         heap[currentNode] = heap[(currentNode-1) / 2]; // move element down
         currentNode = (currentNode-1) / 2;                    // move to parent
      }
   
      heap[currentNode] = theElement;
   }
   
   /** heapify */
   public void heapify(Comparable[] heap, int currentNode, int size)
   {
      // find place for lastElement starting at root
      Comparable lastElement = heap[currentNode];
      int child = currentNode * 2 + 1;  // set left child
      while (child < size)
      {
         // heap[child] should be larger child of currentNode
         if (child + 1 < size &&
             heap[child].compareTo(heap[child + 1]) < 0) child++;
   
         // can we put lastElement in heap[currentNode]?
         if (lastElement.compareTo(heap[child]) >= 0)
            break;   // yes
   
         // no
         heap[currentNode] = heap[child]; // move child up
         currentNode = child;              // move down a level
         child = currentNode * 2 + 1;  // set left child
      }
      heap[currentNode] = lastElement;
   }

   /** remove max element and return it */
   public Comparable removeMax(Comparable[] heap, int size)
   {
      // if heap is empty return null
      if (size == 0) return null;       // heap empty
   
      Comparable maxElement = heap[0];  // max element
   
      // reheapify
      heap[0] = heap[--size];
      heapify(heap, 0, size);
      this.size = size;  // alternatively, this.size can be decremented at calling environment
  
      return maxElement;
   }
 

   // initialize max heap to element array theHeap 
   public void initialize(Comparable[] heap, int size)
   {
      this.size = size;
      for (int j =  (size - 2) / 2; j >= 0; j--)
         heapify(heap, j, size);
   }
  
   public String toString()
   {
      StringBuffer s = new StringBuffer(); 
      s.append("The " + size + " elements are [");
      if (size > 0)
      {// nonempty heap
         // do first element
         s.append(heap[0]);
         // do remaining elements
         for (int i = 1; i <= size - 1; i++)
            s.append(", " + heap[i]);
      }
      s.append("]");

      return new String(s);
   }

   /** test program */
   public static void main(String [] args)
   {
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
      // h.size--;  // if "this.size = size;" statement is set in removeMax() method, then no need to do "h.size--;" here
      System.out.println("Elements in array order are");
      System.out.println(h);
      System.out.println("Deleted max element " + h.removeMax(h.heap, h.size));
      // h.size--;  // if "this.size = size;" statement is set in removeMax() method, then no need to do "h.size--;" here
      System.out.println("Elements in array order are");
      System.out.println(h);
      System.out.println();

      // test initialize
      h = null;
      h = new MaxHeap(10);
      for (int i = 0; i <= 9; i++)
         h.heap[i] = new Integer(i+1);
      h.size = 10;
      System.out.println("Elements in array order are");
      System.out.println(h);
      h.initialize(h.heap, h.size);
      System.out.println("After initializing the array to heap, the elements in array order are");
      System.out.println(h);
   }
}
