//in sich schlüssig
//musst du wenn es keinen Fehler gibt (glaube ich) nicht mehr benutzen
//wird von MSView verwendet um kleine Panels zu erstellen
package blatt10;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ronja on 02.07.17.
 */
public class FeldView extends Observable implements Observer{
    private MSView msView;
    private Feld model;
    private JPanel panel;
    private JButton button;
    private JButton flagged;
    private JLabel label;



    public FeldView(MSView msView,Feld model) {
        //gebraucht um MSView zum Observer zu machen damit Spiel verloren werden kann
        this.msView = msView;
        this.addObserver(msView);
        this.model = model;
        //Button der dargestellt wird wenn wir einen normalen Button haben
        button = new JButton();
        //Label das dargestellt wird wenn wir aufgedeckt sind
        label = new JLabel();
        if(model.getBombe()) {
            label.setText("B");
        }
        if(model.getWert() > 0) {
            label.setText(String.valueOf(model.getWert()));
        }
        button.addMouseListener(new FeldController(model));
        //Button der dagestellt wird wenn wir einen flagged Button haben
        flagged = new JButton("F");
        flagged.addMouseListener(new FlaggedController(model));
        darstellen();
    }

    /**
     * wird aufgerufen wenn auf Button aufgedeckt/geflagged wird
     * verändert den Inhalt des Panels
     * @param o
     * @param arg Feld damit es überprüfen kann ob wir ne Bombe getroffen haben
     */
    @Override
    public void update(Observable o, Object arg) {
        darstellen();
        //wenn verloren wird MSView notified
        if(((Feld)arg).getBombe())  {
            setChanged();
            notifyObservers();
        }
    }

    /**
     * neues JPanel erstellen das aktuellem Zustand entsprechend richtige Component enhält
     */
    public void darstellen(){
        //neues Panel erstellen
        panel = new JPanel();
        //Fall nicht aufgedekct
        if(!model.getAufgedeckt()){
            //Fall flagged
            if(model.getFlagged()) {
               panel.add(flagged);
            }
            //Fall nicht flagged
            else panel.add(button);
        }
        //Fall aufgedeckt
        else{
            panel.add(label);
        }
    }

    public JPanel getPanel(){
        return this.panel;
    }
}
