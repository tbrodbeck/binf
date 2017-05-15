package blatt04;

/**
 * Schreiben Sie anschließend ein Testprogramm, das automatisiert die Funktionalität der Library
 * überprüft.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 16.05.17
 */
public class LibraryTest {

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

}
