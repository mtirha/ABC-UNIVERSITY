package edu.miu.registrarservice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorApi {

    private int status;
    private String message;
    private long timestamp;
    private String path;
    private Map<String, String> validationErrors;

    public ErrorApi(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}
