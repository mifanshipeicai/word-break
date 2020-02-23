package com.wordbreak.service.impl;

import com.wordbreak.base.ApiResponse;
import com.wordbreak.base.StatusResponse;
import com.wordbreak.service.WordBreakService;
import com.wordbreak.util.BreakUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.service
 * @create 2020-02-22
 */
@Service
public class WordBreakServiceImpl implements WordBreakService {

    private static final String LOCAL = "local";
    private static final String USER = "user";
    private static final String LOCAL_USER = "local";

    @Autowired
    private List<String> dictionaryList;

    @Autowired
    private List<String> userDictionaryList;

    /**
     * input word you can break the word from the local dictionary
     *
     * @param word
     * @return
     */
    @Override
    public ApiResponse breakWord(String word) {
        List<String> list = BreakUtil.wordBreak(LOCAL, word, dictionaryList);
        if (list.isEmpty()) return ApiResponse.ofStatus(StatusResponse.NOT_HAS_DICTIONARY);
        return ApiResponse.ofSuccess(list);
    }

    /**
     * use user's dictionary to break input word
     *
     * @param word
     * @return
     */
    @Override
    public ApiResponse breakUserWord(String word) {
        List<String> list = BreakUtil.wordBreak(USER, word, userDictionaryList);
        if (list.isEmpty()) return ApiResponse.ofStatus(StatusResponse.NOT_HAS_DICTIONARY);
        return ApiResponse.ofSuccess(list);
    }

    /**
     * use two dictionary to break input word
     *
     * @param word
     * @return
     */
    @Override
    public ApiResponse breakUserAndLocaWork(String word) {
        List<String> list = new ArrayList<>();
        list.addAll(dictionaryList);
        list.addAll(userDictionaryList);
        list = list.stream().distinct().collect(Collectors.toList());
        List<String> results = BreakUtil.wordBreak(LOCAL_USER, word, list);
        if (results.isEmpty()) return ApiResponse.ofStatus(StatusResponse.NOT_HAS_DICTIONARY);
        return ApiResponse.ofSuccess(results);
    }


    /**
     * save user word into his dictionary
     *
     * @param words
     * @return
     */
    @Override
    public ApiResponse saveUserWord(String words) {
        String[] wordArray = words.split(",");
        //We can also determine if this is an empty collection and return
        userDictionaryList.addAll(Arrays.asList(wordArray));
        userDictionaryList = userDictionaryList.stream().filter((s) -> !s.equalsIgnoreCase("")).distinct().collect(Collectors.toList());
        return ApiResponse.ofSuccess(null);
    }


}
