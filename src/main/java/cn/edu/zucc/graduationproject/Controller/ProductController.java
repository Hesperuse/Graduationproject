package cn.edu.zucc.graduationproject.Controller;

import cn.edu.zucc.graduationproject.Service.ProductService;
import cn.edu.zucc.graduationproject.util.GsonHelper;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.entity.product.OSpec;
import eleme.openapi.sdk.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.xml.ws.http.HTTPException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class ProductController {
    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    private Map<String,String> imghashmap=new ConcurrentHashMap<>();

    public Map<String, String> getImghashmap() {
        return imghashmap;
    }

    public void setImghashmap(Map<String, String> imghashmap) {
        this.imghashmap = imghashmap;
    }

    @Autowired
    ProductService productService;
    @RequestMapping(value = "/productmanage")
    public String ProductManage(String proid,ModelMap map){
        logger.info("Start");
        List<OItem> productlist=productService.getallproduct();
        logger.info("End");
        List<Map<String,Object>> productmsglist=new ArrayList<>();
        if (productlist!=null){
            for (int i=0;i<productlist.size();i++){
                OItem product=productlist.get(i);
                Map<String,Object> productmsg=new HashMap<>();
                productmsg.put("id",product.getId()+"");
                if (proid!=null&&!proid.equals("")){
                    if (!proid.equals(product.getId()+"")){
                        continue;
                    }
                }
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
    public String toupdateproduct(String pid,String name,String description,ModelMap map){
        if (pid!=null){
            map.put("pid",pid);
        }
        if (name!=null){
            map.put("name",name);
        }
        if (description!=null){
            map.put("description",description);
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
        if (pid!=null){
            map.put("pid",pid);
        }
        if (proname!=null){
            map.put("name",proname);
        }
        if (promsg!=null){
            map.put("description",promsg);
        }
        if (pid==null||"".equals(pid)) {
            try {
//                logger.info("asdasdadad");
                categorie = categorie.replace(",", "");
                if ("".equals(proname)||"".equals(promsg)||"".equals(price)||"".equals(stock)||"".equals(maxstock)){
                    map.put("errormsg","有参数为空添加出错");
                    return toupdateproduct(null,null,null,map);
                }
                productService.createproduct(categorie, proname, promsg, price, stock, maxstock);
            } catch (ServiceException e) {
                logger.warn("添加商品数据出错", e);
            }
        }else {
            try {
//                logger.info("asdasdadad");
                categorie = categorie.replace(",", "");
                pid=pid.replace(",", "");
                if ("".equals(proname)||"".equals(promsg)||"".equals(price)||"".equals(stock)||"".equals(maxstock)){
                    map.put("errormsg","有参数为空修改出错");
                    return toupdateproduct(null,null,null,map);
                }
                productService.updateproduct(pid,categorie, proname, promsg, price, stock, maxstock);
            } catch (ServiceException e) {
                logger.warn("修改商品数据出错", e);
            }
        }
        return toupdateproduct(null,null,null,map);
    }

    @ResponseBody
    @RequestMapping(value = "/imageupload")
    public String uploadimg(String pid,MultipartFile file){
//logger.info("商品ID商品ID商品ID商品ID"+pid);
        File f = null;
        try {
            f=File.createTempFile("tmp", null);
            file.transferTo(f);
            f.deleteOnExit();     //使用完成删除文件
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String base64=null;
        byte[] buffer = new byte[(int) f.length()];
        try {
            inputFile.read(buffer);
            inputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        base64=new BASE64Encoder().encode(buffer);
        String encoded = base64.replaceAll("[\\s*\t\n\r]", "");
        String hashvalue=null;
        if (encoded!=null) {
            try {
                hashvalue=productService.uploadimage(encoded);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        Map<String,String> msg=new HashMap<>();
        if (hashvalue!=null){
            msg.put("msg", "上传图片成功");
            if (pid!=null) {
                imghashmap.put(pid,hashvalue);
            }else{
                imghashmap.put("新增图片",hashvalue);
            }
        }else{
            msg.put("msg","上传图片失败");
        }
        String str= GsonHelper.toJson(msg);
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/upandlowshelf")
    public String upandlowshelfproduct(String pid,String state){
        if (pid==null){
            return "出错！商品编号不能为空";
        }
        if (state!=null){
            if ("已上架".equals(state)){
                try {
                    productService.lowproduct(pid);
                } catch (ServiceException e) {
                    logger.warn("商品下架出错",e);
                }
            }
            if ("已下架".equals(state)){
                try {
                    productService.upproduct(pid);
                } catch (ServiceException e) {
                    logger.warn("商品上架出错",e);
                }
            }
        }
        return "";
    }

}
