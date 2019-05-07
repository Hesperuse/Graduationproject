package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.ApiCall.ProductApi;
import cn.edu.zucc.graduationproject.util.ElmUtil;
import eleme.openapi.sdk.api.entity.product.OCategory;
import eleme.openapi.sdk.api.entity.product.OItem;
import eleme.openapi.sdk.api.exception.ServiceException;
import eleme.openapi.sdk.oauth.response.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductApi productApi;
    public List<OItem> getallproduct(){
        List<OItem> productlist=productApi.getallproduct();
        return productlist;
    }

    public void deleteproduct(String id) throws ServiceException {
        productApi.deleteproductbyid(id);
    }

    public List<OCategory> getallCategories() throws ServiceException {
        return productApi.getallCategory();
    }

    public void createproduct(String categorie,String proname,String promsg,String price,String stock,String maxstock) throws ServiceException {
        productApi.createproduct(Long.parseLong(categorie),proname,promsg,Double.parseDouble(price),Integer.parseInt(stock),Integer.parseInt(maxstock));
    }

    public void updateproduct(String pid,String categorie,String proname,String promsg,String price,String stock,String maxstock) throws ServiceException {
        productApi.updateproduct(Long.parseLong(pid),Long.parseLong(categorie),proname,promsg,Double.parseDouble(price),Integer.parseInt(stock),Integer.parseInt(maxstock));
    }

    public String uploadimage(String img) throws ServiceException {
        String hashvalue=productApi.uploadimg(img);
        return hashvalue;
    }

}
