package learning_exercise;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4,6,2,7,2,10};
		
		System.out.println("before sorting");
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + ",");
		}
		
		Sort(arr,0,arr.length-1);
		System.out.println("after sorting");
		for (int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + ",");
		}
		
	}
	
	public static void Sort (int [] array, int left, int right) {
		if (left >= right) return;
		else {
			int middle = (left+right) /2;
			Sort(array, left, middle);
			Sort(array, middle + 1, right);
			Merge(array, left, middle, right);
		}
	}
	
	public static void Merge(int [] array, int left, int middle, int right) {
		int first = left, second = middle + 1, result = left;
		int [] temp = new int [array.length];
		
		while ((first <= middle) && (second <= right)) {
			if (array[first] <= array[second]) {
				temp[result] = array[first];
				result++;
				first++;
			}
			else {
				temp[result] = array[second];
				result++;
				second++;
			}
			
		}
		
		//handle remaining elements
		if (first > middle) {
			for (int i = second; i <=right; i++) {
				temp[result] = array[i];
				result++;
			}
		}
		else {
			for (int i = first ; i <=middle; i++) {
				temp[result] = array[i];
				result++;
			}
		}
		
		//copy the array
		for (int i = left; i <=right; i++) {
			array[i] = temp[i];
		}
	}
	

}
