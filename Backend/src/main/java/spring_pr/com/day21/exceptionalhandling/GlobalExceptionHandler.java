package spring_pr.com.day21.exceptionalhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;




@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        ExceptionResponse response = new ExceptionResponse( e.getMessage());
        return ResponseEntity.status(404).body(response);
    }
    // fix  that  @Not blank error
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException e) {
        ExceptionResponse response = new ExceptionResponse("Invalid input data.");
        return ResponseEntity.badRequest().body(response);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        ExceptionResponse response = new ExceptionResponse("Something went wrong. Please try again later.");
        return ResponseEntity.internalServerError().body(response);
    }
}   