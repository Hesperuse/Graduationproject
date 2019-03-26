package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Configuration.WebSecurityConfig;
import cn.edu.zucc.graduationproject.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
    @Autowired
    WebSecurityConfig webSecurityConfig;
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/")
    public String loginindex(HttpSession session) {
        String user= (String) session.getAttribute("account");
        if (user!=null) {
//            model.addAttribute("user",user);
            logger.info("用户："+user+"已登录");
            return "welcome";
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request){
        return "welcome";
    }

    /**
     * 登录
     */
    @Autowired
    loginService loginService;
    @RequestMapping("/loginPost")
    public String loginPost(String account,String password, HttpSession session,Model map) {
        String user= (String) session.getAttribute("account");
        if (user!=null&&password==null&&account==null) {
            logger.info("用户：" + user + "已登录");
            return "welcome";
        }else {
            String checkresult = loginService.checkpassword(password, account);
            if (!checkresult.equals("登录成功")) {
                map.addAttribute("success", false);
                map.addAttribute("message", checkresult);
                return "login";
            } else {
                // 设置session
                session.setAttribute("account", account);
                map.addAttribute("success", true);
                map.addAttribute("message", "登录成功");
                logger.info("用户：" + account + "登录成功");
                return "welcome";
            }
        }
    }
    /**
     * 注销登录
     *
     * @param request
     * @return
     */
    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "/login";
    }

}