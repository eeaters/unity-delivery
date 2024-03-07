package io.eeaters.delivery.core.exception;

public abstract class UnifyDeliveryException extends RuntimeException{
    public UnifyDeliveryException() {
    }

    public UnifyDeliveryException(String message) {
        super(message);
    }

    public UnifyDeliveryException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnifyDeliveryException(Throwable cause) {
        super(cause);
    }

}
