package blatt08;

/**
 * Testen Sie Ihre Implementation ausführlich mit einem automatisierten Testprogramm. Wie
 * viele Testfälle müssen Sie mindestens erzeugen, um alle möglichen Eingaben hinsichtlich
 * einer korrekten Ausgabe geprüft zu haben? Wenn Sie separate Hilfs-Methoden implementieren,
 * sollten Sie diese ebenfalls testen.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 19.06.17
 */
public class ArenaTest {
    public static void main(String[] args) {
        Arena a = new Arena();

        // outside of Arena?
        assert a.getArea( 3,3 ) == -1 : "outside";

        // special cases:
        assert a.getArea( 0,0 ) == -1 : "Mitte";
        assert a.getArea( 0,3 ) == 1  : "1";
        assert a.getArea(0, -3  ) == 7 : "7";
        assert a.getArea( 1.0,0 ) == 3 : "3";
        assert a.getArea( -1.0,0 ) == 9 : "9";

        // Alle Viertel testen:
        assert a.getArea( 2,2 ) == 2 : "oben-rechts";
        assert a.getArea( 1.5, -0.5 ) == 4 : "unten-rechts";
        assert a.getArea( -0.5, -2 ) == 7 : "unten-links";
        assert a.getArea( -2.5,0.5 ) == 10 : "oben-links";

        System.out.println("Test erfolgreich beendet.");
    }
}
