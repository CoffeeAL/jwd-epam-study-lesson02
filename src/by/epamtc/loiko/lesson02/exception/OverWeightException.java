package by.epamtc.loiko.lesson02.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class OverWeightException extends Exception {

    public OverWeightException(String message) {
        super(message);
    }

    public OverWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverWeightException(Throwable cause) {
        super(cause);
    }

    public OverWeightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}