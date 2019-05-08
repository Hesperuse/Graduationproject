package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.Service.OrderService;
import cn.edu.zucc.graduationproject.Service.ShopMsgService;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import cn.edu.zucc.graduationproject.util.GsonHelper;
import eleme.openapi.sdk.api.entity.order.OrderList;
import eleme.openapi.sdk.api.entity.shop.OShop;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class shopDiagramController {
    private final static Logger logger = LoggerFactory.getLogger(shopDiagramController.class);
    @Autowired
    ElmUtil elmUtil;
    @Autowired
    OrderService orderService;
    @Autowired
    ShopMsgService shopMsgService;
    @RequestMapping(value = "/shopdiagram")
    public String getshopDiagramdata(ModelMap map){
        OShop oShop=null;
        try {
            oShop=shopMsgService.getshopmsg(ElemeConfig.SANDBOX_STORE_ID);
        } catch (ServiceException e) {
            logger.warn("获取店铺信息出错",e);
        }
        if (oShop!=null){
            List<Short> shortlist=oShop.getNumRatings();
            List<Map<String,Object>> shortmap=new ArrayList<>();
            for(int i=0;i<shortlist.size();i++){
                Map<String,Object> shortmsg=new TreeMap<>();
                shortmsg.put("value",shortlist.get(i));
                shortmsg.put("name",(i+1)+"星评价");
                shortmap.add(shortmsg);
            }
            map.put("numRatings",GsonHelper.toJson(shortmap));
        }
        List<String> datelist=null;
        try {
            datelist= elmUtil.getdaylistbeforetoday(7);
        } catch (ParseException e) {
            logger.warn("获取时间列表出错",e);
        }
        List<Integer> totalorder=new ArrayList<>();
        if (datelist!=null){
            String datejson= GsonHelper.toJson(datelist);
            map.put("datejson",datejson);
            for (int i=0;i<datelist.size();i++) {
                OrderList orderlist = new OrderList();
                try {
                    orderlist = orderService.getAllOrder(datelist.get(i));
                } catch (Exception e) {
                    logger.warn("获取全部订单出错", e);
                }
                if (orderlist!=null){
                    int total=orderlist.getTotal();
                    if (total!=0){
                        totalorder.add(total);
                    }else{
                        totalorder.add(0);
                    }
                }
            }
            String json= GsonHelper.toJson(totalorder);
            map.put("totalorder",json);
        }
        return "shopdiagram";
    }
}
