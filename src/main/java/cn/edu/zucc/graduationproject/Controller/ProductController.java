package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.ProductService;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
//        if (productlist!=null){
//            for (int i=0;i<productlist.size();i++){
//                OItem product=productlist.get(i);
//                Map<String,Object> productmsg=new HashMap<>();
//                productmsg.put("id",product.getId());
//                productmsg.put("name",product.getName());
//                productmsg.put("imgurl",product.getImageUrl());
//                productmsg.put("name",product.getName());
//                productmsg.put("name",product.getName());
//                productmsg.put("name",product.getName());
//
//            }
//        }
        map.put("productmanage",productlist);
        return "productmanage";
    }

    @ResponseBody
    @RequestMapping(value = "/productmanage/deletepro")
    public void  deleteproduct(String pid){
        try {
            productService.deleteproduct(pid);
        } catch (ServiceException e) {
            logger.warn("商品删除失败",e);
        }
    }

}
