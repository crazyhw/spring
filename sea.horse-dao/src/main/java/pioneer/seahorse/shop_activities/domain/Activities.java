package pioneer.seahorse.shop_activities.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:23
 */
@Entity
@Table(name = "SH_Activities")
public class Activities extends BaseEntity {

    private static final long serialVersionUID = -7381157097295901181L;

    @Column(name="num")
    String num;
    @Column(name="type")
    String type;
    @Column(name = "content")
    String content;
    @Column(name = "date")
    String date;

    @ManyToOne
    @JoinColumn(name = "shop_ID")
    Shop shop;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
