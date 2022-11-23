package hexlet.code;

public enum Codes {
    CODE_0(0),
    CODE_1(1);

    private int value;

    private Codes(final int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
