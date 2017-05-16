package blatt04;

import java.util.HashSet;

/**
 * Schreiben Sie anschließend ein Testprogramm, das automatisiert die Funktionalität der Library
 * überprüft.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class LibraryTest {

    public static void main(String[] args) {

        // knwoledge base

        Library lib1 = new Library();
        Library lib2 = new Library();

        BluRay lotr = new BluRay( "Lord Of The Rings",  "Peter Jackson");
        BluRay spotlight = new BluRay( "Spotlight", "Tom McCarthy" );
        BluRay et = new BluRay( "E. T.", "Steven Spielberg" );

        Book lotrB = new Book( "Lord of The Rings", "Tolkiens" );
        Book dedl = new Book( "Die Erfindung des Lebens", "Ortheil" );
        Book hp = new Book( "Harry Potter", "Joanne K. Rowling" );


        // test

        lib1.addItem( lotr );
        lib1.addItem( lotrB );
        lib1.addItem( spotlight );

        lib2.addItem( et );
        lib2.addItem( dedl );
        lib2.addItem( hp );
        lib2.addItem( lotrB );

        // search testen
        List sear1 = lib1.search("Lord Of The Rings");
        if (sear1.empty())
            System.out.println("Fehler0");
        sear1.reset();
        while (!sear1.endpos()) {
            if (!((LibraryItem)sear1.elem()).getDescription().contains( "Lord Of The Rings" ))
                System.out.println("Fehler1");
            sear1.advance();
        }

        // delete testen
        lib1.deleteItem( lotr );
        lib1.deleteItem( lotrB );
        List sear2 = lib1.search("Lord Of The Rings");
        if(!sear2.empty())
            System.out.println("Fehler2");

        // getDescription im Detail
        if (!lotr.getDescription().equals( "BluRay - Title: Lord Of The Rings, Director: Peter Jackson" ))
            System.out.println("Fehler3");
        if (!lotrB.getDescription().equals( "Book - Title: Lord of The Rings, Author: Tolkiens" ))
            System.out.println("Fehler4");

        System.out.println("Test abgeschlossen.");

    }
}
