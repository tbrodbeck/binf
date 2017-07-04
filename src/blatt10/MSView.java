//weiß nicht ganz ob das mit dem Einfügen so funktioniert wie das soll
//und  ob man das Fesamte auch noch mal Updaten muss wenn eins der FieldViews sich ändert oder ob das dass
//schon automatisch macht
//update methode muss noch geschrieben werden damit man sieht wann das Spiel verloren ist
package blatt10;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSView extends JPanel implements Observer {

    private JPanel feld;
    private JLabel nachricht;
    private MSModel model;

    public MSView(MSModel model) {


        //Panel initializieren
        int hoehe = model.getHoehe();
        int breite = model.getBreite();
        this.model = model;

        setLayout( new BorderLayout( ) );
        feld = new JPanel(  );
        nachricht = new JLabel();
        feld.setLayout(new GridLayout(hoehe, breite));

        Feld[][] felder = model.getFelder();

        //this.panels = new JPanel[hoehe][breite];
        //FieldViews erstellen und einfügen
         for (int i = 0; i < hoehe ; i++) {
         //JPanel row = new JPanel();
            for (int j = 0; j < breite; j++) {
                FeldView fv = new FeldView(this,felder[i][j]);
                felder[i][j].addObserver( fv );
                feld.add(fv.getPanel());
            }
         this.add(this.nachricht, BorderLayout.NORTH);
         this.add(this.feld, BorderLayout.CENTER);

         model.addObserver( this );
         }



    }

    /**
     * change display when game is lost
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}
