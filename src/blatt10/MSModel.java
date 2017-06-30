package blatt10;

import java.util.Observable;

/**
 * Entwerfen Sie Klassen zur Repräsentation der Spiellogik.
 * Das Spiel selber als auch alle darin enthaltenen Felder
 * sollten durch eigene Objekte dargestellt werden können.
 * Achten Sie darauf, dass solche Klassen, die später mit
 * der View kommunizieren sollen, vom Typ
 * java.util.Observable sind.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSModel extends Observable{

    private int hoehe;
    private int breite;
    private int bomben;

    public MSModel(int hoehe, int breite, int bomben) {
        this.hoehe = hoehe;
        this.breite = breite;
        this.bomben = bomben;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
