package blatt08;

import java.io.*;

/**
 * Created by Ronja on 18.06.17.
 */
public class TextWriter {

    public static void main(String[]args) throws IOException {
        RandomAccessFile r = new RandomAccessFile("/Users/Ronja/IdeaProjects/binf/Text.txt", "rw");
        r.writeChars("one cat, two cats");
    }
}
