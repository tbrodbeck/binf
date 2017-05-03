/**
 * Schreiben Sie außerdem eine separate Testklasse, die automatisch jede der implementierten Funktionen testet.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 03.05.17
 */
public class GeometryTest {

    public static void main(String[] args) {

        Point p = new Point( 5, 6, 7 );
        Point2D p2d = new Point2D( 1,2 );
        Volume v = new Volume( new Point( 4,5,6 ), p, p );
        Rectangle r = new Rectangle( p2d, new Point( 1,2));

        if (p.volume() != 0)
            System.out.println("Fehler1");
        if (p2d.volume() != 0)
            System.out.println("Fehler2");
        if (r.volume() != 1*1 + 2*2)
            System.out.println("Fehler3");
        System.out.println(r.volume());
        System.out.println(v.volume());
    }

}
