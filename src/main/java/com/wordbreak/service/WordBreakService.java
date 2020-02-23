package com.wordbreak.service;

import com.wordbreak.base.ApiResponse;


/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.service
 * @create 2020-02-22
 */
public interface WordBreakService {

    ApiResponse breakWord(String word);

    ApiResponse breakUserWord(String word);

    ApiResponse breakUserAndLocaWork(String word);

    ApiResponse saveUserWord(String words);

}
