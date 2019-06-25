package pioneer.seahorse.cargo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.cargo.dao.ShelvesDao;
import pioneer.seahorse.cargo.domain.Shelves;
import pioneer.seahorse.cargo.service.ShelvesManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * ShelvesManager 类
 *
 * @author 任鑫意
 * @date 2019/6/21 19:15
 */
@Service(value = "shelvesManager")
public class ShelvesManagerImpl extends GenericTreeManagerImpl<Shelves, Long> implements ShelvesManager {
    ShelvesDao shelvesDao;

    @Autowired
    public void setShelvesDaoDao(ShelvesDao shelvesDao) {
        this.shelvesDao = shelvesDao;
        this.treeDao = this.shelvesDao;
        this.dao = this.treeDao;
    }

    @Override
    public List<Shelves> getAll() {
        List<Shelves> all = this.shelvesDao.findAll();
        return all;
    }

    @Override
    public Boolean addShelves( Shelves shelves){
        shelves.setNumber(shelves.getSum());
        this.save(shelves);
        return true;
    }

    @Override
    public Shelves findbyShelvesId(Long id) {
        Shelves shelves = null;
        List<Shelves> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                shelves=all.get(i);
        }
        return shelves;
    }

    @Override
    public Shelves findbyShelvesName(String name) {
        Shelves shelves = new Shelves();
        List<Shelves> all = this.dao.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getName().equals(name))
                shelves = all.get(i);
        }
        return shelves;
    }

    @Override
    public Boolean deletebyShelvesId(Long id) {
        Optional<Shelves> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }

    @Override
    public Boolean UpdataShelves(Shelves shelves){
        Shelves shelve=this.findbyShelvesId(shelves.getId());
        shelve.setName(shelves.getName());
        shelve.setSum(shelves.getSum());
        shelve.setCargos(shelves.getCargos());
        shelve.setDateModified(new Date());
        this.save(shelve);
        return true;
    }

    @Override
    public void reduce(Shelves shelves){
        Integer x=shelves.getCargos().size();
        shelves.setNumber(shelves.getSum()-x);
        shelves.setDateModified(new Date());
        this.dao.save(shelves);
    }

    @Override
    public void updata(){
        List<Shelves> shelves=this.dao.findAll();
        for (int i=0;i<shelves.size();i++){
            this.reduce(shelves.get(i));
        }
    }
}
