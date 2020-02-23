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
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.service
 * @create 2020-02-23
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

        String getResult = response.getData().toString();
        String trueResult = "[i like sam sung mobile, i like samsung mobile]";
        Assert.assertEquals(getResult, trueResult);
    }


    @Test
    public void testNotDictionaryWordbreak() {
        String word = "ilikeoppo";

        ApiResponse response = wordBreakService.breakWord(word);
        log.error("word break unit test : the result-> [{}]", response.toString());
        Assert.assertEquals(StatusResponse.NOT_HAS_DICTIONARY.getCode(), response.getCode());
    }

    @Test
    public void testBreakUserWordbreak() {
        String words = "iphone,xiaomi,huawei";
        //String[] wordArray = {"iphone","huawei","xiaomi"};
        ApiResponse response = wordBreakService.saveUserWord(words);
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());

        String word = "iphonehuawei";
        ApiResponse breakResponse = wordBreakService.breakUserWord(word);

        log.info("break user word unit test : the result-> [{}]", breakResponse.toString());

        String getResult = breakResponse.getData().toString();
        String trueResult = "[iphone huawei]";

        Assert.assertEquals(getResult, trueResult);
    }


    @Test
    public void testBreakUserLocalWordbreak() {
        String words = "iphone,xiaomi,huawei";
        //String[] wordArray = {"iphone","huawei","xiaomi"};
        ApiResponse response = wordBreakService.saveUserWord(words);
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());

        String word = "ilikeiphonehuaweiice";
        ApiResponse breakResponse = wordBreakService.breakUserAndLocaWork(word);

        log.info("break user word unit test : the result-> [{}]", breakResponse.toString());

        String getResult = breakResponse.getData().toString();
        String trueResult = "[i like iphone huawei ice]";

        Assert.assertEquals(trueResult, getResult);
    }


    @Test
    public void testSaveWordbreak() {
        String words = "iphone,xiaomi,huawei";
        //String wordArray = "iphone xiaomi huawei";
        //String[] wordArray = {"iphone","huawei","xiaomi"};
        ApiResponse response = wordBreakService.saveUserWord(words);
        log.info("save word unit test : the result-> [{}]", response.toString());

        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());
    }


}
