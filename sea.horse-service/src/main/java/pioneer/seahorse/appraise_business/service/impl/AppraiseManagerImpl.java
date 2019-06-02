package pioneer.seahorse.appraise_business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.appraise_business.dao.AppraiseDao;
import pioneer.seahorse.appraise_business.domain.Appraise;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.appraise_business.service.AppraiseManager;
import java.util.List;

    @Service("appraiseManager")
    public class AppraiseManagerImpl extends GenericManagerImpl<Appraise, Long> implements AppraiseManager {


        @Autowired
        public void setAppraiseDao(AppraiseDao appraiseDao) {
            this.appraiseDao = appraiseDao;
            this.dao = this.appraiseDao;
        }

        AppraiseDao appraiseDao;


        @Override
        public List<Appraise> getAll() {
            List<Appraise> all = this.appraiseDao.findAll();
            return all;
        }

    }
