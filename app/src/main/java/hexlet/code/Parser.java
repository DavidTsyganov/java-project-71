package hexlet.code;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;


public class Parser {
    public static Map<String, Object> parse(String data, String fileType) throws Exception {
        ObjectMapper objectMapper = chooseParseFormat(fileType);
        return objectMapper.readValue(data, new TypeReference<>() { });
    }

    private static ObjectMapper chooseParseFormat(String fileType) {
        return "json".equals(fileType) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
