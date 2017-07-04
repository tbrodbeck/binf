
package blatt10;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Implementieren Sie die graﬁsche Oberﬂäche für Ihr Spiel unter der Verwendung von Swing-Komponenten. Verknüpfen Sie die
 * jeweiligen Komponenten wenn nötig mit dem Model, in dem Sie das Interface java.util.Observer implementieren. Ist ein Spiel
 * beendet, soll der Benutzer über einen Dialog darüber benachrichtig werden, ob er gewonnen oder verloren hat. Ein laufendes
 * Spiel könnte beispielsweise wie in der Abbildung unten aussehen.
 *
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSView extends JPanel implements Observer {

    private JPanel feld;
    private JLabel nachricht;
    private MSModel model;
    private final String bombenAnzeige = "Anzahl der übrigen Bomben: " ;

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
                feld.add(new FeldView(this,felder[i][j]));
            }

         this.nachricht.setText(bombenAnzeige
                     + model.getAnzahlBomben());
         this.add(this.nachricht, BorderLayout.NORTH);
         this.add(this.feld, BorderLayout.CENTER);

         model.addObserver( this );
         }



    }

    /**
     * obige Anzeige ändern und Benachrichtigung, wenn Spiel vorbei
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        if(model.getZustand() == 1)
            JOptionPane.showMessageDialog(this.getParent(), "Sie haben gewonnen", "Spiel vorbei!", JOptionPane.INFORMATION_MESSAGE);
        else if (model.getZustand() == -1)
            JOptionPane.showMessageDialog(this.getParent(), "Sie haben verloren", "Spiel vorbei!", JOptionPane.INFORMATION_MESSAGE);
        else
            nachricht.setText(bombenAnzeige
                    + (model.getAnzahlBomben() - model.getAnzahlFlaggen()));

    }
}
