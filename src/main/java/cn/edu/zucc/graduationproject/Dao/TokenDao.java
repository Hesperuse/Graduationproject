package cn.edu.zucc.graduationproject.Dao;

import cn.edu.zucc.graduationproject.JavaBean.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Repository
public interface TokenDao extends JpaRepository<Token,String> {

    @Query(value = "SELECT * FROM token ", nativeQuery = true)
    public Token gettoken();

    @Modifying
    @Transactional
    @Query(value = "insert into token value(?,?,?,?,?)", nativeQuery = true)
    public void countToken(String accessToken, String tokenType, long expires, String refreshToken, Date date);

    @Modifying
    @Transactional
    @Query(value = "update token u set u.tokenType=:tokenType,u.expires=:expires,u.refreshToken=:refreshToken,u.date=:date where u.accessToken=:accessToken", nativeQuery = true)
    public void queryToken(@Param("accessToken")String accessToken, @Param("tokenType")String tokenType, @Param("expires")long expires, @Param("refreshToken")String refreshToken,@Param("date")Date date);


}
