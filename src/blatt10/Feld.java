//in sich schlüssig
//Instanzen müssen erstellt  werden und mit setNachbarn Nachbarn übergeben bekommen damit es funktioniert
package blatt10;
import java.util.Observable;
/**
 * Created by Ronja on 02.07.17.
 */
public class Feld extends Observable{
    private int wert;
    private boolean aufgedeckt;
    private Feld[] nachbarn;
    private boolean flagged;

    public Feld(){
        wert = 0;
        aufgedeckt = false;
        flagged = false;
    }


    public void makeBombe(){
        wert = -1;
    }

    public void setFlagged(boolean b){
        flagged = true;
        setChanged();
        notifyObservers(this);
    }

    /**
     * wird bei der Initializierung verwendet,
     * setzt das Attribut Nachbarn und Wert auf richtigen Wert
     * @param nachbarn
     */
    public void setNachbarn(Feld[] nachbarn){
        this.nachbarn = nachbarn;
        calculateWert();
    }

    /**
     * setzt Wert auf die Anzahl der Nachbarn die Bomben sind
     */
    public void calculateWert() {
      for(Feld f: nachbarn) {
          if (f.getBombe()) wert++;
      }
    }

    /**
     * macht Objekt aufgedeckt und ruft sich rekursiv für Nachbarn auf
     */
    public void aufdecken(){
        aufgedeckt = true;
        if(wert == 0) {
            for(Feld f: nachbarn) if(f.wert!=-1) f.aufdecken();
        }
        setChanged();
        notifyObservers(this);
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
