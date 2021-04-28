   package dataStructures;

 //  import java.lang.*;
   import utilities.*;

   public class ArraySortedList2
   {
   /** Preconditions: element[0] <= ... <= element[n - 1], and n < element.length;
         Postconditions: element[0] <= ... <= element[n], and theElement is among them. */
     public static void insert(Integer[] element, int n, Integer theElement)
     {
         // make sure we have space
         if (n >= element.length) {
         // no space, double capacity
             System.out.println("Full!  No space for new insertion.");
             return;
         }

         int i = 0; // find the first index i for which element[i] > theElement
         while (i < n && element[i] <= theElement)
             ++i;

         // shift element[i], ..., element[n-1] into [element[i+1], ..., element[n]
         for (int j = element.length - 1; j > i; j--)
            element[j] = element[j - 1];
            // ---> // System.arraycopy(element, i, element, i + 1, n - i);
    
         // insert theElement into element[i]
         element[i] = theElement;
     }
   
   /** test program */
      public static void main(String [] args)
      {

        int noOfElements = 0;  // The no of elements to be inserted
      // test default constructor
        Integer[] x = new Integer[10];
        x[0] = new Integer(1);
        x[1] = new Integer(2);
        x[2] = new Integer(4);
        x[3] = new Integer(5);
        noOfElements = 4;

      // test toString
         System.out.println("The list is: ");
         for (int j = 0; j < x.length; j++)
             if (x[j] != null)
                System.out.print(" " + x[j]);
         System.out.println("\nThe length is " + x.length);
         System.out.println("The no of elements to be inserted is " + noOfElements);
      
       // test put
         insert(x, noOfElements++, new Integer(13));
         // ---> //  insert(x, ++noOfElements, new Integer(13));
        System.out.println("After inserting 13 ...");
     
      // test toString
         for (int j = 0; j < x.length; j++)
             if (x[j] != null)
                System.out.print(" " + x[j]);
         System.out.println("\nThe length is " + x.length);
         System.out.println("The no of elements to be inserted is " + noOfElements);

         System.out.println();

       // test put
         insert(x, noOfElements++, new Integer(10));       
         insert(x, noOfElements++, new Integer(13));       
         insert(x, noOfElements++, new Integer(16));      
         insert(x, noOfElements++, new Integer(21));       
         insert(x, noOfElements++, new Integer(12));  
 
      // test toString
         System.out.println("The list is: ");
         for (int j = 0; j < x.length; j++)
             if (x[j] != null)
                System.out.print(" " + x[j]);
         System.out.println("\nThe length is " + x.length);
         System.out.println("The no of elements to be inserted is " + noOfElements);

       // test put
         insert(x, noOfElements++, new Integer(15));
     
      // test toString
         for (int j = 0; j < x.length; j++)
             if (x[j] != null)
                System.out.print(" " + x[j]);
         System.out.println("\nThe length is " + x.length);
         System.out.println("The no of elements to be inserted is " + noOfElements);
      }
   }
