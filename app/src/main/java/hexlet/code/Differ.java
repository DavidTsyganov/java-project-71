package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static void main(String[] args) throws Exception {
        String file1 = "/home/dts/IdeaProjects/project2/app/src/main/resources/file1.json";
        String file2 = "/home/dts/IdeaProjects/project2/app/src/main/resources/file2.json";
        Differ.generate(file1, file2);
    }

    public static String generate(final String filePath1, final String filePath2) throws Exception {
        String diff = null;
        String json1 = readFileToString(filePath1);
        String json2 = readFileToString(filePath2);
        Map<String, Object> map1 = jsonToMap(json1);
        Map<String, Object> map2 = jsonToMap(json2);

        diff = compareMaps(map1, map2);

        System.out.println(diff);
        return diff;
    }

    private static String readFileToString(final String filePath) throws IOException {
        Path path = Paths.get(filePath);
        String content = Files.readString(path);
        return content;
    }

    private static Map<String, Object> jsonToMap(final String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new TreeMap<>();
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() { });
        return map;
    }

    private static String compareMaps(final Map<String, Object> map1, final Map<String, Object> map2) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        result.append(System.lineSeparator());

        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            if (!map1.keySet().contains(key)) {
                result.append("  + " + key + ": " + map2.get(key));
                result.append(System.lineSeparator());
            } else if (!map2.keySet().contains(key)) {
                result.append("  - " + key + ": " + map1.get(key));
                result.append(System.lineSeparator());
            } else if (map1.get(key).equals(map2.get(key))) {
                result.append("    " + key + ": " + map1.get(key));
                result.append(System.lineSeparator());
            } else {
                result.append("  - " + key + ": " + map1.get(key));
                result.append(System.lineSeparator());
                result.append("  + " + key + ": " + map2.get(key));
                result.append(System.lineSeparator());
            }
        }

        result.append("}");
        return result.toString().trim();
    }
}
