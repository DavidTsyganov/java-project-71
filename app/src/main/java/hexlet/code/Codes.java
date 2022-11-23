package hexlet.code;

public enum Codes {
    CODE_0(0),
    CODE_1(1);

    private int value;

    Codes(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
