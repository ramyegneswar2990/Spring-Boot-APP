package spring_pr.com.day21.exceptionalhandling;

public class ExceptionResponse extends RuntimeException {

    public ExceptionResponse(String message) {
        super(message);
    }
}