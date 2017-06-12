package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public interface DateisystemVisitor {

    /**
     * gibt den Namen einer Datei an der richtigen Stelle zurück
     * @param f Datei
     */
    public void visitFile(File f);

    /**
     * gibt den Namen eines Verzeichnisses zurück, regelt ob es weiter durchlaufen werden soll und kümmert sich
     * gegebenenfalls um die Einrückung
     * @param f ein Verzeichniss
     * @return ob der Inhalt des Verzeichnisses durchlaufen werden soll
     */
    public boolean visitDirectory(File f);

    /**
     * setzt die Einrückungen zurück
     * @return ob die Datei weiter durchlaufen werden soll
     */
    public boolean aufraeumen();
}
