package learning_exercise;

public class selectionSort {
	public static void main (String[] args) {
		int[] arr = {6,4,20,16,9,4,2,1};
		System.out.println("Before sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
		selectionSort(arr);
		
		System.out.println("After sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private static void selectionSort(int[] array) {
		// TODO Auto-generated method stub
		boolean sorted = false;
		for (int i = array.length - 1; !sorted && (i > 0);i--) {
			int m = 0;
			for (int j = 1; j <= i; j++) {
				if (array[j] > array[m]) {
					m = j;
				}
				else {
					sorted =false;
				}
			}
			int temp = array[i];
			array[i] = array[m];
			array[m] = temp;
			
			System.out.println(i);
		}
	}
	
}
