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
 * Die Ordnung der eingefügten Schlüssel-Elemente soll entweder dadurch gegeben sein, dass alle Schlüssel
 * das Interface java.lang.Comparable implementieren oder dass beim Erzeugen eines Heaps ein passender
 * java.util.Comparator mitgegeben wird. Mit Ihrer Implementation sollen beide Varianten abgedeckt werden.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class Heap<T extends Comparable>{

    private Object[] h;
    private Comparator<T> comparator;

    /**
     * Wird der Heap also mit einem Comparator erzeugt, wird die Ordnung anhand dieses Comparator deﬁniert.
     * @param comparator
     */
    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
        h = new Object[0];
    }

    /**
     * Wurde kein Comparator mit angegeben, soll die Heap-Implementation davon ausgehen, das alle
     * eingefügten Instanzen vom Typ Comparable sind.
     */
    public Heap() {
        h = new Object[0];
    }

    /**
     * Mit den Methoden eines Heaps soll man Objekte in einen Heap einfügen,
     * @param e Objekt
     */
    public void insert(T e) {

    }

    public boolean empty() {
        return (h.length == 0);
    }


    /**
     * das kleinste Objekt löschen
     * @return kleinstes Objekt
     */
    public T deleteFirst() {
        return null;
    }


    /**
     * oder das kleinste Objekt ermitteln können.
     * @return kleinstes Objekt
     */
    public T returnFirst(){
        return null;
    }
}
