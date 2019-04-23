package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.ProductService;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.entity.product.OSpec;
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
                List<OSpec> specslist=product.getSpecs();

                if (specslist.get(0).getOnShelf()==1){
                    productmsg.put("isValid","已上架");
                }else {
                    productmsg.put("isValid","已下架");
                }
                productmsg.put("recentPopularity",product.getRecentPopularity());
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
        if (pid!=null){
            map.put("pid",pid);
        }
        try {
            List<OCategory> categories=productService.getallCategories();
            map.put("categories",categories);
        } catch (ServiceException e) {
            logger.warn("获取商品分类出错",e);
        }
        return "productupdate";
    }

    @RequestMapping(value = "/productupdate/update")
    public String updateproduct(String pid,String categorie,String proname,String promsg,String price,String stock,String maxstock,ModelMap map){
//        logger.info(danhang+"::"+proname+"::"+promsg+"::"+price+"::"+stock+"::"+maxstock);
        if (pid==null) {
            try {
                logger.info("asdasdadad");
                categorie = categorie.replace(",", "");
                productService.createproduct(categorie, proname, promsg, price, stock, maxstock);
            } catch (ServiceException e) {
                logger.warn("添加商品数据出错", e);
            }
        }else {
            try {
                logger.info("asdasdadad");
                categorie = categorie.replace(",", "");
                pid=pid.replace(",", "");
                productService.updateproduct(pid,categorie, proname, promsg, price, stock, maxstock);
            } catch (ServiceException e) {
                logger.warn("修改商品数据出错", e);
            }
        }
        return toupdateproduct(null,map);
    }

}
