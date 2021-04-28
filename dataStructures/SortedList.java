
/** interface for ordered lists */

   package dataStructures;

   public interface SortedList
   {
      public boolean isEmpty();
      public int size();
      public Object get(int index);
      public int indexOf(Object theElement);
      public Object remove(int index);
      public boolean remove(Object theElement);
      // public void add(int index, Object theElement);
      public void insert(Object theElement);
      public String toString();
   }
