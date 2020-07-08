package com.freya.controller;



import com.freya.entity.User;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PasswordController {

    public Map<String, String> map = new LinkedHashMap<String, String>();


    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    @RequestMapping(value = "log", method = RequestMethod.POST)
    public String ToPicture(@RequestBody String string) {
        String string1 = StringEscapeUtils.unescapeJava(string);
        String[] part = string1.split("\"");
        System.out.println(string1);
        String file = part[4];///        map.clear();
        System.out.println(file);
        String ret = null;
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String passward ;
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
       passward=shortBuffer.toString();
        map.put(file, passward);
        ret = map.get(file)+"\n"+file;
        System.out.println(map.get(file));

        return ret;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)

    public String login(@RequestBody User user) {
        String password = user.getPassword();
        System.out.println(password);
        Timer timer = new Timer();// 实例化Timer类
        timer.schedule(new TimerTask() {
            public void run() {
                map.clear();
            }
        }, 10000);// 这里百毫秒
        for (String key : map.keySet()) {
            if ((map.get(key)).equals(password)) {
                return key;
            }
        }
//        Timer timer = new Timer();// 实例化Timer类
//        timer.schedule(new TimerTask() {
//            public void run() {
//                map.clear();
//            }
//        }, 5000);// 这里百毫秒
        return "error";
    }

}
