package pioneer.seahorse.orders.domain;

import pioneer.seahorse.base.domain.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name="Gd_Orders")
public class ordrs extends BaseEntity {

    @ManyToOne

    Login_User   customer;

    @Column(name = "orderNo")
    private String orderNo;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "currentUnitPrice")
    private double currentUnitPrice;

    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

   // @Column(name = "totalPrice")
    //private int customer_ID;
   // @Column(name = "customer_ID")
     private String createTime;



    public String getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(Integer productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }



    public double getCurrentUnitPrice()
    {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(double currentUnitPrice)
    {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


}


