package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class DateiVisitor {

    private int deepth;

    public DateiVisitor(){
        deepth = 0;
    }
    public boolean visit(File f) {
        if(f.isDirectory()) {
            visitDirectory(f);
        }
        if(f.isFile()) visitFile(f);
        return true;
    }
    private void visitFile(File f) {
        for(int i = 0; i < deepth; i++) System.out.print("|  ");
        System.out.println(f.getName());
    }
    private void visitDirectory(File f) {
        for(int i = 0; i < deepth; i++) System.out.print("|  ");
        System.out.print("+  ");
        System.out.println(f.getName());
        deepth++;
        File[] files = f.listFiles();
        for(int i = 0; i < files.length; i++) {
            visit(files[i]);
        }
        deepth--;
    }

}
