package com.spartajet.iotdemoserver.user;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type User token map.
 *
 * @author spartajet
 * @description
 * @create 2018 -05-15 下午3:49
 * @email spartajet.guo @gmail.com
 */
@Service
public class UserTokenMap {
    /**
     * The Map.
     */
    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();


    /**
     * Get user token string.
     *
     * @param userName the userName
     * @return the string
     */
    public String getUserToken(String userName) {
        String token = this.map.get(userName);
        if (token == null) {
            token = UUID.randomUUID().toString();
            this.map.put(userName, token);
        }
        return token;
    }

    /**
     * Cancel user.
     *
     * @param username the id
     */
    public void cancelUser(String username) {
        this.map.remove(username);
    }

    /**
     * Get user by token string.
     *
     * @param token the token
     * @return the string
     */
    public String getUserByToken(String token) {
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            if (val.equals(token)) {
                return key;
            }
        }
        return null;
    }
}
