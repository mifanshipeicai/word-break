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


    public static List<String> wordBreak(String s, List<String> wordDict) {
        return getBreakResult(s, wordDict, 0);
    }

    private static List<String> getBreakResult(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        if (SingleCacheMapUtil.INSTANCE.getInstance().containsKey(s.substring(offset))) {
            return SingleCacheMapUtil.INSTANCE.getInstance().get(s.substring(offset));
        }

        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = getBreakResult(s, wordDict, offset + word.length());
                for (String str : next) {
                    res.add((word + " " + str).trim());
                }
            }
        }
        SingleCacheMapUtil.INSTANCE.getInstance().put(s.substring(offset), res);
        return res;
    }


}
