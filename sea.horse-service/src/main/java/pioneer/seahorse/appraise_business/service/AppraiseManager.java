package pioneer.seahorse.appraise_business.service;

import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.service.GenericManager;

import java.util.List;
/**
 *
 * @author 杨留阳
 * @Date  2019/4/25 15:33
 *
 */
public interface AppraiseManager extends GenericManager<Appraise, Long> {

    List<Appraise> getAll();

    Boolean deletebyAppraiseId(Long id);

    Appraise findbyAppraiseName(String name);

    Appraise findbyAppraiseId(Long id);

    Appraise addAppraise(Appraise appraise);

    Appraise updateAppraise(Appraise appraise);

}

