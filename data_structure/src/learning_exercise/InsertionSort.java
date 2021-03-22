package learning_exercise;

public class InsertionSort {
	public static void insert(int j, int[] s) {
		int k;
		int temp = s[j];
		
		for (k = j; k > 0 && temp > s[k-1]; k--) {
			s[k] = s[k-1];
		}
		
		s[k] = temp;
	}
	
	public static void main(String [] args) {
		int [] a = {7, 5 ,3 ,8 ,7};
		// display the unsorted list of integers
		System.out.println("Unsorted List: "+a[0]+", "+a[1]+", "+a[2]+", "+a[3]+", "+a[4]); // insertion sort
		for (int i = 1; i < a.length; i++) 
			insert(i, a);
		// display the sorted list of integers
		System.out.println("Sorted List: "+a[0]+", "+a[1]+", "+a[2]+", "+a[3]+", "+a[4]);
	}
}
