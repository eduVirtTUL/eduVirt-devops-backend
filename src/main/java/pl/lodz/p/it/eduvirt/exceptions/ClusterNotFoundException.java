package pl.lodz.p.it.eduvirt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClusterNotFoundException extends ApplicationBaseException {

    public ClusterNotFoundException() {
    }

    public ClusterNotFoundException(String message) {
        super(message);
    }

    public ClusterNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
