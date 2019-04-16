package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.OrderService;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import cn.edu.zucc.graduationproject.util.GsonHelper;
import eleme.openapi.sdk.api.entity.order.OrderList;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderManager {
    private final static Logger logger = LoggerFactory.getLogger(OrderManager.class);
    @Autowired
    ElmUtil elmUtil;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/ordermanager")
    public String getallorder(String date, ModelMap map){
        if (date==null){
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date=sdf.format(nowdate);
        }
        OrderList orderlist=new OrderList();
        try{
            orderlist=orderService.getAllOrder(date);
        }catch (Exception e){
            logger.warn("获取全部订单出错",e);
        }
        map.put("orderlist", GsonHelper.toJson(orderlist));
        return "ordermanager";
    }
}
