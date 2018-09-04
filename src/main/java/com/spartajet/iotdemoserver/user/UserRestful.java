package com.spartajet.iotdemoserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * The type User restful.
 *
 * @author spartajet
 * @description
 * @create 2018 -05-15 下午4:03
 * @email spartajet.guo @gmail.com
 */
@RestController
public class UserRestful {
    /**
     * The User token map.
     */
    private final UserTokenMap userTokenMap;

    @Autowired
    public UserRestful(UserTokenMap userTokenMap) {
        this.userTokenMap = userTokenMap;
    }

    /**
     * Login map.
     *
     * @param maps the maps
     * @return the map
     */
    @PostMapping("/user/login")
    public Map<String, Object> login(@RequestBody Map<String, Object> maps) {
        Map<String, Object> response = new HashMap<>(2);
        response.put("code", 20000);
        response.put("data", new HashMap<String, String>() {{
            put("token", userTokenMap.getUserToken((String) maps.get("username")));
        }});
        return response;
    }

    /**
     * Gets user info.
     *
     * @param token the token
     * @return the user info
     */
    @GetMapping("/user/info")
    public Map<String, Object> getUserInfo(@RequestParam("token") String token) {
        Map<String, Object> response = new HashMap<>(2);
        String name = this.userTokenMap.getUserByToken(token);
        if (name == null) {
            response.put("code", 50008);
            return response;
        } else {
            response.put("code", 20000);
            response.put("data", new HashMap<String, Object>() {{
                put("name", name);
                put("avatar", "https://file.spartajet.com/logo.jpg");
                put("roles", new String[]{"admin"});
            }});
        }
        return response;
    }

    @PostMapping("/user/logout")
    public RestResult logout(HttpServletRequest request) {
        String token=request.getHeader("X-Token");
        String username=this.userTokenMap.getUserByToken(token);
        this.userTokenMap.cancelUser(username);
        RestResult result=new RestResult();
        result.setCode(20000);
        return result;
    }
}
