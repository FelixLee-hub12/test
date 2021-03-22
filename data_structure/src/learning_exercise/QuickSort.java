package learning_exercise;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,7,8,9,1,5,7,4};
		System.out.println("Before sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		
		Quick_Sort(arr, 0, arr.length -1);
		
		System.out.println("After sorting:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public static void Quick_Sort(int[] array, int left, int right){
		if (left >= right) return;
		else { 
			int middle = Partition(array, left, right);
			Quick_Sort(array, left, middle - 1);
			Quick_Sort(array, middle + 1, right);
		}
	}
	
	public static int Partition(int[] array, int left, int right) {
		int x = array[left];
		
		//index
		int i = left;
		
		for (int j = left + 1; j <= right; j++) {
			//compose the first part
			if (array[j] < x) {
				// i points to array[0] by default
				i++;
				//swap
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				
			}
		}
		
		int temp = array[i];
		array[i] = array[left];
		array[left] = temp;
		
		return i;
	}

}
