package blatt06;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Ronja on 30.05.17.
 */
public class IteratorTest {

    public static void main(String[] args) {
        MyList<Integer> liste = new MyList<Integer>();
        for(int i = 1; i < 5; i++) {
            liste.add(i);
        }
        Iterator<Integer> iter = liste.iterator();
        //normale Funktion
        if(iter.hasNext() != true) System.out.println("Fehler bei hasNext() (wenn nicht leer)");
        if(iter.next() != 4) System.out.println("Fehler am Anfang");
        if(iter.next() != 3) System.out.println("Fehler bei next()");
        iter.remove();
        if(iter.next() != 2)System.out.println("Fehler beim löschen");
        iter.next();
        if(iter.hasNext() != false) System.out.println("Fehler bei hasNext() (wenn leer)");
        liste.reset();
        if(liste.elem() != 4) System.out.println("Fehler in Orignialliste 1");
        liste.advance();
        if(liste.elem() != 2) System.out.println("Fehler in Orignialliste 2 (an falscher Stelle gelöscht)");
        liste.advance();
        if(liste.elem() != 1) System.out.println("Fehler in Orignialliste 3");
        //Fehlermeldungen
        //ConcurrentModificationException bei löschen aus Liste und next
        iter = liste.iterator();
        liste.reset();
        liste.delete();
        boolean fehler = false;
        try{
            iter.next();
        } catch(ConcurrentModificationException c) {
            fehler = true;
        }
        if(!fehler) System.out.println("Fehler: keine ConcurrentModificationException bei löschen aus Liste und next");
        //ConcurrentModificationException bei löschen aus Liste und remove
        iter = liste.iterator();
        liste.reset();
        liste.delete();
        fehler = false;
        try{
            iter.remove();
        } catch(ConcurrentModificationException e) {
            fehler = true;
        }
        if(!fehler) System.out.println("Fehler: keine ConcurrentModificationException bei löschen aus Liste und remove");
        //IllegalStateException bei 2mal removen
        liste.add(2);
        liste.add(3);
        iter = liste.iterator();
        iter.next();
        iter.next();
        iter.remove();
        fehler = false;
        try{
            iter.remove();
        } catch(IllegalStateException e) {
            fehler = true;
        }
        if(!fehler) System.out.println("Fehler: keine IllegalStateException bei 2mal removen");
        //NoSuchElementException bei zu oft next
        iter = liste.iterator();
        iter.next();
        iter.next();
        fehler = false;
        try{
            iter.next();
        } catch(NoSuchElementException e) {
            fehler = true;
        }
        if(!fehler) System.out.println("Fehler: keine NoSuchElementException bei zu oft next");
        System.out.println("Test abgeschlossen");
    }
}
