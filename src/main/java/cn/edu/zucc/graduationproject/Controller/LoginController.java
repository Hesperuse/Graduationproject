package cn.edu.zucc.graduationproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(ModelMap map){
        String hello="helloword I'm CJC";
        map.put("hello",hello);
        return "login";
    }
}