package cn.edu.zucc.graduationproject.JavaBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "token")
public class Token {
    @Id
    private String accesstoken;
    @Column(name = "tokentype")
    private String tokenType;
    @Column(name = "expires")
    private long expires;
    @Column(name = "refreshtoken")
    private String refreshToken;
    @Column(name = "date")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccessToken() {
        return accesstoken;
    }

    public void setAccessToken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
