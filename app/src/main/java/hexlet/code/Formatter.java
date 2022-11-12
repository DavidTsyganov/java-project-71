package hexlet.code;

import hexlet.formatters.JsonFormatter;
import hexlet.formatters.PlainFormatter;
import hexlet.formatters.StylishFormatter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String choose(final List<Map<String, Object>> resultList, String format) throws IOException {
        return switch (format) {
            case "stylish" -> StylishFormatter.toString(resultList);
            case "plain" -> PlainFormatter.toString(resultList);
            default -> JsonFormatter.toString(resultList);
        };
    }
}
