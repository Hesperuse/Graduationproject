package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.OrderService;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.order.OrderList;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderManager {
    private final static Logger logger = LoggerFactory.getLogger(OrderManager.class);
    @Autowired
    ElmUtil elmUtil;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/ordermanager")
    public String getallorder(String date){
        OrderList orderlist=new OrderList();
        try{
            orderlist=orderService.getAllOrder(date);
        }catch (Exception e){
            logger.warn("获取全部订单出错",e);
        }
        return "";
    }
}
