package io.eeaters.delivery.shunfeng.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class SFBaseResponse<T> {

    @JsonProperty("error_code")
    private Integer errorCode;

    @JsonProperty("error_msg")
    private String errorMsg;

    @JsonProperty("error_data")
    private Object errorData;

    @JsonProperty("result")
    private T result;

    public boolean isSuccess() {
        return Objects.equals(errorCode, 0);
    }
}
