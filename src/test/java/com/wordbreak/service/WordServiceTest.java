package com.wordbreak.service;

import com.wordbreak.base.ApiResponse;
import com.wordbreak.base.StatusResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author little_super
 * @project word-break
 * @package com.wordbreak.service
 * @create 2020-02-23 10:22
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WordServiceTest {


    @Autowired
    private WordBreakService wordBreakService;


    @Test
    public void testNormalWordbreak() {
        String word = "ilikesamsungmobile";

        ApiResponse response = wordBreakService.breakWord(word);
        log.info("word break unit test :result-> [{}]", response.toString());
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());
    }


    @Test
    public void testNotDictionaryWordbreak() {
        String word = "ilikeiphone";

        ApiResponse response = wordBreakService.breakWord(word);
        log.error("word break unit test : the result-> [{}]", response.toString());
        Assert.assertEquals(StatusResponse.NOT_HAS_DICTIONARY.getCode(), response.getCode());
    }

    @Test
    public void testBreakUserWordbreak() {
        String[] wordArray = {"iphone","xiaomi","huawei"};
        ApiResponse response = wordBreakService.saveUserWord(wordArray);
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());

        String word = "iphonehuawei";
        ApiResponse breakResponse = wordBreakService.breakUserWord(word);

        log.info("break user word unit test : the result-> [{}]", breakResponse.toString());
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), breakResponse.getCode());
    }


    @Test
    public void testBreakUserLocalWordbreak() {
        String[] wordArray = {"iphone","xiaomi","huawei"};
        ApiResponse response = wordBreakService.saveUserWord(wordArray);
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());

        String word = "ilikeiphonehuaweiice";
        ApiResponse breakResponse = wordBreakService.breakUserAndLocaWork(word);

        log.info("break user word unit test : the result-> [{}]", breakResponse.toString());
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), breakResponse.getCode());
    }


    @Test
    public void testSaveWordbreak() {
        String[] wordArray = {"iphone","xiaomi","huawei"};
        ApiResponse response = wordBreakService.saveUserWord(wordArray);
        log.info("save word unit test : the result-> [{}]", response.toString());
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());
    }



}
