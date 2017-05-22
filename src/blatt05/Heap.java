package blatt05;
import java.util.Comparator;
import static java.util.Arrays.copyOf;

/**
 * Ein Heap ist ein binärer Baum, der bis zur vorletzten Ebene voll besetzt ist. Auf der Blatt-Ebene ist er von
 * links beginnend bis zum letzten Element vollständig besetzt. Jeder Knoten eines Heaps enthält einen
 * Schlüssel. Der Schlüssel eines Knotens ist kleiner oder gleich der Schlüssel seiner Kind-Knoten.
 *
 * Implementieren Sie einen typsicheren Heap.
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class Heap<T>{

    private T[] h;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Heap() {
    }

    /**
     * fügt Element in Heap ein und verlängert Array um eins
     * @param e Element
     */
    public void insert(T e) {
        if(comparator == null && !(e instanceof Comparable)) throw new RuntimeException("nicht comparable");
        T[] h2;
        if (h == null) {
            h2 = new T[1];
            h2[0] = e;
        }
        else {
            h2 = kopieplus(h, e);
            h2[h.length] = e;
            sift(h2);
        }
        h = h2;
    }

    public boolean empty() {
        return (h == null);
    }

    /**
     * gibt Wurzel des Heaps zurück
     * @return kleinstes Element
     */
    public T returnSmallest() {
        if(empty()) throw new RuntimeException("nichts da");
        return h[0];
    }

    /**
     * löscht die Wurzel und stellt Heap wieder her
     * @return gelöschtes Element
     */
    public T deleteFirst() {
        if(empty()) throw new RuntimeException("nichts da");
        T r = h[0];
        if(h.length == 1) h = null;
        else {
            h[0] = h[h.length - 1];
            T[] h2 = copyOf(h, h.length - 1);
            sift(h2);
            h = h2;
        }
        return r;
    }

    /**
     * lässt das erste Element eines Arrays/Heaps runtersickern
     * @param h Array/Heap
     */
    private void sift(T[] h) {
        if (!empty()) {
            int i = 0;
            int j = 1;
            T x = h[0];
            if ((j < h.length - 1) && (comparen(h[j], h[j + 1]) > 0)) j++;
            while ((j <= h.length - 1) && (comparen(x, h[j]) > 0)) {
                h[i] = h[j];
                i = j;
                j = 2 * i + 1;
                if ((j < h.length - 1) && (comparen(h[j], h[j + 1]) > 0)) j++;
            }
            h[i] = x;
        }
    }

    /**
     * @param e1 Element 1
     * @param e2 Element 2
     * @return Returns a negative integer, zero, or a positive integer
     * as the first argument is less than, equal to, or greater than the second.
     */
    private int comparen(T e1, T e2) {
        if(comparator == null) {
            if(!((e1 instanceof Comparable) && (e2 instanceof Comparable))) throw new RuntimeException("nicht Comparable");
            return ((Comparable) e1).compareTo((Comparable) e2);
        }
        return comparator.compare(e1, e2);
    }

    /**
     * erstellt einen neuen Array wo das übergebene Element an erster Stelle steht und
     * danach alle Elemente aus dem Originalarray kommen
     * @param h Originalarray
     * @param e Element
     * @return neuer Array
     */
    private T[] kopieplus(T[] h, T e) {
        T[] h2 = new T[h.length + 1];
        h2[0] = e;
        for (int i = 1; i < h2.length; i++) {
            h2[i] = h[i-1];
        }
    }

}
