package cn.edu.zucc.graduationproject.JavaBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adm_user")
public class User {
    @Id
    private String userid;
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return userid;
    }

    public void setUser(String userid) {
        this.userid = userid;
    }
}
