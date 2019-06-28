package pioneer.seahorse.goods.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
/**
 * Goods 类
 * @author lpl
 * 商家 -- 区域（市场）：ManyToOne
 * @Date  2019/3/24 13:28
 */
@Entity
@Table(name = "SH_Goods")

public class Goods extends BaseEntity{
    private static final long serialVersionUID = -45540597375995815L;
    @Column(name="name")
    String name;
    @Column(name="num")
    String num;
    @Column(name="number")
    String number;
    @ManyToOne(optional = false)
    @JoinColumn(name = "management_ID")
    Management management;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Management getManagement() {
        return management;
    }
    public void setManagement(Management management) {
        this.management = management;
    }
}
