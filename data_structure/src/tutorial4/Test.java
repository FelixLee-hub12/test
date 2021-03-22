package tutorial4;

public class Test {

	public static void show(int[] arr) {
		for (int i =0; i< arr.length - 1; i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println(arr[arr.length -1]);
		
	}
	
	public static void asort(int [] element) {
		int temp, s = 1;
		boolean swapped = true;
		for (int k = element.length - 1; k > 0 && swapped; k--) {
			swapped = false;
			for (int i = 0; i < k; i++)
				if (element[i] > element[i+1]) {
					temp = element[i]; element[i] = element[i+1]; element[i+1] = temp;
					swapped = true;
				}
			
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
