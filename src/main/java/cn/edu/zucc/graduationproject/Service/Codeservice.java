package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.ApiConfig.ElemeConfig;
import cn.edu.zucc.graduationproject.Dao.CodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Codeservice {
    @Autowired
    CodeDao codeDao;


    public String getcodebyshopid(String shopid){
        return codeDao.getcodebyshopid(shopid);
    }

    public void updatecode(String code){
        codeDao.updateingredient(code, ElemeConfig.SANDBOX_STORE_ID+"");
    }

}
