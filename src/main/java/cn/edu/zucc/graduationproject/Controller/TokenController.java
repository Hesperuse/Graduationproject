package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.util.ElmUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TokenController {
    @RequestMapping(value = "/tokenmanager")
    public String tokenmanager(ModelMap map){
        eleme.openapi.sdk.config.Config config1 = ElmUtil.getConfig(true);
		String url= ElmUtil.getAuthUrl(config1);
		map.put("tokenurl",url);
        return "tokenmanager";
    }
}
