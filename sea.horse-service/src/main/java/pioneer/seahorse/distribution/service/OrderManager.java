package pioneer.seahorse.distribution.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.distribution.domain.Order;

import java.util.List;
/**
 *
 * @author 郭万江
 * @Date  2019/5/5 16:11
 *
 */
public interface OrderManager  extends GenericManager<Order, Long> {

    List<Order> getAll();
}
