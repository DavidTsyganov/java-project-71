package hexlet.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Status;

import java.io.IOException;
import java.util.Map;

public class JsonFormatter {
    public static String format(final Map<String, Status> map) throws IOException {
        String json = new ObjectMapper().writeValueAsString(map);
        return json;
    }
}
