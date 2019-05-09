package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.JavaBean.User;
import cn.edu.zucc.graduationproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/usermanager")
    public String getAlluser(ModelMap map){
        List<String> userList=userService.getalluser();
        if (userList!=null){
            map.put("userlist",userList);
        }
        return "usermanager";
    }

    @RequestMapping(value = "/userupdate")
    public String tochangeuser(String userid,ModelMap map){
        if (userid!=null){
            map.put("userid",userid);
        }
        return "usermsgupdate";
    }

    @RequestMapping(value = "/userupdate/update")
    public String changeuser(String userid,String password,String operation,ModelMap map){
        if ("admin".equals(userid)&&"add".equals(operation)){
            map.put("errormsg","不允许新增管理员账户");
        }
        userService.changeuser(userid,password);
        return getAlluser(map);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteuser")
    public void deleteuser(String userid,ModelMap map){
        userService.deleteuser(userid);
    }
}
