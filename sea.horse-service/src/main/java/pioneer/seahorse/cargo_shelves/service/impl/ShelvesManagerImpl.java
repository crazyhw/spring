package pioneer.seahorse.cargo_shelves.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.cargo_shelves.dao.ShelvesDao;
import pioneer.seahorse.cargo_shelves.domain.Shelves;
import pioneer.seahorse.cargo_shelves.service.ShelvesManager;

@Service(value = "shelvesManager")
public class ShelvesManagerImpl extends GenericTreeManagerImpl<Shelves, Long> implements ShelvesManager {

    ShelvesDao shelvesDao;

    @Autowired
    public void setGropuDao(ShelvesDao shelvesDao) {
        this.shelvesDao = shelvesDao;
        this.treeDao = this.shelvesDao;
        this.dao = this.treeDao;
    }

}
