package com.wordbreak.controller;

import com.wordbreak.base.ApiResponse;
import com.wordbreak.service.WordBreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.controller
 * @create 2020-02-22
 */
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordBreakService wordBreakService;


    @GetMapping("/break/{word}")
    public ApiResponse breakWork(@PathVariable String word) {
        return wordBreakService.breakWord(word);
    }


    @GetMapping("/user/break/{word}")
    public ApiResponse breakUserWork(@PathVariable String word) {
        return wordBreakService.breakUserWord(word);
    }


    @GetMapping("/userLocal/break/{word}")
    public ApiResponse breakUserAndLocaWork(@PathVariable String word) {
        return wordBreakService.breakUserAndLocaWork(word);
    }


    /**
     * please use "," to separate your parameters like "hello,world"
     *
     * @param word
     * @return
     */
    @PostMapping("/user/save")
    public Callable<ApiResponse> saveUserWord(String[] word) {
        return ()-> wordBreakService.saveUserWord(word);
    }


}
