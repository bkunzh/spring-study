package com.bkunzh.util;

import java.util.Map;

/**
 * @author bingkun_zhang
 * @date 2020/7/1
 */
public class MapUtil {
    /**
     * 对于只有一个key的map，获取它的key
     * @param oneKeyMap
     * @return
     */
    public static String getKeyOfOneKeyMap(Map<String, ? extends Object> oneKeyMap) {
        if (oneKeyMap.size() != 1) {
            throw new IllegalArgumentException("not oneKeyMap, size=" + oneKeyMap.size());
        }
        return oneKeyMap.keySet().iterator().next();
    }
}
