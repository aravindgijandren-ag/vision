package com.wolfpack.vision.excpetion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ErrorCode {
    CLIENT_TIMEOUT("Request to client timed out"),
    SERVER_UNREACHABLE("Destination server unreacheble"),
    TIME_OUT("Destination request timeout"),
    CLIENT_ERROR("Client error during request"),
    EMPTY_RESPONSE("Empty response from client"),
    NO_USER_ID_FOUND("User Id not returned in the query"),
    UNKNOWN_ERROR("Unexpected error occured"),
    INVALID_SET_ID("Invalid set configuration id"),
    IMAGE_LIST_EMPTY("Empty image list"),
    S3_IMAGE_UPLOAD_FAILED("Failed to upload image"),
    SET_CONFIGURATION_ID_NOT_FOUND("Unable to find set configuration id %s"),
    EMPTY_LIST("Empty %s list"),
    INVALID_DATA("invalid data"),
    INVALID_REQUEST("Invalid request"),
    NOT_FOUND("%s not found"),
    FAILED("Request failed, %s"),
    INCORRECT_INPUT("Incorrect Input, %s");

    private String errorMessage;

}