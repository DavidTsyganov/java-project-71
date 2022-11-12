package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    public static final String JSON_FILEPATH1 = "src/test/resources/file1.json";
    public static final String JSON_FILEPATH2 = "src/test/resources/file2.json";
    public static final String YAML_FILEPATH1 = "src/test/resources/file1.yml";
    public static final String YAML_FILEPATH2 = "src/test/resources/file2.yml";
    public static final String JSON_RESULT = "src/test/resources/json_result.diff";
    public static final String YAML_RESULT = "src/test/resources/yaml_result.diff";
    public static final String PLAIN_RESULT = "src/test/resources/plain_result";

    public static final String RESULT_IN_JSON = "src/test/resources/diff_in_json.json";

    @Test
    public void testYaml() throws Exception {
        String format = "stylish";
        String diff = Differ.generate(YAML_FILEPATH1, YAML_FILEPATH2, format);
        String result = Files.readString(Path.of(YAML_RESULT));
        assertThat(result).isEqualTo(diff);
    }
    @Test
    public void testJson() throws Exception {
        String format = "stylish";
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, format);
        String result = Files.readString((Path.of(JSON_RESULT)));
        assertThat(result).isEqualTo(diff);
    }

    @Test
    public void testJsonPlainOutput() throws Exception {
        String formatName = "plain";
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, formatName);
        String result = Files.readString((Path.of(PLAIN_RESULT)));
        assertThat(result).isEqualTo(diff);
    }
    @Test
    public void testYamlPlainOutput() throws Exception {
        String formatName = "plain";
        String diff = Differ.generate(YAML_FILEPATH1, YAML_FILEPATH2, formatName);
        String result = Files.readString((Path.of(PLAIN_RESULT)));
        assertThat(result).isEqualTo(diff);
    }
    @Test
    public void testYamlJsonOutput() throws Exception {
        String formatName = "json";
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2, formatName);
        String result = Files.readString((Path.of(RESULT_IN_JSON)));
        assertThat(result).isEqualTo(diff);
    }
    @Test
    public void testJsonToJsonOutput() throws Exception {
        String formatName = "json";
        String diff = Differ.generate(YAML_FILEPATH1, YAML_FILEPATH2, formatName);
        String result = Files.readString((Path.of(RESULT_IN_JSON)));
        assertThat(result).isEqualTo(diff);
    }

    @Test
    public void testFailedCase() throws Exception {
        String formatName = "stylish";

    }
}
