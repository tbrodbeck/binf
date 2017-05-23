package blatt05;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Ein Heap ist ein binärer Baum, der bis zur vorletzten Ebene voll besetzt ist. Auf der Blatt-Ebene ist er von
 * links beginnend bis zum letzten Element vollständig besetzt. Jeder Knoten eines Heaps enthält einen
 * Schlüssel. Der Schlüssel eines Knotens ist kleiner oder gleich der Schlüssel seiner Kind-Knoten.
 *
 * Implementieren Sie einen typsicheren Heap.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class Heap<T extends Comparable>{

    private T[] h;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        //h = new T[0];
    }

//    public Heap() {
//        h = new T[0];
//    }

    public void insert(T e) {
    }

    public boolean empty() {
        return (h.length == 0);
    }

//    public T returnFirst(){
//
//    }

    public T deleteFirst() {
        return null;
    }
}
