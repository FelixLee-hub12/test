package tutorial4;

public class selectionSortEx {

	public static void show(int[] arr) {
		for (int i =0; i< arr.length - 1; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[arr.length -1]);
		
	}
	
	public static void asort(int [] element) {
		int temp, s = 1;
		boolean sorted = false;
		for (int k = element.length - 1; !sorted && k > 0 ; k--) {
			int largestPosition = 0; sorted = true;
			for (int i = 1; i <= k; i++) {
				if (element[largestPosition] < element[i]) {
					largestPosition = i;
				} 
				else 
					sorted = false;
			}
			temp = element[k];
			element[k] = element[largestPosition];
			element[largestPosition] = temp;
			
			System.out.print ("Pass " + s++ + " = "); show(element);
		} 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] num = {5,9,23,35,6,17,13,43,12};
		int [] num2 = {  4, 7, 5, 9, 6, 3, 2, 8, 1};
		asort(num2);
	}
}
