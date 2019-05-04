package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CodeDao extends JpaRepository<Code,String> {
    @Query(value = "SELECT code FROM code where shopid=?", nativeQuery = true)
    public String getcodebyshopid(String shopid);

    @Modifying
    @Transactional
    @Query(value = "update code u set u.code=? where u.shopid=?", nativeQuery = true)
    public void updateingredient(String code,String shopid);
}
