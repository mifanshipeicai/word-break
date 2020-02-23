package com.wordbreak.base;

import lombok.Data;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.base
 * @create 2020-02-22
 * api response format
 */
@Data
public class ApiResponse {

    private int code;
    private String msg;
    private Object data;

    public ApiResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResponse ofMessage(int code, String msg) {
        return new ApiResponse(code, msg, null);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(StatusResponse.SUCCESS.getCode(), StatusResponse.SUCCESS.getMessage(), data);
    }

    public static ApiResponse ofStatus(StatusResponse statusResponse) {
        return new ApiResponse(statusResponse.getCode(), statusResponse.getMessage(), null);
    }

}
