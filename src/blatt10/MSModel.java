package blatt10;

import java.util.Observable;
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
public class MSModel extends Observable{

    private int hoehe;
    private int breite;
    //private int bomben;
    private int[][] field;
    private boolean[][] aufgedeckt;
    private boolean verloren;

    public MSModel(int hoehe, int breite, int bomben) {
        if(hoehe < 0||breite < 0|| bomben <0) throw new IllegalArgumentException("Die Werte müssen positiv sein");
        this.hoehe = hoehe;
        this.breite = breite;
        //this.bomben = bomben;
        aufgedeckt = new boolean[hoehe][breite];
        field = new int[hoehe][breite];
        initialize(bomben);
    }

    private void initialize(int bomben) {
        //alles auf Null setzen
        for(int i = 0; i < hoehe; i++) {
            for(int j = 0; j < breite; j++){
                field[i][j] = 0;
            }
        }
        Random random = new Random();
        //Bomben einfügen
        for(int i = 1; i<bomben; i++) {
            int k = random.nextInt(hoehe-1);
            int l = random.nextInt(breite-1);
            //wenn es da schon ne Bombe gibt zähle nicht hoch
            if (field[k][l] == -1) i--;
            else {
                field[k][l] = -1;
                updateNeighbours(k,l);
            }
        }
    }

    private void updateNeighbours(int i, int j){
        hochzaehlen(i-1, j-1);
        hochzaehlen(i-1, j);
        hochzaehlen(i-1, j+1);
        hochzaehlen(i, j-1);
        hochzaehlen(i, j+1);
        hochzaehlen(i+1, j-1);
        hochzaehlen(i+1, j);
        hochzaehlen(i+1, j+1);
    }

    private void hochzaehlen(int i, int j){
        if(i>=0 && j>=0 && i<hoehe && j<breite) {
            int k = field[i][j];
            field[i][j] = k + 1;
        }
    }

    public void aufdecken(int i, int j) {
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
    }
    public int[][] getField() {
        return field;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean getVerloren(){
        return verloren;
    }

    public static void main(String[] args) {
        //MSModel example = new MSModel(3,3,3);
    }
}
