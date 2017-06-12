package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class List {
    public static void main(String[] args) {
        //wenn nichts
        boolean rekursiv = false;
        String verzeichnis = " ";
        //wenn zuerst r kommt
        if (args.length > 0) {
            if ((args[0]).equals("-r")) rekursiv = true;
            else {
                //wenn kein r kommt und es ein Element gibt -> Verzeichniss
                if (args.length == 1) verzeichnis = args[0];
            }
            //wenn ein r kommt und es 2 Elemente gibt -> Verzeichniss
            if (args.length == 2) verzeichnis = args[1];
            //Visitable und Visitor inizialisieren
            Dateisystem ds = new Dateisystem(verzeichnis);
            DateisystemVisitor dv = new AllOrNoneDateisystemVisitor(rekursiv);
            ds.accept(dv);
        }
    }
}
