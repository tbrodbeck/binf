//in sich schlüssig
//musst du wenn es keinen Fehler gibt (glaube ich) nicht mehr benutzen
package blatt10;

import java.awt.event.MouseEvent;

/**
 * Created by Ronja on 02.07.17.
 */
public class FlaggedController extends FeldController {

    public FlaggedController(Feld model) {
        super(model);
    }

    /**
     * wird durch linken Mausklick aufgerufen und verändert Model
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked( e );
        if(e.getButton() == MouseEvent.BUTTON3) {
            model.setFlagged(false);
        }
    }
}
