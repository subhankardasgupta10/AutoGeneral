package sample.com.au.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sample.com.au.model.ErrorDetailsTopLevel;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AutoGeneralException.class)
    public final ResponseEntity<ErrorDetailsTopLevel> handleBadRequestException(AutoGeneralException ex, WebRequest request) {
        // can be configured more generic and also can use ArrayList to segregate details in a JSON Array format.
        ErrorDetailsTopLevel errorDetails = new ErrorDetailsTopLevel("ValidationError", request.getDescription(false),
                request.getParameter("input"), ex.getMessage(),  "400");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
