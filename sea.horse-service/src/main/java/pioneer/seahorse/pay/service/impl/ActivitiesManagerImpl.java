package pioneer.seahorse.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.pay.dao.ActivitiesDao;
import pioneer.seahorse.pay.domain.Activities;
import pioneer.seahorse.pay.service.ActivitiesManager;

import java.util.List;

/**
 * @author lvqingyv
 * @date 2019/6/21 19:56
 */
@Service("ActivitiesManager")

public class ActivitiesManagerImpl extends GenericManagerImpl<Activities, Long> implements ActivitiesManager {
    ActivitiesDao activitiesDao;

    @Autowired
    public void setActivitiesDao(ActivitiesDao activitiesDao) {
        this.activitiesDao = activitiesDao;
        this.dao = this.activitiesDao;
    }


    @Override
    public List<Activities> getAll() {
        List<Activities> result = this.dao.findAll();
        return result;
    }

    @Override
    public Activities findbyActivitiesId(Long id) {
        Activities activities = null;
        List<Activities> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                activities=all.get(i);
        }
        return activities;
    }

    @Override
    public Activities findbyActivitiesNum(String num) {
        Activities activities = null;
        List<Activities> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getNum().equals(num))
                activities=all.get(i);
        }
        return activities;
    }

    @Override
    public List<Activities> findbyActivitiesNameList(String name) {
        List<Activities> activities = null;
        List<Activities> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getShop().getName().equals(name))
                activities.add(all.get(i));
        }
        return activities;
    }

    @Override
    public Boolean deletebyActivitiesId(Long id) {
        this.dao.deleteById(id);
        return true;
    }

}