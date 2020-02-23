package com.wordbreak.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.util
 * @create 2020-02-22
 */
public enum SingleCacheMapUtil {

    INSTANCE;

    private Map<String, List<String>> cache;

    SingleCacheMapUtil() {
        cache = new ConcurrentHashMap<>();
    }

    public Map<String, List<String>> getInstance() {
        return cache;
    }


}
