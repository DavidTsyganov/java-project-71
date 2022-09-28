package hexlet.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class Utils {
    public static String getFileContent(final String filepath) throws IOException {
        if (filepath == null) {
            throw new NoSuchElementException();
        }
        if (filepath.equals("")) {
            throw new NoSuchElementException();
        }
        Path path = Paths.get(filepath);
        String content = Files.readString(path);
        return content;

    }

    public static String getFileExtension(final String filepath) {
        int indexOfDot = filepath.lastIndexOf(".");
        return filepath.substring(indexOfDot + 1);
    }

}
