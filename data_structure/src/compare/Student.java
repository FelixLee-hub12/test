package compare;

public class Student implements Comparable<Student>{

	private String mName;
	public int mAge;
	public Student(String name, int age) {
		// TODO Auto-generated constructor stub
		mName = name;
		mAge = age;
	}
	@Override
	public int compareTo(Student a) {
		// TODO Auto-generated method stub
		if(mAge > a.mAge) {
			return 1;
		} else if (mAge < a.mAge) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public String toString() {
		return mName;
	}
}
