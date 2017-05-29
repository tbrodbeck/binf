package blatt06;

import java.util.*;

/**
 * Aufgabe 6.3: Vergleich von Java Collections (25 Punkte)
 *
 * Beurteilen Sie welche der Collection-Implementationen java.util.LinkedList,
 * java.util.ArrayList und java.util.HashSet hinsichtlich der Methoden add(T)
 * remove(T) und contains(T) die besten Laufzeiteigenschaften hat. Führen Sie dazu
 * eine rein quantitative Analyse durch.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.05.17
 */
public class CompareCollections {

    private static List<Collection> l = new ArrayList<Collection>(  );

    /**
     * Bilden Sie also durchschnittliche Werte
     * für die Laufzeit der drei Methoden über eine ausreichende Anzahl von Testfällen.
     * Geben Sie die Ergebnisse in einer aussagekräftigen Tabelle aus.
     * Erklären Sie Ihrem Tutor/ Ihrer Tutorin ob und warum die Ergebnisse Ihren Erwartungen entsprechen.
     * Gestalten Sie Ihre Implementation derart, dass möglichst einfach neue Klassen
     * in den Vergleich mit aufgenommen werden können, ohne viel Quellcode duplizieren zu müssen.
     * @param args
     */
    public static void main(String[] args) {

        // zu testende Collections hier einfügen
        l.add( new LinkedList(  ));
        l.add( new ArrayList(  ));
        l.add( new HashSet(  ) );

        System.out.println("Test der Laufzeiteigenschaften:\n");

        // dafür erstellen wir 10 000 Objekte in einem Array
        Object[] arr = new Object[10000];
        for (Object o: arr) {
            o = new Object();
        }

        // Test von add
        System.out.println("-add-");
        for (Collection c: l ) {
            System.out.println(c.getClass() );
            long start = System.nanoTime();
            //wird 10 000x ausgeführt und Mittelwert errechnet
            for (int i = 0; i < 10000; i++)
                c.add( arr[i] );
            System.out.println( (System.nanoTime() - start) / 10000.0 );

        }
        System.out.println();

        // Test von remove
        System.out.println("-remove-");
        for (Collection c: l ) {
            System.out.println(c.getClass() );
            long start = System.nanoTime();
            //wird 10 000x ausgeführt und Mittelwert errechnet
            for (int i = 0; i < 10000; i++)
                c.remove( arr[i] );
            System.out.println( (System.nanoTime() - start) / 10000.0 );
        }
        System.out.println();

        // Test von contains
        System.out.println("-contains-");
        for (Collection c: l ) {
            System.out.println(c.getClass());
            long start = System.nanoTime();
            //wird 10 000x ausgeführt und Mittelwert errechnet
            for (int i = 0; i < 10000; i++)
                c.contains(arr[i]);
            System.out.println((System.nanoTime() - start)/10000.0 );
        }
    }
}
