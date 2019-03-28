package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.ApiCall.ProductApi;
import eleme.openapi.sdk.api.entity.product.OItem;
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

}
