/**
 * Ein Rechteck, das mit zwei Objekten vom Typ Point2D erzeugt werden kann.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 02.05.17
 */
public class Rectangle extends Geometry{

    private Point2D eins;
    private Point2D zwei;

    public Point2D getEins() {
        return eins;
    }

    public Point2D getZwei() {
        return zwei;
    }

    public Rectangle(Point2D eins, Point2D zwei) {
        super(2);
        this.eins = eins;
        this.zwei = zwei;
    }

    @Override
    public double volume() {
        return Math.abs((eins.getX() - zwei.getX()) * (eins.getY() - zwei.getY()));
    }

    @Override
    public Geometry encapsulate(Geometry var1) {
        return null;
    }
}
