package blatt07;

import java.io.File;

/**
 * Created by Ronja on 12.06.17.
 */
public class AllOrNoneDateisystemVisitor implements DateisystemVisitor{
    boolean r;
    int einrueckung;

    public AllOrNoneDateisystemVisitor(boolean r) {
        this.r = r;
        einrueckung = 1;
    }


    @Override
    public void visitFile(File f) {
        for(int i = 0; i < einrueckung; i++) System.out.print("| ");
        System.out.println(f.getName());
    }

    @Override
    public boolean visitDirectory(File f) {
        for(int i = 0; i < einrueckung; i++) System.out.print("| ");
        System.out.print("+ ");
        System.out.println(f.getName());
        if(r) {
            einrueckung++;
            return true;
        }
        return false;
    }

    @Override
    public boolean aufrauemen() {
        einrueckung--;
        return true;
    }
}
