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
     * wird vor dem rekursiven Einstieg in ein Verzeichnis aufgerufen, so dass auf Implementierungsebene reagiert
     * werden kann
     * @param f ein Verzeichniss
     * @return ob der Besuch aller Elemente in einem (Unter-)Verzeichnis ausgelassen werden soll
     */
    public boolean visitDirectory(File f);

    /**
     * setzt die Einrückungen zurück
     * Wird aufgerufen nachdem ein Verzeichnis vollständig durchlaufen wurde, so dass auf Implementierungsebene
     * reagiert werden kann.
     * @return ob der Besuch aller weiteren Elemente soll abgebrochen werden soll
     */
    public boolean aufraeumen();
}
