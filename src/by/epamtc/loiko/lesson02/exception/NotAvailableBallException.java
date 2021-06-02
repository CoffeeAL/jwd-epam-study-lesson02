package by.epamtc.loiko.lesson02.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public class NotAvailableBallException extends Exception {

    public NotAvailableBallException(String message) {
        super(message);
    }

    public NotAvailableBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAvailableBallException(Throwable cause) {
        super(cause);
    }

    public NotAvailableBallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}