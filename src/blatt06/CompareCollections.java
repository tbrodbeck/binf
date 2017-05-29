package blatt06;

import java.security.InvalidParameterException;
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

        System.out.println("Durchschnittslaufzeit von Methoden:\n");

        // dafür erstellen wir 100000 Objekte in einem Array
        Object[] arr = new Object[100000];
        for (Object o: arr) {
            o = new Object();
        }
        Integer[] arr2 = new Integer[100000];

        int count = 0;
        for (Integer i: arr2) {
            i = count++;
        }

        // Test
        compareAdd( l, arr );
        compareContains( l, arr );
        compareRemove( l, arr );
        compareAdd( l, arr2 );
        compareContains( l, arr2 );
        compareRemove( l, arr2 );
    }

    // adds a Objectarray to a List of Collections
    private static void compareAdd(List<Collection> l, Object[] arr) {
        if (arr.length == 0)
            throw new InvalidParameterException(  );
        System.out.println("add " + arr.getClass());
        for (Collection c: l ) {
            for (int i = 0; i < 1000; i++)
                c.add( arr[i] );
            System.out.println(c.getClass() );
            long start = System.nanoTime();
            //wird 100000x ausgeführt und Mittelwert errechnet
            for (int i = 1000; i < 100000; i++)
                c.add( arr[i] );
            System.out.println( (System.nanoTime() - start) / (100000.0 - 1000.0));
        }
        System.out.println();
    }

    // calls contain of Objects a List of Collections
    private static void compareContains(List<Collection> l, Object[] arr) {
        System.out.println("contains " + arr.getClass());
        for (Collection c: l ) {
            for (int i = 0; i < 1000; i++)
                c.contains( arr[i] );
            System.out.println(c.getClass());
            long start = System.nanoTime();
            //wird 100000x ausgeführt und Mittelwert errechnet
            for (int i = 99999; i >= 1000; i--)
                c.contains(arr[i]);
            System.out.println((System.nanoTime() - start)/(100000.0 -1000.0)  );
        }
        System.out.println();
    }

    // removes contains of an Object on a list of collections
    private static void compareRemove(List<Collection> l, Object[] arr) {
        System.out.println("remove " + arr.getClass());
        for (Collection c: l ) {
            for (int i = 0; i < 1000; i++)
                c.remove( arr[i] );
            System.out.println(c.getClass() );
            long start = System.nanoTime();
            //wird 100000x ausgeführt und Mittelwert errechnet
            for (int i = 99999; i >= 1000; i--)
                c.remove( arr[i] );
            System.out.println( (System.nanoTime() - start) / (100000.0 - 1000.0) );
        }
        System.out.println();
    }
}
