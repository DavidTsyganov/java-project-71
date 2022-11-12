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

        Path path = Paths.get(getLocalFilePath(filepath));
        return Files.readString(path);

    }

    public static String getLocalFilePath(String filePath) {
        return filePath.substring(filePath.indexOf("src"));
    }

    public static String getFileType(final String filePath) {
        return filePath.substring(filePath.indexOf(".") + 1);
    }

}
