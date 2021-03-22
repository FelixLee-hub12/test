package learning_exercise;

import java.util.Random;

public class LinearList {
	private static Random rand1 = new Random();
	private static int [] list = {20, 36, 16, 36, 7, 48, 67};
	
	public static void display() {
		if(list != null) {
			System.out.print("{"+ list[0]);
			for (int i = 1 ; i< list.length ; i++) {
				System.out.print(", " + list[i]);
			}
			System.out.println("}");
		}
	}
	
	public static void randomPosIntArr(int n, int max) {
		if ( n<0 || max < 2) throw new IllegalArgumentException();
		int [] arr = new int[n]; 
		for ( int i=0; i <n; i++)
			arr[i] = rand1.nextInt(max); 
		list = arr;
	}
	
	//code to be completed 
	
	public static void truncate(int n) {
		if(n>list.length) throw new IllegalArgumentException();
		int[] array = new int[n];
		System.arraycopy(list , 0, array, 0, n);
		list = array;
	}
	
	public static void reverse() {
		if (list == null) return;
		int n = list.length;
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] =list[n-1-i];
		}
		list = array;
	}
	
	public static void uniqueRandomInts(int n, int max) {
		if (n > max) throw new IllegalArgumentException();
		int [] array = new int[n];
		for (int i=0; i<n; i++) {
			next:
				for(;;) {
					int x = rand1.nextInt(max);
					for(int j = 0; j < i; j++) {
						if(array[j] == x) {
							continue next;
						}
					}
					array[i] = x;
					break;
				}
		
		}
		list = array;
	}
	
	public static void main(String[] args) { 
		LinearList.display();
	LinearList.reverse(); LinearList.display();
	LinearList.truncate(3); LinearList.display();
	LinearList.randomPosIntArr(6, 60); LinearList.display();
	LinearList.uniqueRandomInts(10, 15); LinearList.display();
	}
}