/**
 * Schreiben Sie außerdem eine separate Testklasse, die automatisch jede der implementierten Funktionen testet.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 03.05.17
 */
public class GeometryTest {

    public static void main(String[] args) {

        // 3D Punkte
        Point p3 = new Point( 5, 6, 7 );
        Point p3_2 = new Point( 0, 0, 0 );
        // 2D Punkt
        Point2D p2 = new Point2D( 1, 1 );
        Point2D p2_2 = new Point2D( 5, 5 );


        Rectangle r = new Rectangle( p2, new Point( -2, 8));
        Rectangle r2 = new Rectangle( p2, p2);
        Volume v = new Volume( new Point( 4,5,6 ), p3 );
        Volume v2 = new Volume( p3, p3 );

        // Test volume()
        if (r.volume() != Math.abs( 1-(-2) ) * Math.abs( 1 - 8 ))
            System.out.println("Fehler1");
        if (r2.volume() != 0)
            System.out.println("Fehler2");
        if (v.volume() != Math.abs( 4 - 5 ) * Math.abs( 5 - 6 ) * Math.abs( 6 - 7 ))
            System.out.println("Fehler3");
        if (v2.volume() != 0)
            System.out.println("Fehler4");

        // Test encapsulate() von 2 Punkten
        if (((Volume)(p2.encapsulate( p2_2 ))).compareTo(new Volume( new Point( 1, 5 ), new Point (5, 1) )) != 0)
            System.out.println("Fehler5");
        // Test encapsulate() von Punkt auf Volumen
        if (((Volume)(p3_2.encapsulate( v ))).compareTo(new Volume( p3_2, new Point( 5, 6, 7 ))) != 0)
            System.out.println("Fehler6");
        // Test encapsulate() von Volumen auf Punkt
        if (((Volume)(v.encapsulate( p3_2 ))).compareTo(new Volume( p3_2, new Point( 5, 6, 7 ))) != 0)
            System.out.println("Fehler7");
        if (((Volume)(v.encapsulate( v2))).compareTo(new Volume( p3, new Point( 4, 5, 6))) != 0)
            System.out.println("Fehler8");

        //Test von dimension()
        if (p2.dimensions() != 2)
            System.out.println("Fehler9");
        if (r.dimensions() != 2)
            System.out.println("Fehler10");
        // bei n-dimensionalen Objekten
        for (int dim = 2; dim < 1000; dim++){
            Point pd = new Point(new double[dim]);
            if (pd.dimensions() != dim)
                System.out.println("Fehler_pd_" + dim);
            Volume vd = new Volume( pd, pd );
            if (vd.dimensions() != dim)
                System.out.println("Fehler_vd_" + dim);
        }

    }

}
