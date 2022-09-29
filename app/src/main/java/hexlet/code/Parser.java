package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.utils.Utils;

import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map<String, Object> getMap(String filepath) throws Exception {
        final String fileContent = Utils.getFileContent(filepath);
        final String fileExtension = Utils.getFileExtension(filepath);

        Map<String, Object> resultMap = new TreeMap<>();

        switch (fileExtension) {
            case "json":
                resultMap = parseJson(fileContent);
                break;
            case "yml":
                resultMap = parseYaml(fileContent);
                break;
            default: throw new Exception("No such format");
        }
        return resultMap;
    }

    private static Map<String, Object> parseJson(final String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new TreeMap<>();
        map = mapper.readValue(json, new TypeReference<Map<String, Object>>() { });
        return map;
    }

    private static Map<String, Object> parseYaml(final String yaml) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, Object> map = new TreeMap<>();
        map = mapper.readValue(yaml, new TypeReference<Map<String, Object>>() { });
        return map;
    }

}
