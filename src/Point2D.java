/**
 * Ein zweidimensionaler Punkt der mit zwei double - Werten erzeugt werden kann.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 02.05.17
 */
public class Point2D extends Geometry {

    private int x;
    private int y;

    public Point2D(int x, int y) {
        super(2);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override

    public double volume() {
        return 0;
    }

    @Override
    public Geometry encapsulate(Geometry var1) {
        if(this.dimensions() != var1.dimensions())
            return null;
        else
            // if(var1 instanceof )
        // @TODO implementieren
        return null;
    }
}
