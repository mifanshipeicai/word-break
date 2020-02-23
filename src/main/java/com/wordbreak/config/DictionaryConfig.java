package com.wordbreak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.config
 * @create 2020-02-22
 */
@Configuration
public class DictionaryConfig {

    /**
     * default dictionary
     *
     * @return list
     */
    @Bean(name = "dictionaryList")
    public List<String> dictionaryList() {
        return Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "and", "man", "go");
    }

    /**
     * the user dictionary
     * @return list
     */
    @Bean(name = "userDictionaryList")
    public List<String> userDictionaryList() {
        return new ArrayList<>();
    }

}
