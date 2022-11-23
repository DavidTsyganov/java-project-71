package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(final List<Map<String, Object>> resultList, String format) throws IOException {
        return switch (format) {
            case "json" -> Json.toString(resultList);
            case "stylish" -> Stylish.toString(resultList);
            case "plain" -> Plain.toString(resultList);
            default -> new UnknownFormatException().getMessage();
        };
    }
}
