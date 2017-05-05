/**
 * Schreiben Sie außerdem eine separate Testklasse, die automatisch jede der implementierten Funktionen testet.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 03.05.17
 */
public class GeometryTest {

    public static void main(String[] args) {

        Point p = new Point( 5, 6, 7 );
        Point p2 = new Point( 0, 0, 0 );
        Point2D p2d = new Point2D( 1,1 );
        Rectangle r = new Rectangle( p2d, new Point( -2, 8));
        Rectangle p_p2 = new Rectangle( p, p2);
        Volume v = new Volume( new Point( 4,5,6 ), p, p );

        Geometry encaps = p.encapsulate( p2 );

        if (p.volume() != 0)
            System.out.println("Fehler1");
        if (p2d.volume() != 0)
            System.out.println("Fehler2");
        if (r.volume() != Math.abs( 1-(-2) ) * Math.abs( 1 - 8 ))
            System.out.println("Fehler3");
        if (v.volume() != Math.abs( 4 - 5 ) * Math.abs( 5 - 6 ) * Math.abs( 6 - 7 ))
            System.out.println("Fehler4");
        if (((Rectangle)encaps).getPoints())
            System.out.println("Fehler5");

//        System.out.println(p);
//        System.out.println(p2d);
//        System.out.println(v);
////        System.out.println(r);
//        System.out.println(v.volume());
//        System.out.println(v2.volume());
//        System.out.println(v3.volume());
//        System.out.println( Math.abs( 4 - 5 ) * Math.abs( 5 - 6 ) * Math.abs( 6 - 7 ));
//        System.out.println(v.volume());
    }

}
