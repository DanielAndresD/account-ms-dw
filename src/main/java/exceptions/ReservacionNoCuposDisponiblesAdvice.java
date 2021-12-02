package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
@ResponseBody
public class ReservacionNoCuposDisponiblesAdvice {
    @ResponseBody
    @ExceptionHandler(ReservacionNoCuposDisponiblesException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String ReservacionNoCuposDisponiblesAdvice(ReservacionNoCuposDisponiblesException ex) {
        return ex.getMessage();
    }
}
