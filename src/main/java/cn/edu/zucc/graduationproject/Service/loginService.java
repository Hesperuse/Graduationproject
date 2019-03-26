package cn.edu.zucc.graduationproject.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService{
    @Autowired
    cn.edu.zucc.graduationproject.Dao.UserDao UserDao;
    public String checkpassword(String password,String userid){
        if (userid!=""&&password!="") {
            String passwordbymysql = UserDao.findpasswordbyid(userid);
            if (passwordbymysql.equals(password)){
                return "登录成功";
            }else{
                return "密码错误";
            }
        }else {
         return "用户名或者密码为空";
        }
    }
}
