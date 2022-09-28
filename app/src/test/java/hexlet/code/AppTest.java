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

    @Test
    public void testYaml() throws Exception {
        String diff = Differ.generate(YAML_FILEPATH1, YAML_FILEPATH2);
        String result = Files.readString(Path.of(YAML_RESULT));
        assertThat(diff).isEqualTo(result);
    }
    @Test
    public void testJson() throws Exception {
        String diff = Differ.generate(JSON_FILEPATH1, JSON_FILEPATH2);
        String result = Files.readString((Path.of(JSON_RESULT)));
        assertThat(diff).isEqualTo(result);
    }
}
