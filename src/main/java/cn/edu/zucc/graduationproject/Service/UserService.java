package cn.edu.zucc.graduationproject.Service;

import cn.edu.zucc.graduationproject.Dao.UserDao;
import cn.edu.zucc.graduationproject.JavaBean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<String> getalluser(){
        return userDao.getalluser();
    }

    public void updateuser(String userid,String password){
        userDao.updateuser(password,userid);
    }

    public void adduser(String userid,String password){
        userDao.countUser(userid,password);
    }

    public void deleteuser(String userid){
        userDao.deleteuser(userid);
    }

    public void changeuser(String userid,String password){
        User user=new User();
        user.setUserid(userid);
        user.setPassword(password);
        userDao.save(user);
    }
}
