package io.eeaters.delivery.dada.response;

import lombok.Data;

@Data
public class DaDaBaseResponse <T>{

    private String status;
    private Integer code;
    private String msg;
    private T result;


    public boolean isSuccess() {
        return code.equals(0);
    }
}
