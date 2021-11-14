package com.wolfpack.vision.helper;

import com.wolfpack.vision.excpetion.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private String errorCode, errorMessage;
    private int status;
    private Object data;

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode.name();
        this.errorMessage = errorCode.getErrorMessage();
    }

    public ApplicationException(ErrorCode errorCode, String... fields) {
        this.errorMessage = (String.format(errorCode.getErrorMessage(), fields));
        this.errorCode = errorCode.name();
    }

    public ApplicationException(ErrorCode errorCode, int status, Object data, String... fields) {
        this.status = status;
        this.data = data;
        this.errorMessage = (String.format(errorCode.getErrorMessage(), fields));
        this.errorCode = errorCode.name();
    }

    public ApplicationException(ErrorCode errorCode, int status, String... fields) {
        this.status = status;
        this.errorMessage = (String.format(errorCode.getErrorMessage(), fields));
        this.errorCode = errorCode.name();
    }

    public ApplicationException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApplicationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}