package pioneer.seahorse.cargo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericManagerImpl;
import pioneer.seahorse.cargo.dao.CargoDao;
import pioneer.seahorse.cargo.domain.Cargo;
import pioneer.seahorse.cargo.domain.Shelves;
import pioneer.seahorse.cargo.service.CargoManager;
import pioneer.seahorse.cargo.service.ShelvesManager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * CargoManager 类
 *
 * @author 任鑫意
 * @date 2019/6/21 19:15
 */
@Service("cargoManager")

public class CargoManagerImpl extends GenericManagerImpl<Cargo, Long> implements CargoManager {

    CargoDao cargoDao;
    ShelvesManager shelvesManager;

    @Autowired
    public void setCargoDao(CargoDao cargoDao) {
        this.cargoDao = cargoDao;
        this.dao = this.cargoDao;
    }
    @Autowired
    public void setShelvesManager(ShelvesManager shelvesManager) {
        this.shelvesManager=shelvesManager;
    }


    @Override
    public List<Cargo> getAll() {
        this.shelvesManager.updata();
        List<Cargo> result = this.dao.findAll();
        return result;
    }

    @Override
    public Cargo findbyCargoId(Long id) {
        Cargo cargo = null;
        List<Cargo> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                cargo=all.get(i);
        }
        return cargo;
    }

    @Override
    public Cargo findbyCargoName(String name) {
        Cargo cargo = null;
        List<Cargo> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                cargo=all.get(i);
        }
        return cargo;
    }

    @Override
    public Boolean deletebyCargoId(Long id) {
        Optional<Cargo> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

    @Override
    public Boolean AddCargo(Cargo cargo){
        String name=cargo.getShelves().getName();
        Shelves shelves=this.shelvesManager.findbyShelvesName(name);
        cargo.setShelves(shelves);
        this.save(cargo);
        shelves.getCargos().add(cargo);
        this.shelvesManager.reduce(shelves);
        return true;
    }

    @Override
    public Boolean UpdataCargo(Cargo cargo){
        Shelves shelves=this.shelvesManager.findbyShelvesName(cargo.getShelves().getName());
        Cargo cg=this.findbyCargoId(cargo.getId());
        cg.setName(cargo.getName());
        cg.setNum(cargo.getNum());
        cg.setPrice(cargo.getPrice());
        cg.setNumber(cargo.getNumber());
        cg.setShelves(shelves);
        cg.setDateModified(new Date());
        this.save(cg);
        shelves.getCargos().add(cg);
        return true;
    }

    @Override
    public Boolean DeleteCargo(Long id){
        Cargo cargo=this.findbyCargoId(id);
        Shelves shelves=this.shelvesManager.findbyShelvesName(cargo.getShelves().getName());
        Boolean bool=this.deletebyCargoId(id);
        Iterator<Cargo> it = shelves.getCargos().iterator();
        while (it.hasNext()) {
            Cargo str = it.next();
            if (cargo.getId().equals(str.getId())) {
                it.remove();
            }
        }
        this.shelvesManager.reduce(shelves);
        return bool;
    }
}
