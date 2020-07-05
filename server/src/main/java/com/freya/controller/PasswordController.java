package com.freya.controller;



import com.freya.entity.User;

import org.springframework.web.bind.annotation.*;


import java.util.LinkedHashMap;
import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PasswordController {

    public Map<String, String> map = new LinkedHashMap<String, String>();

    @RequestMapping(value = "log", method = RequestMethod.POST)

    public String ToPicture(@RequestBody String string) {
        String[] part = string.split("\"");
        String url = part[4];
//        String[] aa = url.split("\'");
//        System.out.println(aa[0]);
//        System.out.println(aa[1]);
//        String url = string;
        System.out.println(url);
        String ret = null;
        String passward = "3457844";
        map.put(url, passward);
        for (String key : map.keySet()) {

           ret = map.get(key);
        }

        return ret;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)

    public String login(@RequestBody User user) {
        String password = user.getPassword();
        System.out.println(password);
        int num = 1;

        for (String key : map.keySet()) {

            if ((map.get(key)).equals(password)) {

                return "success";
            }
        }
        return "error";
    }

}
