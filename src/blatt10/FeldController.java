
package blatt10;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controller eines Feldes
 *
 * Created by Ronja on 02.07.17.
 */
public class FeldController extends MouseAdapter{

    Feld model;

    public FeldController(Feld model){
        this.model = model;
    }

    /**
     * wird durch rechten/linken Mausklick aufgerufen und verändert Model
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked( e );
        switch (e.getButton()) {
            //Fall Rechtsklick
            case MouseEvent.BUTTON1:
                model.aufdecken();
                break;
            //Fall Linksklick
            case MouseEvent.BUTTON3:
                model.setFlagged(true);
                break;
        }
    }
}
