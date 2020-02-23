package com.wordbreak.controller;

import com.wordbreak.base.ApiResponse;
import com.wordbreak.base.StatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.controller
 * @create 2020-02-23
 * error request
 */
@RestController
public class ReqErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @Autowired
    public ReqErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = ERROR_PATH)
    public ApiResponse errorHandler(HttpServletRequest request) {
        ServletWebRequest requestAttribute = new ServletWebRequest(request);
        Map<String, Object> mapAttributes = this.errorAttributes.getErrorAttributes(requestAttribute, false);
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status != null) {
            return ApiResponse.ofMessage(status, String.valueOf(mapAttributes.getOrDefault("message", "error")));
        }
        return ApiResponse.ofStatus(StatusResponse.SERVER_INTERNAL_ERROR);
    }


}
