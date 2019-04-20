package str;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
// @Table(name="t_user")//表名 默认不写的话 就是类名
public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private Date bornDate;

    public User() {
    }

    public User(int id, String username, String password, String nickname, Date bornDate) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    public User(String username, String password, String nickname, Date bornDate) {
        super();
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.bornDate = bornDate;
    }

    @Id
    @GeneratedValue()//默认native @GeneratedValue()
    //@GeneratedValue(generator = "x") //  使用uuid id的类型必须是String类型
    //@GenericGenerator(name = "x", strategy = "uuid") // 使用hibernate的uuid策略
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(length = 5, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 10, nullable = false)//nullable属性：默认是true  允许空值
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 5, nullable = true)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "born_date")
    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
                + ", bornDate=" + bornDate + "]";
    }

}