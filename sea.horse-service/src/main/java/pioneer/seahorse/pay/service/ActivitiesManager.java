package pioneer.seahorse.pay.service;

import pioneer.seahorse.base.service.GenericManager;
import pioneer.seahorse.pay.domain.Activities;

import java.util.List;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:57
 */
public interface ActivitiesManager extends GenericManager<Activities, Long> {
    List<Activities> getAll();

    Activities findbyActivitiesId(Long id);

    Boolean deletebyActivitiesId(Long id);

    Activities findbyActivitiesNum(String num);

    List<Activities> findbyActivitiesNameList(String name);
}
