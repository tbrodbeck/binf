package blatt10;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Ronja von Kittlitz, Tillmann Brodbeck
 * @version 29.06.17
 */
public class MSController extends MouseAdapter{

    private MSModel model;

    public MSController(MSModel m){
        this.model = m;
    }

    /**
     * {@inheritDoc}
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked( e );

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:

                break;
            case MouseEvent.BUTTON3:

                break;
        }
    }
}
