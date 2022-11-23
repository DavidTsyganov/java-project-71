package hexlet.code;

public class UnknownFormatException extends Exception {
    private String message = "There's no such format of file.";
    @Override
    public String getMessage() {
        return this.message;
    }
    public String toString() {
        return "[Unknown Format Exception: " + this.getMessage() + ']';
    }
}



