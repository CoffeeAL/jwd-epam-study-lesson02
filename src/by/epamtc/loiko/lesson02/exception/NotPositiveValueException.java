package by.epamtc.loiko.lesson02.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class NotPositiveValueException extends Exception {

    public NotPositiveValueException(String message) {
        super(message);
    }

    public NotPositiveValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotPositiveValueException(Throwable cause) {
        super(cause);
    }

    public NotPositiveValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}