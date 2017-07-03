package blatt10;


import java.util.Random;

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
public class MSModel {

    private int hoehe;
    private int breite;
    private Feld[][] felder;

    public MSModel(int hoehe, int breite, int bomben) {
        if(hoehe < 0||breite < 0|| bomben <0 || bomben >= breite * hoehe) throw new IllegalArgumentException("Die Werte müssen positiv sein");
        this.hoehe = hoehe;
        this.breite = breite;
        felder = new Feld[hoehe][breite];
        initialize(bomben, felder);
    }

    /**
     * Startposition zufällig erstellen
     * @param bomben Anzahl der Bomben
     * @param felder Spielfeld
     */
    private void initialize(int bomben, Feld[][] felder) {

        // Felder erstellen
        for (int i = 0; i < hoehe; i++) {
            for (int j = 0; j < breite; j++) {
                felder[i][j] = new Feld();
            }
        }

        //Bomben einfügen
        Random random = new Random();
        for (int b = 1; b < bomben; b++) {
            int i = random.nextInt( hoehe - 1 );
            int j = random.nextInt( breite - 1 );
            //wenn es da schon ne Bombe gibt zähle nicht hoch
            if (felder[i][j].getBombe())
                b--;
            else
                felder[i][j].setBombe();
        }

        // Nachbaren initialisieren
        for (int i = 0; i < hoehe; i++) {
            for (int j = 0; j < breite; j++) {
                felder[i][j].setNachbarn( listNachbaren( i, j ) );
            }
        }

    }

    /**
     * Nachbaren eines Feldes auflisten
     * @param i
     * @param j
     * @return Liste der Nachbaren
     */
    private Feld[] listNachbaren(int i, int j){
        Feld[] list = new Feld[8];
        list[0] = getEintrag(i-1, j-1);
        list[1] = getEintrag(i-1, j);
        list[2] = getEintrag(i-1, j+1);
        list[3] = getEintrag(i, j-1);
        list[4] = getEintrag(i, j+1);
        list[5] = getEintrag(i+1, j-1);
        list[6] = getEintrag(i+1, j);
        list[7] = getEintrag(i+1, j+1);
        return list;
    }

    /**
     * Feld aus Spielfeld
     * @param i
     * @param j
     * @return Feld oder null
     */
    private Feld getEintrag(int i, int j) {
        if (i>=0 && j>=0 && i<hoehe && j<breite) {
            return felder[i][j];
        }
        else return null;
    }

    /**public void aufdecken(int i, int j) {
        if(i>=0 && j>=0 && i<hoehe && j<breite) {
            aufgedeckt[i][j] = true;
            if (field[i][j] == -1) verloren = true;
            if (field[i][j] == 0) {
                aufdecken(i - 1, j - 1);
                aufdecken(i - 1, j);
                aufdecken(i - 1, j + 1);
                aufdecken(i, j - 1);
                aufdecken(i, j + 1);
                aufdecken(i + 1, j - 1);
                aufdecken(i + 1, j);
                aufdecken(i + 1, j + 1);
            }
        }
    }*/

    public Feld[][] getFelder() {
        return felder;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

}
