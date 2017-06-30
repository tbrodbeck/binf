package blatt10;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSView extends JPanel implements Observer{

    JButton feld;
    JLabel anzahl;
    MSModel model;

    public MSView(MSModel model) {

        this.model = model;
        this.feld = new JButton(  );
        this.feld.addMouseListener( new MSController() );
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        this.anzahl.setText( "Anzahl der Biere" );
    }
}
