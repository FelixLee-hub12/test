package learning_exercise;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,4,20,16,9,4,2,1};
		System.out.println("Before sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
		BubbleSort(arr);
		
		System.out.println("After sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private static void BubbleSort(int[] array) {
		
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; (j < i) ; j++) {
				if (array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			System.out.println(i);
		}
	}
}
