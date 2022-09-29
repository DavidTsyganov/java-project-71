package hexlet.formatters;

import hexlet.code.Status;

import java.util.Map;

public class StylishFormatter {
    public static final String NAME_OF_FORMATTER = "stylish";

    public static String format(final Map<String, Status> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(System.lineSeparator());

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String key = entry.getKey();

            String status = entry.getValue().getStatusName();
            Object oldValue = entry.getValue().getOldValue();
            Object newValue = entry.getValue().getNewValue();

            switch (status) {
                case ("deleted"):
                    stringBuilder.append("  - " + key + ": " + oldValue);
                    stringBuilder.append(System.lineSeparator());
                    break;
                case ("added"):
                    stringBuilder.append("  + " + key + ": " + newValue);
                    stringBuilder.append(System.lineSeparator());
                    break;
                case ("changed"):
                    stringBuilder.append("  - " + key + ": " + oldValue);
                    stringBuilder.append(System.lineSeparator());
                    stringBuilder.append("  + " + key + ": " + newValue);
                    stringBuilder.append(System.lineSeparator());
                    break;
                case ("unchanged"):
                    stringBuilder.append("    " + key +": " + oldValue);
                    stringBuilder.append(System.lineSeparator());
                    break;
                default:
                    throw new RuntimeException("There's no such status.");
            }
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
