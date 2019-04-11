package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.order.OrderList;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    ElmUtil elmUtil;
    public OrderList getAllOrder(String date) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        eleme.openapi.sdk.api.service.OrderService orderService = new eleme.openapi.sdk.api.service.OrderService(config, token);
        return orderService.getAllOrders(ElemeConfig.SANDBOX_STORE_ID, 1, 50, date);
    }
}
