package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class Dateisystem{

    private File wurzeldatei;
    public Dateisystem(String verzeichnissname) {
        wurzeldatei = new File(verzeichnissname);
    }

    public void accept(DateiVisitor v) {
        //File[] files = wurzeldatei.listFiles();
        //for(int i = 0; i < files.length; i++) {
          //  if(v.visit(files[i]) = true) {
            //}
        v.visit(wurzeldatei);
    }

}

