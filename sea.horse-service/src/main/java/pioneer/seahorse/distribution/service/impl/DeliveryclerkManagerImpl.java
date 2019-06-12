package pioneer.seahorse.distribution.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.distribution.dao.DeliveryclerkDao;
import pioneer.seahorse.distribution.domain.Deliveryclerk;
import pioneer.seahorse.distribution.service.DeliveryclerkManager;

import java.util.List;
/**
 *
 * @author 郭万江
 * @Date  2019/5/5 16:11
 *
 */
@Service(value = "deliveryclerkManager")
public class DeliveryclerkManagerImpl extends GenericTreeManagerImpl<Deliveryclerk, Long> implements DeliveryclerkManager {

    DeliveryclerkDao deliveryclerkDao;

    @Autowired
    public void setDeliveryclerkDaoDao(DeliveryclerkDao deliveryclerkDao) {
        this.deliveryclerkDao = deliveryclerkDao;
        this.treeDao = this.deliveryclerkDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Deliveryclerk> getAll() {
        List<Deliveryclerk> all = this.deliveryclerkDao.findAll();
        return all;
    }
}
