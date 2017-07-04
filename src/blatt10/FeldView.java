//in sich schlüssig
//musst du wenn es keinen Fehler gibt (glaube ich) nicht mehr benutzen
//wird von MSView verwendet um kleine Panels zu erstellen
package blatt10;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ronja on 02.07.17.
 */
public class FeldView extends JPanel implements Observer {
    private MSView msView;
    private Feld feld;
    private JButton button;
    private JButton flagged;
    private JLabel label;
    private static final String BUTTON = "button";
    private static final String LABEL = "label";


    public FeldView(MSView msView, Feld feld) {
        //gebraucht um MSView zum Observer zu machen damit Spiel verloren werden kann
        this.msView = msView;

        this.feld = feld;
        //Button der dargestellt wird wenn wir einen normalen Button haben
        button = new JButton();
        //Label das dargestellt wird wenn wir aufgedeckt sind
        label = new JLabel();
        label.setHorizontalAlignment( JLabel.CENTER );
        this.setLayout( new CardLayout() );
        this.add( button, BUTTON );
        this.add( label, LABEL );
        feld.addObserver( this );
        label.setPreferredSize( new Dimension( 40, 40 ) );
        if (feld.getBombe()) {
            label.setText( "B" );
        }
        if (feld.getWert() > 0) {
            label.setText( String.valueOf( feld.getWert() ) );
        }
        button.addMouseListener( new FeldController( feld ) );
        //Button der dagestellt wird wenn wir einen flagged Button haben
        flagged = new JButton( "F" );
        flagged.addMouseListener( new FlaggedController( feld ) );
    }

    /**
     * wird aufgerufen wenn auf Button aufgedeckt/geflagged wird
     * verändert den Inhalt des Panels
     *
     * @param o
     * @param arg Feld damit es überprüfen kann ob wir ne Bombe getroffen haben
     */
    @Override
    public void update(Observable o, Object arg) {
        CardLayout layout = (CardLayout) this.getLayout();
        if (this.feld.getAufgedeckt()) {

            int count = this.feld.getWert();

            if (button.isShowing()) {
                layout.show( this, LABEL );
            }

            if (this.feld.getBombe()) {
                label.setText( "B" );
            } else if (count == 0) {
                label.setText( " " );
            } else {
                label.setText( "" + count );
            }

        } else {
            if (label.isShowing()) {
                layout.show( this, BUTTON );
            }
            if (this.feld.getFlagged()) {
                button.setText( "!" );
            } else {
                button.setText( "" );
            }
        }
    }
}