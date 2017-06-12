package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class AllOrNoneDateisystemVisitor implements DateisystemVisitor{
    boolean rekursiv;
    int einrueckung;

    public AllOrNoneDateisystemVisitor(boolean rekursiv) {
        this.rekursiv = rekursiv;
        einrueckung = 0;
    }


    @Override
    /**
     * gibt den Namen einer Datei richtig eingerückt zurück
     * @param f Datei
     */
    public void visitFile(File f) {
        for(int i = 0; i < einrueckung; i++) System.out.print("| ");
        System.out.println(f.getName());
    }

    @Override
    /**
     * gibt den Namen eines Verzeichnisses zurück, gibt zurück ob es rekursiv durchlaufen werden soll und kümmert sich
     * gegebenenfalls um die Einrückung
     * @param f ein Verzeichnis
     * @return ob der Inhalt des Verzeichnisses durchlaufen werden soll
     */
    public boolean visitDirectory(File f) {
        for(int i = 0; i < einrueckung; i++) System.out.print("| ");
        System.out.print("+ ");
        System.out.println(f.getName());
        if(rekursiv) {
            einrueckung++;
            return true;
        }
        return false;
    }

    @Override
    /**
     * setzt die Einrückungen zurück
     * @return true
     */
    public boolean aufraeumen() {
        einrueckung--;
        return true;
    }
}
