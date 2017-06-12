package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class Dateisystem {

    private File wurzeldatei;

    public Dateisystem(String verzeichnissname) {
        wurzeldatei = new File(verzeichnissname);
    }

    public void accept(DateisystemVisitor v) {
        System.out.println("+ " + wurzeldatei.getName());
        durchlaufen(wurzeldatei,v);
    }

    private void durchlaufen(File f, DateisystemVisitor v){
        if(!f.isDirectory()) throw new IllegalArgumentException("nur eine Directory kann durchlaufen werden");
        File[] files = f.listFiles();
        for (File unterfile : files) {
            if (unterfile.isFile()) v.visitFile(unterfile);
            if (unterfile.isDirectory()) {
                if (v.visitDirectory(unterfile)) durchlaufen(unterfile, v);
                v.aufraeumen();
            }
        }
    }

}

