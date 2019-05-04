package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.OrderService;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import cn.edu.zucc.graduationproject.util.GsonHelper;
import eleme.openapi.sdk.api.entity.order.OGoodsItem;
import eleme.openapi.sdk.api.entity.order.OOrder;
import eleme.openapi.sdk.api.entity.order.OrderList;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OrderManager {
    private final static Logger logger = LoggerFactory.getLogger(OrderManager.class);
    @Autowired
    ElmUtil elmUtil;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/ordermanager")
    public String getallorder(String date, String orderid,ModelMap map){
        if (date==null){
            Date nowdate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date=sdf.format(nowdate);
        }
        map.put("date",date);
        OrderList orderlist=new OrderList();
        try{
            orderlist=orderService.getAllOrder(date);
        }catch (Exception e){
            logger.warn("获取全部订单出错",e);
        }
        List<Map<String,Object>> ordermsglist=new ArrayList<>();
        List<Map<String,Object>> ordermsgmap=new ArrayList<>();
        if(orderlist!=null){
            for (int i=0;i<orderlist.getList().size();i++){
                OOrder oOrder=orderlist.getList().get(i);

                Map<String,Object> ordermsg=new HashMap<>();
                ordermsg.put("orderid",oOrder.getId());

                Map<String,Object> nameandprice=new HashMap<>();
                for (int j=0;j<oOrder.getGroups().get(0).getItems().size();j++){
                    OGoodsItem items=oOrder.getGroups().get(0).getItems().get(j);
                    nameandprice.put(items.getName(),items.getQuantity());
                }

                ordermsg.put("nameandprice",nameandprice);
                ordermsg.put("address",oOrder.getAddress());
                if (oOrder.getDeliverTime()!=null) {
                    ordermsg.put("deliverTime", oOrder.getDeliverTime().toString());
                }else{
                    ordermsg.put("deliverTime", "暂无预估时间");
                }
                ordermsglist.add(ordermsg);
            }
            if (orderid!=null){
                if (!"".equals(orderid)){
                    for (int i=0;i<ordermsglist.size();i++){
                        if (ordermsglist.get(i).get("orderid").equals(orderid)){
                            ordermsgmap.add(ordermsglist.get(i));
                        }
                    }
                    map.put("orderlist",ordermsgmap);
                }else{
                    map.put("orderlist",ordermsglist);
                }
                return "ordermanager";
            }
        }
        map.put("orderlist",ordermsglist);
        return "ordermanager";
    }

    @RequestMapping(value = "/ordermsg")
    public String getordermsgbyid(String orderid,ModelMap map){
        if (orderid!=null){
            OOrder oOrder=new OOrder();
            try {
                oOrder=orderService.getOrderByid(orderid);
            } catch (ServiceException e) {
                logger.warn("获取单个订单详细信息出错");
            }
            Map<String,Object> ordermsg=new HashMap<>();
            if (oOrder!=null){
                ordermsg.put("orderid",oOrder.getId());

                Map<String,Object> nameandprice=new HashMap<>();
                for (int j=0;j<oOrder.getGroups().get(0).getItems().size();j++){
                    OGoodsItem items=oOrder.getGroups().get(0).getItems().get(j);
                    nameandprice.put(items.getName(),items.getQuantity());
                }

                ordermsg.put("nameandprice",nameandprice);
                ordermsg.put("address",oOrder.getAddress());

                Map<String,String> timemap=new HashMap<>();
                if (oOrder.getDeliverTime()!=null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    timemap.put("预估时间", sdf.format(oOrder.getDeliverTime()));
                }else{
                    timemap.put("预估时间", "暂无预估时间");
                }
                if (oOrder.getCreatedAt()!=null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    timemap.put("下单时间", sdf.format(oOrder.getCreatedAt()));
                }else{
                    timemap.put("下单时间", "暂无下单时间");
                }
                if (oOrder.getActiveAt()!=null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    timemap.put("订单生效时间", sdf.format(oOrder.getActiveAt()));
                }else{
                    timemap.put("订单生效时间", "暂无生效时间");
                }
                ordermsg.put("timemap",timemap);
                ordermsg.put("income",oOrder.getIncome());
            }
            map.put("orderlist",ordermsg);
        }
        return "ordermsg";
    }

    @RequestMapping(value = "/sureorder")
    public void sureorder(String orderid){
    }

    @RequestMapping(value = "/cancelorder")
    public void cancelorder(String orderid){
    }
}
