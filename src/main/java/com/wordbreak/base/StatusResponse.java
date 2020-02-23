package com.wordbreak.base;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.base
 * @create 2020-02-22
 * api response message
 */
public enum StatusResponse {

    SUCCESS(200, "OK"),
    BAD_REQUEST(400, "bad reqseut"),
    NOT_HAS_DICTIONARY(406, "input word didn't in dictionary"),
    NOT_HAS_USER_DICTIONARY(407, "input word didn't in you dictionary"),
    NOT_HAS_LOCAL_USER_DICTIONARY(408, "input word is not in the you dictionary or system dictionary"),
    INPUT_YOU_WORD(409, "please input word"),
    SAVE_WORD_FAIL(410, "save input word fail"),
    THE_WORD_ALREADY_IN_DICTIONART(411, "u input word has already in the dictionary"),
    SERVER_INTERNAL_ERROR(500, "unknow internal error");

    private int code;
    private String message;

    StatusResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
