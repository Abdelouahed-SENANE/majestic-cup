package ma.youcode.majesticcup.exceptions.custom;

public class NoContentException extends RuntimeException {
    public NoContentException(String entityName) {
        super(String.format("No content found for %s.", entityName));
    }

    public NoContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
