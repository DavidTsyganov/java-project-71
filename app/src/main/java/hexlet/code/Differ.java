package hexlet.code;


import static hexlet.code.Parser.getData;

import java.util.List;
import java.util.Map;



public class Differ {
    private static final String STYLISH = "stylish";
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String formatName) throws Exception {

        Map<String, Object> map1 = getData(filepath1);
        Map<String, Object> map2 = getData(filepath2);

        List<Map<String, Object>> resultList = Comparer.compare(map1, map2);

        return Formatter.format(resultList, formatName);
    }
    public static String generate(final String filepath1,
                                  final String filepath2) throws Exception {
        return generate(filepath1, filepath2, STYLISH);
    }
}
