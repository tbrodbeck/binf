package blatt07;

import java.io.File;


/**
 * Created by Ronja on 12.06.17.
 * Entwickeln Sie dazu zunächst eine Klasse, die das Dateisystem ab einer bestimmten Wurzel-Datei bzw. einem
 * -Verzeichnis repräsentiert.
 */
public class Dateisystem {

    private File wurzeldatei;

    public Dateisystem(String verzeichnissname) {
        wurzeldatei = new File(verzeichnissname);
    }

    /**
     * Ein jedes solches Dateisystem soll mit einem von Ihnen definierten Visitor besucht werden können
     * @param v
     */
    public void accept(DateisystemVisitor v) {
        System.out.println("+ " + wurzeldatei.getName());
        durchlaufen(wurzeldatei,v);
    }

    /**
     * Beruht das Dateisystem auf einem Verzeichnis, würde ein Visitor alle Dateien in diesem und in all seinen
     * Unterverzeichnissen, jeweils in Form einer File- Instanz, rekursiv vorgeführt bekommen.
     * @param f
     * @param v
     */
    private void durchlaufen(File f, DateisystemVisitor v){
        File[] files = f.listFiles();
        for (File unterfile : files) {
            if (unterfile.isFile()) v.visitFile(unterfile);
            if (unterfile.isDirectory()) {
                if (v.visitDirectory(unterfile)) {
                    durchlaufen(unterfile, v);
                    v.aufraeumen();
                }
            }
        }
    }

}

