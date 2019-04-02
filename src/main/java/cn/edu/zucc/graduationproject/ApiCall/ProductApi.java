package cn.edu.zucc.graduationproject.ApiCall;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.entity.product.QueryPage;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.api.service.ProductService;
import eleme.openapi.sdk.oauth.response.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        queryPage.setLimit(10L);
        List<OItem> productlist=null;
        try {
            productlist = productService.queryItemByPage(queryPage);
        }catch (Exception e){
            logger.warn("获取所有商品信息出错",e);
        }
        return productlist;
    }



}
