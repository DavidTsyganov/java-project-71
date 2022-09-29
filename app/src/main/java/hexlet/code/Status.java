package hexlet.code;

public class Status {
    public static final String ADDED = "added";
    public static final String DELETED = "deleted";
    public static final String UNCHANGED = "unchanged";
    public static final String CHANGED = "changed";

    private String statusName;
    private Object oldValue;
    private Object newValue;

    Status(final String statusName, final Object oldValue, final Object newValue) {
        this.statusName = statusName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
