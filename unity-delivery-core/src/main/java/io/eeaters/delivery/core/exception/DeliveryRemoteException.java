package io.eeaters.delivery.core.exception;

import lombok.Getter;

@Getter
public class DeliveryRemoteException extends UnifyDeliveryException{

    private String code;

    private String errorMessage;

    public DeliveryRemoteException(Integer code, String errorMessage) {
        this(String.valueOf(code), errorMessage);
    }

    public DeliveryRemoteException(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
