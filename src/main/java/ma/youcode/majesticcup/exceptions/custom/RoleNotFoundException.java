package ma.youcode.majesticcup.exceptions.custom;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}
