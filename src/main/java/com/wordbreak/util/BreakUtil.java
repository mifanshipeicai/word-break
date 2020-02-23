package com.wordbreak.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.util
 * @create 2020-02-22
 */
public class BreakUtil {


    public static List<String> wordBreak(String key, String s, List<String> wordDict) {
        return getBreakResult(key, s, wordDict, 0);
    }

    /**
     * break input search form local dictionary or user dictionary or those
     * @param key
     * @param s
     * @param wordDict
     * @param offset
     * @return
     */
    private static List<String> getBreakResult(String key, String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        if (SingleCacheMapUtil.INSTANCE.getInstance().containsKey(key + s.substring(offset))) {
            return SingleCacheMapUtil.INSTANCE.getInstance().get(key + s.substring(offset));
        }

        List<String> resultList = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = getBreakResult(key, s, wordDict, offset + word.length());
                for (String str : next) {
                    resultList.add((word + " " + str).trim());
                }
            }
        }
        if(!resultList.isEmpty()) SingleCacheMapUtil.INSTANCE.getInstance().put(key + s.substring(offset), resultList);
        return resultList;
    }


}
