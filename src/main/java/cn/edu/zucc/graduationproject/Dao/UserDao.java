package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface  UserDao extends JpaRepository<User, String> {

    @Query(value = "SELECT userid FROM adm_user", nativeQuery = true)
    public List<String> getalluser();

    @Query(value = "SELECT password FROM adm_user WHERE userid=?", nativeQuery = true)
    public String findpasswordbyid(String userid);

    @Modifying
    @Transactional
    @Query(value = "insert into adm_user value(?,?)", nativeQuery = true)
    public void countUser(String userid, String password);

    @Modifying
    @Transactional
    @Query(value = "update adm_user u set u.password=? where u.userid=?", nativeQuery = true)
    public void updateuser(String password,String userid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM adm_user WHERE adm_user.userid=?1", nativeQuery = true)
    public void deleteuser(String userid);
}
