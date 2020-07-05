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
       String string1 = StringEscapeUtils.unescapeJava(string);
        String[] part = string1.split("\"");
        String url = part[4];
        System.out.println(url);
        String ret = null;
        String passward = "3457844";
        map.put(url, passward);
        ret = url+"\n"+map.get(url);

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
