
package blatt10;
import java.util.Observable;
/**
 * Ein Model von einem jedem Feld.
 *
 * Created by Ronja on 02.07.17.
 */
public class Feld extends Observable{
    // codierung: -1: Bombe, sonst Wert von 0-8
    private int wert;
    private boolean aufgedeckt;
    private Feld[] nachbarn;
    private boolean flagged;
    private MSModel model;

    public Feld(MSModel m){
        wert = 0;
        aufgedeckt = false;
        flagged = false;
        model = m;
    }


    public void setBombe(){
        wert = -1;
    }

    /**
     * Flagge setzen oder entfernen
     * @param b
     */
    public void setFlagged(boolean b){
        flagged = !flagged;
        setChanged();
        notifyObservers(this);
        model.flaggenChange( this );
    }

    /**
     * wird bei der Initializierung verwendet,
     * setzt das Attribut Nachbarn und Wert auf richtigen Wert
     * @param nachbarn
     */
    public void setNachbarn(Feld[] nachbarn){
        this.nachbarn = nachbarn;
        if (!this.getBombe())
            calculateWert();
    }

    /**
     * setzt Wert auf die Anzahl der Nachbarn die Bomben sind
     */
    public void calculateWert() {
      for(Feld f: nachbarn) {
          if (f != null && f.getBombe())
            wert++;
      }
    }

    /**
     * macht Objekt aufgedeckt und ruft sich rekursiv für Nachbarn auf
     */
    public void aufdecken(){
        if (!flagged) {
            aufgedeckt = true;
            if (wert == 0) {
                for (Feld f : nachbarn)
                    if (f != null && !f.aufgedeckt && f.wert != -1)
                        f.aufdecken();
            }
            setChanged();
            notifyObservers( this );
            model.feldAufgedeckt( this );
        }
    }

    public boolean getBombe(){
        if(wert ==-1) return true;
        else return false;
    }

    public boolean getAufgedeckt(){
        return aufgedeckt;
    }

    public int getWert(){
        return wert;
    }

    public boolean getFlagged(){
        return flagged;
    }
}
