package fr.hoag.services.exceptions;

public class BusinessServiceException extends Throwable {

    private String code;
    private String message;

    public BusinessServiceException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessServiceException(String code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BusinessServiceException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }

}
