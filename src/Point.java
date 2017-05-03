/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 03.05.17
 */
public class Point extends Geometry {

    private double[] coords;

    public Point(double... coords) {
        super(coords.length);
        this.coords = coords;
    }

    public double[] getCoords() {
        return coords;
    }

    @Override
    public double volume() {
        return 0;
    }

    @Override
    public Geometry encapsulate(Geometry var1) {
        return null;
    }
}
