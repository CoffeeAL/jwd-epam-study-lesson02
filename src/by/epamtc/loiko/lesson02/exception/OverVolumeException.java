package by.epamtc.loiko.lesson02.exception;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class OverVolumeException extends Exception {

    public OverVolumeException(String message) {
        super(message);
    }

    public OverVolumeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverVolumeException(Throwable cause) {
        super(cause);
    }

    public OverVolumeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}