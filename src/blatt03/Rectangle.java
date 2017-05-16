package blatt03;

/**
 * Ein Rechteck, das mit zwei Objekten vom Typ Point2D erzeugt werden kann.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 02.05.17
 */
public class Rectangle extends Volume {

    public Rectangle(Point p1, Point p2){
        super(p1,p2);
        if(p1.dimensions() != 2)
            throw new RuntimeException( "Punkte sind nicht zweidimensional" );
    }
}
