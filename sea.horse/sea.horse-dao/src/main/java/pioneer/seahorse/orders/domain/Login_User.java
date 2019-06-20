package pioneer.seahorse.orders.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Gd_Login_User")
//@OneToMany()

public class Login_User extends BaseEntity {

    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<ordrs> ordrs;

    @Column(name = "Login_EMAIL")

    String email;

    @Column(name = "Login_USERNAME")
    String username;
    @Column(name = "Login_PASSWORD")
    String password;

    public Login_User()
    {

    }

    public Set getOrdrs()
    {


        return ordrs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(String s) {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
