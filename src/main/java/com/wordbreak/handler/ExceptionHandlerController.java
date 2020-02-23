package com.wordbreak.handler;

import com.wordbreak.base.ApiResponse;
import com.wordbreak.base.StatusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.handler
 * @create 2020-02-22
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    public ApiResponse handler(Exception e) {
        // You can tell what kind of exception is here
        log.error("exception {}", e.getMessage());
        if(e instanceof NullPointerException){
            return ApiResponse.ofStatus(StatusResponse.SERVER_INTERNAL_ERROR);
        }
        return ApiResponse.ofStatus(StatusResponse.SERVER_INTERNAL_ERROR);
    }

}
