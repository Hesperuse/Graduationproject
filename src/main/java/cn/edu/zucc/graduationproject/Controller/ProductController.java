package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.ProductService;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    ProductService productService;
    @RequestMapping(value = "/productmanage")
    public String ProductManage(ModelMap map){
        logger.info("Start");
        List<OItem> productlist=productService.getallproduct();
        logger.info("End");
        List<Map<String,Object>> productmsglist=new ArrayList<>();
        if (productlist!=null){
            for (int i=0;i<productlist.size();i++){
                OItem product=productlist.get(i);
                Map<String,Object> productmsg=new HashMap<>();
                productmsg.put("id",product.getId()+"");
                productmsg.put("name",product.getName());
                productmsg.put("imgurl",product.getImageUrl());
                productmsg.put("description",product.getDescription());
                productmsg.put("isValid",product.getIsValid());
                productmsg.put("name",product.getName());
                productmsglist.add(productmsg);
            }
        }
        map.put("productmanage",productmsglist);
        return "productmanage";
    }

    @ResponseBody
    @RequestMapping(value = "/productmanage/deletepro")
    public void  deleteproduct(String pid){
        try {
            productService.deleteproduct(pid);
        } catch (ServiceException e) {
            logger.warn("商品删除失败,商品编号：{}",pid,e);
        }
    }

    @RequestMapping(value = "/productupdate")
    public String toupdateproduct(String pid,ModelMap map){
        logger.info("yijinru");
        if (pid!=null){
            map.put("pid",pid);
        }
       return "productupdate";
    }


}
