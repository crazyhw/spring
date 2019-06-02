package pioneer.seahorse.distribution.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pioneer.seahorse.base.service.GenericGenerator;
import pioneer.seahorse.distribution.domain.Order;
import pioneer.seahorse.distribution.domain.Deliveryclerk;

public class DeliveryclerkGenerator extends GenericGenerator {

    OrderManager orderManager;
    DeliveryclerkManager deliveryclerkManager;

    @Autowired
    public void setDeliveryclerkManager(DeliveryclerkManager deliveryclerkManager) {
        this.deliveryclerkManager = deliveryclerkManager;
    }

    @Autowired
    public void setOrderManagerManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @Test
    public void AddDeliveryclerk() {
        for (int i = 0; i < 3; i++) {
            Deliveryclerk deliveryclerk = new Deliveryclerk();
            deliveryclerk.setName("deliveryclerk_" + i);
            this.deliveryclerkManager.save(deliveryclerk);
            for (int j = 0; j < 3; j++) {
                Deliveryclerk subdeliveryclerk = new Deliveryclerk();
                subdeliveryclerk.setName("subdeliveryclerk_" + i + "_" + j);
                subdeliveryclerk.setParent(deliveryclerk);
                this.deliveryclerkManager.save(subdeliveryclerk);
                this.AddOrder(deliveryclerk);
            }
        }
    }
    public void AddOrder(Deliveryclerk deliveryclerk) {
        for (int i = 0; i < 3; i++) {
            Order order = new Order();
            order.setName("order_" + i);
            order.setCount(i + 10);
            order.setOrderno("order_"+i);
            order.setPrice(100);
            this.orderManager.save(order);
        }
    }
}
