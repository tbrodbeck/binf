package blatt05;

import java.util.Arrays;

public class HeapSort {

   /**
    * Copies the array <code>elements</code> and sorts it using the given heap
    * <code>h</code>. Then returns the sorted copy.
    * 
    * @param h
    *           Heap which is used to sort <code>elements</code>
    * @param elements
    *           Elements which should be sorted.
    * @return a sorted copy of <code>elements</code>
    */
   public static <E extends Comparable> E[] heapSort(Heap<E> h, E[] elements) {

      E[] copy = Arrays.copyOf(elements, elements.length);

      Arrays.fill(copy, null);

      for (E e : elements) {
         h.insert(e);
      }

      int i = 0;
      while (!h.empty()) {
         copy[i++] = h.deleteFirst();
      }

      return copy;
   }

   public static void main(String[] args) {
      String s1 = "a";
      String s2 = "b";
      String s3 = "c";
      Heap<String> heap = new Heap<String>();
      Comparator<String> stringComparator = DefaultComparator.getInstance();
      Heap<String> heap2 = new Heap<String>(stringComparator);
      heap.insert(s2);
      heap.insert(s1);
      heap.insert(s3);
      heap2.insert(s2);
      heap2.insert(s1);
      heap2.insert(s3);
      if(!(heap.toString()).equals("a c b ")) System.out.println("Fehler beim einfügen(Comparable)");
      if(!(heap2.toString()).equals("a c b ")) System.out.println("Fehler beim einfügen(Comparator)");
      if(!(heap.returnSmallest() == s1)) System.out.println("Fehler beim ersten Wurzel ausgeben(Comparable)");
      if(!(heap.returnSmallest() == s1)) System.out.println("Fehler beim ersten Wurzel ausgeben(Comparator)");
      heap.deleteFirst();
      heap.deleteFirst();
      if(!(heap.toString()).equals("b c ")) System.out.println("Fehler beim löschen(Comparable)");
      if(!(heap.toString()).equals("b c ")) System.out.println("Fehler beim löschen(Comparator)");
   }

}
