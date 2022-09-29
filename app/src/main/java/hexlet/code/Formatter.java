package hexlet.code;

import hexlet.formatters.JsonFormatter;
import hexlet.formatters.PlainFormatter;
import hexlet.formatters.StylishFormatter;

import java.io.IOException;
import java.util.Map;

public class Formatter {
    public static String choose(final Map<String, Status> map, final String formatName) throws IOException {
        String result;
        switch (formatName) {
            case ("plain"):
                result = PlainFormatter.format(map);
                break;
            case ("json"):
                result = JsonFormatter.format(map);
                break;
            default:
                result = StylishFormatter.format(map);
        }
        return result;
    }
}
