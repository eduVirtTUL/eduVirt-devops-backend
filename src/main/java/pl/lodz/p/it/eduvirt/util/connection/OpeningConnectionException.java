package pl.lodz.p.it.eduvirt.util.connection;

public class OpeningConnectionException extends RuntimeException {
    public OpeningConnectionException(String message) {
        super(message);
    }

    public OpeningConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
