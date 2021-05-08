package linked_list;

public interface linear_list_interface {

	public boolean isEmpty();
	public int size();
	public int indexOf(Object theElement);
	public Object get(int index);
	public Object remove(int index);
	public boolean remove(Object theElement);
	public void add(int index, Object theElement);
	public String toString();
}
