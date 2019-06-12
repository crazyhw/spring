package pioneer.seahorse.distribution.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.distribution.domain.Deliveryclerk;
import java.util.List;
/**
 *
 * @author 郭万江
 * @Date  2019/5/5 16:11
 *
 */
public interface DeliveryclerkManager extends GenericTreeManager<Deliveryclerk, Long> {
    List<Deliveryclerk> getAll();
}
