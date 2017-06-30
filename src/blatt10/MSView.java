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

    JButton[][] feld;
    MSModel model;

    public MSView(MSModel model) {

        this.model = model;
        this.model.addObserver(this);

        this.setLayout(new GridLayout());

        int[][] field = model.getField();

        this.feld = new JButton[field.length][field[0].length];

        for (int i = 0; i < field.length ; i++) {
            JPanel row = new JPanel(  );
            for (int j = 0; j < field[i].length; j++) {
                this.feld[i][j] = new JButton();
                this.feld[i][j].addMouseListener( new MSController() );
                row.add(this.feld[i][j]);
            }
            this.add(row);

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


        int[][] dummy = new int[99][99];
        for (int i = 0; i < dummy.length ; i++) {
            for (int j = 0; j < dummy[i].length; j++) {
                this.feld[i][j].setText( "updated");
            }
        }
    }
}
