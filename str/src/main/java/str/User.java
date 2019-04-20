package str;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
// @Table(name="t_user")//���� Ĭ�ϲ�д�Ļ� ��������
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
    @GeneratedValue()//Ĭ��native @GeneratedValue()
    //@GeneratedValue(generator = "x") //  ʹ��uuid id�����ͱ�����String����
    //@GenericGenerator(name = "x", strategy = "uuid") // ʹ��hibernate��uuid����
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

    @Column(length = 10, nullable = false)//nullable���ԣ�Ĭ����true  �����ֵ
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