package sample.com.au.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AutoGeneralException extends RuntimeException {
    public AutoGeneralException(String exception) {
        super(exception);
    }
}
