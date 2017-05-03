/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 03.05.17
 */
public class Volume extends Geometry {

    private Point[] coords;
    
    public Volume(Point... coords) {
        super(coords.length);
        this.coords = coords;
        for (Point p: coords) {
            if ( p.dimensions() != coords.length) 
                throw new RuntimeException("Koordinaten der Punkte stimmen nicht überein.");
        }
    }

    public Point[] getCoords() {
        return coords;
    }
    
    @Override
    public double volume() {
        for (Point p: coords) {
            p.getCoords();
        }
        double x;
        return Math.abs(x);
    }

    @Override
    public Geometry encapsulate(Geometry geometry) {
        return null;
    }
}
