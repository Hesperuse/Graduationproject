package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ShopService;
import eleme.openapi.sdk.oauth.response.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopMsgService {
    @Autowired
    ElmUtil elmUtil;
    public OShop getshopmsg(long shopId) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ShopService shopService = new ShopService(config, token);
        OShop oShop=shopService.getShop(shopId);
        return oShop;
    }
}
