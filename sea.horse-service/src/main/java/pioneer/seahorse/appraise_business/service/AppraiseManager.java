package pioneer.seahorse.appraise_business.service;

import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.service.GenericManager;

import java.util.List;

public interface AppraiseManager extends GenericManager<Appraise, Long> {

    List<Appraise> getAll();

}

