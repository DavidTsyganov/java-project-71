package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.NoSuchElementException;


public class Parser {
    public static Map<String, Object> getData(final String filepath) throws IOException {
        ObjectMapper objectMapper = chooseParseFormat(getFileType(filepath));
        String data = getFileContent(filepath);
        return objectMapper.readValue(data, new TypeReference<>() { });
    }
    public static Map<String, Object> parse(String data, String fileType) throws Exception {
        ObjectMapper objectMapper = chooseParseFormat(fileType);
        return objectMapper.readValue(data, new TypeReference<>() { });
    }

    private static ObjectMapper chooseParseFormat(String fileType) {
        return "json".equals(fileType) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }

    private static String getFileType(final String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }

    private static String getLocalFilePath(String filePath) {
        return filePath.substring(filePath.indexOf("src"));
    }

    private static String getFileContent(final String filepath) throws IOException {
        if (filepath == null) {
            throw new NoSuchElementException();
        }
        if (filepath.equals("")) {
            throw new NoSuchElementException();
        }

        Path path = Paths.get(getLocalFilePath(filepath));
        return Files.readString(path);
    }
}
