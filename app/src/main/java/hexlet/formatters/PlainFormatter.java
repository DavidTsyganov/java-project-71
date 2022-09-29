package hexlet.formatters;

import hexlet.code.Status;

import java.util.Map;

public class PlainFormatter {
    public static String format(final Map<String, Status> map) {
        StringBuilder sb = new StringBuilder();
        int size = map.size();

        for (Map.Entry<String, Status> entry : map.entrySet()) {
            String status = entry.getValue().getStatusName();
            Object oldValue = entry.getValue().getOldValue();
            Object newValue = entry.getValue().getNewValue();

            String strOldValue = convertObjectToString(oldValue);
            String strNewValue = convertObjectToString(newValue);
            String key = entry.getKey();

            size--;

            switch (status) {
                case (Status.CHANGED):
                    sb.append("Property '" + key + "' was updated. From " + strOldValue + " to " + strNewValue);
                    if (size > 0) {
                        sb.append(System.lineSeparator());
                    }
                    break;
                case (Status.DELETED):
                    sb.append("Property '" + key + "' was removed");
                    if (size > 0) {
                        sb.append(System.lineSeparator());
                    }
                    break;
                case (Status.ADDED):
                    sb.append("Property '" + key + "' was added with value: " + strNewValue);
                    if (size > 0) {
                        sb.append(System.lineSeparator());
                    }
                    break;
                case (Status.UNCHANGED):
                    break;
                default:
                    throw new RuntimeException("There is no such status.");
            }
        }
        return sb.toString();
    }

    private static String convertObjectToString(Object value) {
        String newValue = null;
        if (value instanceof String) {
            newValue = "'" + value + "'";
        } else if (value != null) {
            newValue = value.toString();

            if (newValue.contains("[") || newValue.contains("{")) {
                newValue = "[complex value]";
            }
        }
        return newValue;
    }
}
