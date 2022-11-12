package hexlet.code;

import java.util.*;

public class Comparer {
    public static List<Map<String, Object>> compare(final Map<String, Object> map1, final Map<String, Object> map2) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        Set<String> keySet = new TreeSet<>(map1.keySet());
        keySet.addAll(map2.keySet());

        for (String key: keySet) {
            Map<String, Object> map = new LinkedHashMap<>();

            if (map1.containsKey(key) && !map2.containsKey(key)) {
                map.put("key", key);
                map.put("oldvalue", map1.get(key));
                map.put("status", "removed");
            } else if (map2.containsKey(key) && !map1.containsKey(key)) {
                map.put("key", key);
                map.put("newvalue", map2.get(key));
                map.put("status", "added");
            } else if (Objects.equals(map1.get(key), (map2.get(key)))) {
                map.put("key", key);
                map.put("oldvalue", map1.get(key));
                map.put("newvalue", map2.get(key));
                map.put("status", "unchanged");
            } else {
                map.put("key", key);
                map.put("oldvalue", map1.get(key));
                map.put("newvalue", map2.get(key));
                map.put("status", "updated");
            }
            resultList.add(map);
        }
        return resultList;
    }
}
