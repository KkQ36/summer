package com.kq.service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kq
 * 2024-07-07 13:44
 **/
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "k");
        hashMap.put("10002", "q");
        hashMap.put("10003", "q");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
