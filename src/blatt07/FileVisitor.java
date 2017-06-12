package blatt07;

/**
 * Created by Ronja on 11.06.17.
 */
package io;
import java.io.File;
import java.util.Arrays;
public class FileSystem {

    private final File rootPath;

    public FileSystem(File rootPath) {
        this.rootPath = rootPath;
    }

    public void accept(FileVisitor v) {
        walkFile(rootPath, v);
    }

    private FileVisitResult walkFile(File currentFile, FileVisitor v) {
        if (currentFile.isDirectory()) {
            FileVisitResult response = v.preVisitDirectory(currentFile);
            switch (response) {
                case CONTINUE:
                    File[] files = currentFile.listFiles();
                    Arrays.sort(files);
                    for (File f : files) {
                        if (walkFile(f, v) == FileVisitResult.TERMINATE) {
                            return FileVisitResult.TERMINATE;
                        }
                    }
                response = v.postVisitDirectory(currentFile);
                case SKIP_SUBTREE: case TERMINATE: default:
                    return response;
            }
        } else {
            return v.visitFile(currentFile);
        }
    }
}

package io;
import java.io.File;

public interface FileVisitor {
    public FileVisitResult postVisitDirectory(File dir);

    public FileVisitResult preVisitDirectory(File dir);

    public FileVisitResult visitFailed(File dir);

    public FileVisitResult visitFile(File file);
}

package io;
import java.io.File;

public enum FileVisitResult {
    CONTINUE,
    SKIP_SUBTREE,
    TERMINATE;
}


package io;
import java.io.File;

public class List {
    public static void main(String[] args) {
        boolean recursive = false;
        boolean argumentsRead = false;
        int i =0;
        while (!argumentsRead && i < args.length) {
            switch (args[i]) {
                case "-r":
                    recursive = true;
                    i++;
                    break;
                default:
                    argumentsRead = true;
                    break;
            }
        }
        String dir;
        if (i==args.length) {
            dir = ".";
        } else {
            dir = args[i];
        }
        System.out.println("Listing " + dir);
        File f = new File(dir);
        if (!f.exists()) {
            System.out.println("...does not exist");
        } else {
            new FileSystem(f).accept(new DoList(f, recursive));
        }
    }

private static class DoList implements FileVisitor {
    private StringBuffer indent = new StringBuffer();
    private boolean recursive;
    private File root;
    private DoList(File root, boolean recursive) {
        this.recursive = recursive;
        this.root = root;
    }
    @Override
    public FileVisitResult postVisitDirectory(File dir) {
        indent = indent.delete(indent.length() - 2, indent.length());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(File dir) {
        System.out.println(indent + "+ " + dir.getName());
        if (recursive || this.root.equals(dir)) { indent.append("| ");
            return FileVisitResult.CONTINUE;
        } else{
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    @Override
    public FileVisitResult visitFailed(File file) {
        System.out.print(indent); System.out.println(file.getName() + " (unreadable) ");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(File file) {
        System.out.print(indent);
        System.out.println(file.getName());
        return FileVisitResult.CONTINUE;
    }
}
