package ma.youcode.majesticcup.exceptions.custom;

public class TeamExistsException extends RuntimeException {
    public TeamExistsException(String message) {
        super(message);
    }
}
