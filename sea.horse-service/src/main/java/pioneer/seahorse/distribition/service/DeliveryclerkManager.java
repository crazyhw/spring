package pioneer.seahorse.distribition.service;

import pioneer.seahorse.base.service.GenericTreeManager;
import pioneer.seahorse.distribition.domain.Deliveryclerk;

import java.util.List;


public interface DeliveryclerkManager extends GenericTreeManager<Deliveryclerk, Long> {

    List<Deliveryclerk> getAll();

    Deliveryclerk addDeliveryclerk( Deliveryclerk shelves);

    Deliveryclerk findbyDeliveryclerkId(Long id);

    Boolean deletebyDeliveryclerkId(Long id);

    Deliveryclerk findbyDeliveryclerkName(String name);

    Deliveryclerk UpdataDeliveryclerk(Deliveryclerk shelves);

}
