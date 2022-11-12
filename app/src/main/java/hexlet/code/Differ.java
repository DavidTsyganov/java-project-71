package hexlet.code;


import hexlet.utils.Utils;

import java.util.*;

public class Differ {
    private static final String STYLISH = "stylish";
    public static String generate(final String filepath1,
                                  final String filepath2,
                                  final String formatName) throws Exception {

        String data1 = Utils.getFileContent(filepath1);
        String data2 = Utils.getFileContent(filepath2);

        String type1 = Utils.getFileType(filepath1);
        String type2 = Utils.getFileType(filepath2);

        Map<String, Object> map1 = Parser.parse(data1, filepath1);
        Map<String, Object> map2 = Parser.parse(data2, filepath2);

        List<Map<String, Object>> resultList = Comparer.compare(map1, map2);

        return Formatter.choose(resultList, formatName);
    }
    public static String generate(final String filepath1,
                                  final String filepath2) throws Exception {
        return generate(filepath1, filepath2, STYLISH);
    }
}
