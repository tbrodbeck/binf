package blatt08;

import java.io.*;

/**
 * Schreiben Sie anschließend eine Testklasse, in deren main-Methode Sie einen Beispiel-Heap
 * erzeugen, serialisieren und in eine Datei schreiben, um ihn anschließend wieder aus der
 * Datei auszulesen und zu deserialisieren. Lassen Sie die Testklasse automatisiert
 * vergleichen, ob der Heap, den sie serialisieren, der gleiche ist, wie der, den Sie
 * deserialisieren.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 20.06.17
 */
public class HeapTest {
    public static void main(String[] args) {

        Heap<Integer> h = new Heap<>();
        Heap<Integer> h2 = null;

        for (int i = 0; i<=10000; i++)
            h.insert( i );

        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("lib/Heap.ser"));){
            o.writeObject(h);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream( "lib/Heap.ser" ))) {
            h2 = (Heap<Integer>) is.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i<=10000; i++) {
            assert h.getFirst().equals( h2.getFirst() ) : "fail on " + i;
            h.deleteFirst();
            h2.deleteFirst();
        }

        assert h.empty() : "h not empty";
        assert h2.empty() : "h2 not empty";

        System.out.println("Test beendet.");
    }
}
