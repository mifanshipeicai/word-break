package com.wordbreak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.controller
 * @create 2020-02-23
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String gotoIndex(HttpServletRequest request, Model model) {
        return "index";
    }


}
