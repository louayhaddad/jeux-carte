package atexo.jeux.carte.error;


import atexo.jeux.carte.exception.CardException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CardExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(new ApiError(String.valueOf(status.value())), status);
    }

    @ExceptionHandler(CardException.class)
    public ResponseEntity<Object> handleCardException(CardException ex)  {
        return new ResponseEntity<>(new ApiError(ex.getErrorMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
