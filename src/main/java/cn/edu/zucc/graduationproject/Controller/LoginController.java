package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.Configuration.WebSecurityConfig;
import cn.edu.zucc.graduationproject.Service.ShopMsgService;
import cn.edu.zucc.graduationproject.Service.loginService;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
    @Autowired
    WebSecurityConfig webSecurityConfig;
    @Autowired
    ShopMsgService shopMsgService;
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
    public String welcome(HttpSession session,ModelMap map){
        OShop oShop=null;
        try {
            oShop=shopMsgService.getshopmsg(ElemeConfig.SANDBOX_STORE_ID);
        } catch (ServiceException e) {
            logger.warn("获取店铺信息出错",e);
        }
        if (oShop!=null){
            map.put("shopstate",oShop.getIsOpen());
            map.put("deliverSpent",oShop.getDeliverSpent());
            session.setAttribute("logourl",oShop.getImageUrl());
            map.put("foodpopularity",oShop.getRecentFoodPopularity());
        }
        return "welcome";
    }

    /**
     * 登录
     */
    @Autowired
    loginService loginService;
    @RequestMapping("/loginPost")
    public String loginPost(String account, String password, HttpSession session, ModelMap map) {
        String user= (String) session.getAttribute("account");
        if (password==null&&account==null) {
            if (user!=null) {
                logger.info("用户：" + user + "已登录");
                map.put("username",user);
                return welcome(session,map);
            }else{
                return "login";
            }
        }else {
            String checkresult = loginService.checkpassword(password, account);
            if (!checkresult.equals("登录成功")) {
                map.put("success", false);
                map.put("message", checkresult);
                return "login";
            } else {
                // 设置session
                session.setAttribute("account", account);
                map.put("success", true);
                map.put("message", "登录成功");
                logger.info("用户：" + account + "登录成功");
                map.put("username",account);
                return welcome(session,map);
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