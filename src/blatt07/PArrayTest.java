package blatt07;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.File;

/**
 * Created by Ronja on 11.06.17.
 */
public class PArrayTest {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        //Konstruktor mit Array
        PersistentArray p2 = new PersistentArray(array,"a");

        //Konstruktor ohne Array
        PersistentArray p = new PersistentArray("a");

        //returnElement() & richtiges Array
        if(p.returnElement() != 1) System.out.println("Fehler beim Zugriff auf Array");
        if(p.returnElement() != 2) System.out.println("Fehler beim Zugriff auf Array");
        if(p.returnElement() != 3) System.out.println("Fehler beim Zugriff auf Array");
        boolean Fehler = false;
        try{
            p.returnElement();
        } catch(NoSuchElementException n) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung wenn am Ende des Arrays returnElement aufgerufen wird");

        //returnElement mit Positon
        if(p.returnElement(2) != 3) System.out.println("Fehler bei returnElement mit Position");
        Fehler = false;
        try{
            p.returnElement(3);
        } catch(NoSuchElementException n) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung wenn returnElement mit zu hoher Position aufgerufen wird");
        Fehler = false;
        try{
            p.returnElement(-1);
        } catch(IllegalArgumentException i) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung bei returnElement mit negativer Position");

        //eintraegeAnzahl()
        if(p.eintraegeAnzahl() != 3) System.out.println("Falsche Anzahl der Einträge");

        //goTo()
        p.goTo(2);
        if(p.returnElement()!= 3) System.out.println("Fehler bei goTo");
        Fehler = false;
        try{
            p.goTo(4);
        } catch(NoSuchElementException n) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung bei goTo zu zu großer Position");
        Fehler = false;
        try{
            p.goTo(-1);
        } catch(IllegalArgumentException i) {
            Fehler = true;
        }
        if(!Fehler)System.out.println("Kein Fehler bei goTo mit negativer Position");

        //reset()
        p.reset();
        if(p.returnElement()!=1)System.out.println("Fehler bei reset");

        //ende()
        if(p.ende()) System.out.println("Fehler bei ende wenn nicht am Ende");
        p.goTo(3);
        if(!p.ende()) System.out.println("Fehler bei ende wenn am Ende");

        //advance()
        p.goTo(1);
        p.advance();
        if(p.returnElement()!=3)System.out.println("Fehler bei advance");
        Fehler = false;
        try{
            p.advance();
        } catch(NoSuchElementException n) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung wenn advance nach Ende");

        //veraendern()
        p.reset();
        p.veraendern(5);
        if(p.returnElement(0)!=5)System.out.println("Fehler beim verändern ohne Position");
        p.veraendern(1,7);
        if(p.returnElement(1)!=7)System.out.println("Fehler beim verändern mit Position");

        //alte Datei überschreiben
        int[] array2 = {10,20};
        PersistentArray p3 = new PersistentArray(array2, "a");
        if(p3.returnElement()!=10)System.out.println("Fehler: Datei wird nicht überschrieben");
        Fehler = false;
        try{
            PersistentArray p4 = new PersistentArray("b");
        } catch(IllegalArgumentException e){
            Fehler = true;
        }
        if(!Fehler) System.out.println("Keine Fehlermeldung beim wiederherstellen von Arrays mit falschem Namen");
        Fehler = false;
        try {
            p3.close();
        } catch (IOException e) {
            Fehler = true;
        }

        //close()
        if(Fehler) System.out.println("Fehler beim Schließen");
        Fehler = false;
        try{
            p3.advance();
        } catch(RuntimeException r) {
            Fehler = true;
        }
        if(!Fehler) System.out.println("Fehler beim Schließen");

        System.out.println("Test abgeschlossen");
    }
}
