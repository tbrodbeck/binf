package blatt08;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Ronja on 17.06.17.
 */
public class Search {
    public static void main(String[] args) {
        boolean rekursiv = false;
        String search = null;
        String replace = null;
        String verzeichnis = null;
        //wenn zuerst r kommt
        if ((args[0]).equals("-r")) {
            rekursiv = true;
            search = args[1];
            replace = args[2];
            verzeichnis = args[3];
        }
        else {
            search = args[0];
            replace = args[1];
            verzeichnis = args[2];
        }
        //Visitable und Visitor inizialisieren
        File f = new File(verzeichnis);
        FileSystem fs = new FileSystem(f);
        Pattern p = Pattern.compile(search);
        ReplaceVisitor v = new ReplaceVisitor(f, rekursiv, p, replace);
        fs.accept(v);
    }
}
