package pioneer.seahorse.distribution.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.distribution.domain.Deliveryclerk;
import java.util.List;

public interface DeliveryclerkManager extends GenericTreeManager<Deliveryclerk, Long> {
    List<Deliveryclerk> getAll();
}
