package cn.edu.zucc.graduationproject.ApiCall;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.entity.product.OSpec;
import eleme.openapi.sdk.api.entity.product.QueryPage;
import eleme.openapi.sdk.api.enumeration.product.OItemCreateProperty;
import eleme.openapi.sdk.api.enumeration.product.OItemUpdateProperty;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.oauth.response.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductApi {
    private final static Logger logger = LoggerFactory.getLogger(ProductApi.class);

    @Autowired
    ElmUtil elmUtil;

    /**
     * 获取所有商品信息
     * @return
     * @throws ServiceException
     */
    public List<OItem> getallproduct(){
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config,token);
        QueryPage queryPage = new QueryPage();
        queryPage.setShopId(ElemeConfig.SANDBOX_STORE_ID);
        queryPage.setOffset(0L);
        queryPage.setLimit(20L);
        List<OItem> productlist=null;
        try {
            productlist = productService.queryItemByPage(queryPage);
        }catch (Exception e){
            logger.warn("获取所有商品信息出错",e);
        }
        return productlist;
    }

    public void deleteproductbyid(String id) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config,token);
        productService.invalidItem(Long.parseLong(id));
    }

    public List<OCategory> getallCategory() throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        List<OCategory> categorylist=productService.getShopCategories(ElemeConfig.SANDBOX_STORE_ID);
        return categorylist;
    }

    public void createproduct(long categoryId,String proname,String promsg,double price,int stock,int maxstock) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        Map<OItemCreateProperty,Object> properties = new HashMap<OItemCreateProperty,Object>();
        properties.put(OItemCreateProperty.name,proname);
        properties.put(OItemCreateProperty.description,promsg);
//        properties.put(OItemCreateProperty.imageHash,"3077080f760e7bf0fc985e23dd3e36e2");
        List<OSpec> oSpecs = new ArrayList<OSpec>();
        OSpec oSpec = new OSpec();
        oSpec.setName("份");
        oSpec.setPrice(price);
        oSpec.setStock(stock);
        oSpec.setMaxStock(maxstock);
        oSpec.setOnShelf(1);
        oSpecs.add(oSpec);
        properties.put(OItemCreateProperty.specs,oSpecs);
        productService.createItem(categoryId, properties);
    }

    public void updateproduct(long pid,long categoryId,String proname,String promsg,double price,int stock,int maxstock) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        Map<OItemUpdateProperty,Object> properties = new HashMap<OItemUpdateProperty,Object>();
        properties.put(OItemUpdateProperty.name,proname);
        properties.put(OItemUpdateProperty.description,promsg);
//        properties.put(OItemCreateProperty.imageHash,"3077080f760e7bf0fc985e23dd3e36e2");
        List<OSpec> oSpecs = new ArrayList<OSpec>();
        OSpec oSpec = new OSpec();
        oSpec.setName("份");
        oSpec.setPrice(price);
        oSpec.setStock(stock);
        oSpec.setMaxStock(maxstock);
        oSpec.setOnShelf(1);
        oSpecs.add(oSpec);
        properties.put(OItemUpdateProperty.specs,oSpecs);
        productService.updateItem(pid,categoryId,properties);
    }

    public String uploadimg(String img) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        String hashvalue=productService.uploadImage(img);
        return hashvalue;
    }

    public String upproduct(long pid) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        List<Long> itemIds = new ArrayList<Long>();
        itemIds.add(pid);
        productService.batchListItems(itemIds);
        return "";
    }

    public String lowproduct(long pid) throws ServiceException {
        eleme.openapi.sdk.config.Config config = ElmUtil.getConfig(true);
        Token token=elmUtil.gettokenbymysql();
        ProductService productService = new ProductService(config, token);
        List<Long> itemIds = new ArrayList<Long>();
        itemIds.add(pid);
        productService.batchDelistItems(itemIds);
        return "";
    }
}
