package hexlet.code;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    private static final String STYLISH = "stylish";
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String formatName) throws Exception {

        Map<String, Object> map1 = Parser.getMap(filepath1);
        Map<String, Object> map2 = Parser.getMap(filepath2);

        Map<String, Status> resultMap = compareMaps(map1, map2);

        return Formatter.choose(resultMap, formatName);
    }

    // Default generator with a default format - stylish
    public static String generate(final String filepath1,
                                  final String filepath2) throws Exception {

        Map<String, Object> map1 = Parser.getMap(filepath1);
        Map<String, Object> map2 = Parser.getMap(filepath2);

        Map<String, Status> resultMap = compareMaps(map1, map2);

        return Formatter.choose(resultMap, STYLISH);
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
