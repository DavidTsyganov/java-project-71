package hexlet.code;

public final class Status {
    public static final String ADDED = "added";
    public static final String DELETED = "deleted";
    public static final String UNCHANGED = "unchanged";
    public static final String CHANGED = "changed";

    private String statusName;
    private Object oldValue;
    private Object newValue;

    Status(final String status, final Object oldVal, final Object newVal) {
        this.statusName = status;
        this.oldValue = oldVal;
        this.newValue = newVal;
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
