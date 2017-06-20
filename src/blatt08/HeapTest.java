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

        Heap<Integer> origin = new Heap<>();
        Heap<Integer> copy = null;

        for (int i = 0; i<=10000; i++)
            origin.insert( i );

        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("lib/Heap.ser"));){
            o.writeObject(origin);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream( "lib/Heap.ser" ))) {
            copy = (Heap<Integer>) is.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i<=10000; i++) {
            assert origin.getFirst().equals( copy.getFirst() ) : "fail on " + i;
            origin.deleteFirst();
            copy.deleteFirst();
        }

        assert origin.empty() : "h not empty";
        assert copy.empty() : "h2 not empty";

        System.out.println("Test beendet.");
    }
}
