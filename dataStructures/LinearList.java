
/** interface for linear lists */

   package dataStructures;

   public interface LinearList
   {
      public boolean isEmpty();
      public int size();
      public Object get(int index);
      public int indexOf(Object theElement);
      public Object remove(int index);
      public boolean remove(Object theElement);
      public void add(int index, Object theElement);
      public String toString();
   }
