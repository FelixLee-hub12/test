package Sorting_algorithm;

public class Sorting {
	
	//SELECTION SORT
	public static void selectionSort(Comparable [] a) {
		for (int i = a.length -1 ; i > 0;i--) {
			int m = 0;
			for (int j = 1; j <= i ;j++) {
				if (a[m].compareTo(a[j]) <= 0) {
					m = j;
				}
			}
			
			Comparable temp = a[i];
			a[i] = a[m];
			a[m] = temp;
		}
	}
	//OPTIMTIZED SELECTION SORT
	public static void OptimizedSelectionSort(Comparable [] a) {
		boolean sorted = false;
		for (int i = a.length - 1; !sorted && (i > 0); i--) {
			
			int m = 0; // largest position
			sorted = true;
			
			for (int j = 1; j <= i; j++)
				if (a[m].compareTo(a[j])<=0) {
					m = j;
				} else
					sorted = false;
			
			Comparable temp = a[i];
			a[i] = a[m];
			a[m] = temp;
		}
	}
	
	//BUBBLE SORT
	public static void bubbleSort(Comparable [] a) {
		for (int i = a.length - 1; i > 0 ; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j+1]) > 0) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	//OPTIMIZED BUBBLE SORT
	public static void optimizedBubbleSort(Comparable [] a) {
		
		boolean swapped;
		for (int i = a.length - 1; i > 0; i--) {
			swapped = false;
			for (int j = 0; j < i; j++) {
				if (a[j].compareTo(a[j+1]) > 0 ) {
					Comparable temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = true;
				}
			}
			if (swapped == false) break;
			System.out.println(i);
		}
	}
	
	//MERGE SORT
	public static void mergeSort(Comparable [] a, int left, int right) {
		if (left < right) {
			int middle = (left+right)/2;
			mergeSort(a,left,middle);
			mergeSort(a,middle+1,right);
			merge(a,left,middle,right);
		}
	}
	
	public static void merge(Comparable [] a, int left, int middle, int right) {
		//setting pointer
		int first = left;
		int second = middle + 1;
		int result = left;
		Comparable [] tempArray = new Comparable[a.length];
		
		while (first <= middle && second <=right) {
			if (a[first].compareTo(a[second]) <= 0 ) 
				tempArray[result++] = a[first++];
			else
				tempArray[result++] = a[second++];
		}
		
		if (first > middle) {
			for (int i = second; i <= right; i++) 
				tempArray[result++] = a[i];
		}
		else 
			for (int i = first; i <= middle; i++) 
				tempArray[result++] = a[i];
		
		
		for (int i = left; i <= right; i++) {
			a[i] = tempArray[i];
		}
		
	}
	
	//QUICK SORT
	public static void quickSort(Comparable [] a, int left, int right) {
		if (left < right) {
			//partition
			Comparable pivot = a[left];
			int i = left;
			for (int j = left+1; j <= right; j++) {
				//when the j is smaller than pivot
				if (a[j].compareTo(pivot) < 0) {
					i++;
					Comparable temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
			//swap pivot position
			a[left] = a[i];
			a[i] = pivot;
			
			//recursively call the function
			quickSort(a, left, i-1);
			quickSort(a,i+1,right);
		}
	}
	//INSERTION SORT
	public static void insertionSort(Comparable [] a) {
		for (int i = 1; i < a.length;i++) {
			Comparable temp = a[i];
			int j;
			for ( j = i; j > 0 && temp.compareTo(a[j-1]) < 0; j--)
				a[j] = a[j-1];
			a[j] = temp;
		}
	}
	
	public static void main(String [] args)
	   {
	      Integer [] a = {new Integer(3),
	                      new Integer(2),
	                      new Integer(4),
	                      new Integer(1),
	                      new Integer(6),
	                      new Integer(9),
	                      new Integer(8),
	                      new Integer(7),
	                      new Integer(5),
	                      new Integer(0)};

	      // output elements to be sorted
	      System.out.println("The elements are");
	      for (int i = 0; i < a.length; i++)
	         System.out.print(a[i] + " ");
	      System.out.println();

	      // sort the elements
//	      OptimizedSelectionSort(a);
//	      selectionSort(a);
//	      mergeSort(a,0,a.length -1);
//	      quickSort(a,0,a.length-1);
	      insertionSort(a);
	      // output in sorted order
	      System.out.println("The sorted order is");
	      for (int i = 0; i < a.length; i++)
	         System.out.print(a[i] + " ");
	      System.out.println();
	   }
}
