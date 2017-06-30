package blatt10;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSView extends JPanel implements Observer{

    JComponent[][] felder;
    MSModel model;

    public MSView(MSModel model) {

        this.model = model;
        this.model.addObserver(this);

        int[][] field = model.getField();
        int hoehe = model.getHoehe();
        int breite = model.getBreite();

        this.setLayout(new GridLayout(hoehe,breite));

        System.out.println(model.getHoehe());
        System.out.println(model.getBreite());

        this.felder = new JComponent[hoehe][breite];

        for (int i = 0; i < hoehe ; i++) {
            JPanel row = new JPanel(  );
            for (int j = 0; j < breite; j++) {
                this.felder[i][j] = new JButton();
                this.felder[i][j].addMouseListener( new MSController() );
                this.add( this.felder[i][j] );
            }
        }



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

    }
}
