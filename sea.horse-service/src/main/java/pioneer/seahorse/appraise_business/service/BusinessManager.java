package pioneer.seahorse.appraise_business.service;


import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.service.GenericTreeManager;

import java.util.List;
/**
 *
 * @author 杨留阳
 * @Date  2019/4/25 15:33
 *
 */
public interface BusinessManager extends GenericTreeManager<Business, Long> {

    List<Business> getAll();

    Boolean deletebyBusinessId(Long id);

    Business findbyBusinessId(Long id);

    Business findbyBusinessName(String name);

    Business updateBusiness(Business business);
}