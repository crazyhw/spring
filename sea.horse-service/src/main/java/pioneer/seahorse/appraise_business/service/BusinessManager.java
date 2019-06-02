package pioneer.seahorse.appraise_business.service;


import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.service.GenericTreeManager;

import java.util.List;

public interface BusinessManager extends GenericTreeManager<Business, Long> {
    List<Business> getAll();
}