package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserDao extends JpaRepository<User, Integer> {
//    public User findById(String user);
//
//    public User save(User user);

    @Query(value = "SELECT password FROM adm_user WHERE userid=?", nativeQuery = true)
    public String findpasswordbyid(String userid);
}
