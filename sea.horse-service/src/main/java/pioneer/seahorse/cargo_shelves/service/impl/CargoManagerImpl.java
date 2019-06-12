package pioneer.seahorse.cargo_shelves.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.cargo_shelves.dao.CargoDao;
import pioneer.seahorse.cargo_shelves.domain.Cargo;
import pioneer.seahorse.cargo_shelves.service.CargoManager;

import java.util.List;
/**
 *
 * @author 任鑫意
 * @Date  2019/4/26 17:05
 *
 */
@Service("cargoManager")
public class CargoManagerImpl extends GenericManagerImpl<Cargo, Long> implements CargoManager {


    CargoDao cargoDao;

    @Autowired
    public void setCargoDao(CargoDao cargoDao) {
        this.cargoDao = cargoDao;
        this.dao = this.cargoDao;
    }


    @Override
    public List<Cargo> getAll() {
        List<Cargo> all = this.cargoDao.findAll();
        return all;
    }

}
