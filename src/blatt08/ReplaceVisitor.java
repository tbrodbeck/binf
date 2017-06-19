package blatt08;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ronja on 17.06.17.
 */
public class ReplaceVisitor implements  FileVisitor {

    private boolean recursive;
    private File root;
    private Pattern search;
    private String replacement;

    public ReplaceVisitor(File root, boolean recursive, Pattern search, String replacement) {
        this.search = search;
        this.replacement = replacement;
        this.recursive = recursive;
        this.root = root;
    }

    @Override
    public FileVisitResult postVisitDirectory(File dir) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(File dir) {
        if (recursive || this.root.equals(dir)) {
            return FileVisitResult.CONTINUE;
        } else {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    @Override
    public FileVisitResult visitFailed(File dir) {
        return null;
    }

    @Override
    public FileVisitResult visitFile(File file) {
        BufferedReader r;
        String nl = System.getProperty("line.separator");
        try {
            r = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
        String text = "";
        String line = null;
        try {
            line = r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            text += (line + nl);
            line = null;
            try {
                line = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Matcher m = search.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, replacement);
        }
        m.appendTail(sb);
        String newText = sb.toString();
        FileWriter w = null;
        file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            w = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            w.write(newText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FileVisitResult.CONTINUE;
    }
}
