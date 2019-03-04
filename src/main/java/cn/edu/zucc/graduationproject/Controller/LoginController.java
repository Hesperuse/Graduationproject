package cn.edu.zucc.graduationproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(ModelMap map){
        String hello="helloword i'm cjc-cjc1111111122222222";
        map.put("hello",hello);
        return "login";
    }
}