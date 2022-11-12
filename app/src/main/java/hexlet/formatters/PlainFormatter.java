package hexlet.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    private static StringBuilder stringBuilder;
    public static String toString(final List<Map<String, Object>> resultList) {
        stringBuilder = new StringBuilder();

        for (Map<String, Object> map: resultList) {
            setUpString(map);

            switch ((String) map.get("status")) {
                case "updated" -> setUpUpdated(map);
                case "removed" -> setUpRemoved(map);
                case "added" -> setUpAdded(map);
                default -> { }
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static void setUpString(Map<String, Object> map) {
        String status = (String) map.get("status");

        if (!"unchanged".equals(status)) {
            stringBuilder.append("Property '")
                    .append(map.get("key"))
                    .append("' was ")
                    .append(status);
        }
    }
    private static void setUpUpdated(Map<String, Object> map) {
        stringBuilder.append(". ")
                .append("From ")
                .append(hideComplexValue(map.get("oldvalue")))
                .append(" to ")
                .append(hideComplexValue(map.get("newvalue")))
                .append(System.lineSeparator());
    }

    private static void setUpRemoved(Map<String, Object> map) {
        stringBuilder.append(System.lineSeparator());
    }

    private static void setUpAdded(Map<String, Object> map) {
        stringBuilder.append(" with value: ")
                .append(hideComplexValue(map.get("newvalue")))
                .append(System.lineSeparator());
    }

    private static Object hideComplexValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        return value;
    }
}
