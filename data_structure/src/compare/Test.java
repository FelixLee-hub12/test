package compare;

public class Test {

	public static void print_max(Comparable [] a) {
		int max = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[max].compareTo(a[i]) <= 0) {
				max = i;
			}
		}
		
		System.out.print(a[max].toString() + " ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student [] a = {new Student("Amy", 5), new Student("Bob",7), new Student("Cat",6),
				new Student("David",9), new Student("Emily", 3), new Student("Fish", 4), new Student("Gigi", 2), new Student("Heidi",8), new Student("Ivy", 1)};
				print_max(a); System.out.println();
	}

}
