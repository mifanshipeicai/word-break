package com.wordbreak.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wordbreak.base.ApiResponse;
import com.wordbreak.base.StatusResponse;
import com.wordbreak.service.WordBreakService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.controller
 * @create 2020-02-23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WordControllerTest {

    private static final String PREFIX_URL = "/word";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WordBreakService wordBreakService;


    /**
     * test word/break/api
     *
     * @throws Exception
     */
    @Test
    public void testBreak() throws Exception {
        String word = "ilikesamsungmobile";
        //String word = "ilikeiphone";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(PREFIX_URL + "/break/" + word))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        JsonElement element = new JsonParser().parse(content);
        JsonObject json = element.getAsJsonObject();
        int code = json.get("code").getAsInt();

        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), code);
    }


    /**
     * test word/user/break/api
     *
     * @throws Exception
     */
    @Test
    public void testUserBreak() throws Exception {
        //String word = "ilikesamsungmobile";
        String word = "ilikeiphone";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(PREFIX_URL + "/user/break/" + word))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        JsonElement element = new JsonParser().parse(content);
        JsonObject json = element.getAsJsonObject();
        int code = json.get("code").getAsInt();

        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), code);
    }


    /**
     * test word/userLocal/break/api
     *
     * @throws Exception
     */
    @Test
    public void testUserLocalBreak() throws Exception {
        //befor word
        String saveWord = "iphone,xiaomi,huawei";
        //String[] saveWord = {"iphone","huawei","xiaomi"};
        wordBreakService.saveUserWord(saveWord);

        //String word = "ilikesamsungmobile";
        String word = "ilikeiphonesamsung";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get(PREFIX_URL + "/userLocal/break/" + word))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        JsonElement element = new JsonParser().parse(content);
        JsonObject json = element.getAsJsonObject();
        int code = json.get("code").getAsInt();

        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), code);
    }


    @Test
    public void testUserSave() throws Exception {
        String words = "iphone,xiaomi,huawei";

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post(PREFIX_URL + "/user/save")
                        .param("words",words))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        ApiResponse response = (ApiResponse)mvcResult.getAsyncResult(15000);
        Assert.assertEquals(StatusResponse.SUCCESS.getCode(), response.getCode());
    }


}
