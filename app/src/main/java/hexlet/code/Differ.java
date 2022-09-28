package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.formatters.Stylish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {
    public static void main(String[] args) throws Exception {
        String file1 = "/home/dts/IdeaProjects/project2/app/src/main/resources/file1.json";
        String file2 = "/home/dts/IdeaProjects/project2/app/src/main/resources/file2.json";
        Differ.generate(file1, file2);
    }

    public static String generate(final String filepath1, final String filepath2) throws Exception {
        String diff = null;

        Map<String, Object> map1 = Parser.getMap(filepath1);
        Map<String, Object> map2 = Parser.getMap(filepath2);

        Map<String, Status> resultMap = compareMaps(map1, map2);

        diff = Stylish.format(resultMap);

        System.out.println(diff);
        return diff;
    }


    private static Map<String, Status> compareMaps(final Map<String, Object> map1, final Map<String, Object> map2) {
        Set<String> setOfKeys = new TreeSet<>();
        setOfKeys.addAll(map1.keySet());
        setOfKeys.addAll(map2.keySet());

        Map<String, Status> map = new LinkedHashMap<>();


        for (String key : setOfKeys) {
            boolean key1Exists = map1.containsKey(key);
            boolean key2Exists = map2.containsKey(key);

            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (!key1Exists && key2Exists) {
                map.put(key, new Status(Status.ADDED, value1, value2));
            } else if (key1Exists && !key2Exists) {
                map.put(key, new Status(Status.DELETED, value1, null));
            } else if (key1Exists && key2Exists && value1 != null && value1.equals(value2)) {
                map.put(key, new Status(Status.UNCHANGED, value1, value2));
            } else {
                map.put(key, new Status(Status.CHANGED, value1, value2));
            }
        }

        return map;
    }
}
