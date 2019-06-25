package pioneer.seahorse.goods.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pioneer.seahorse.base.service.Impl.GenericTreeManagerImpl;
import pioneer.seahorse.goods.dao.ManagementDao;
import pioneer.seahorse.goods.domain.Management;
import pioneer.seahorse.goods.service.ManagementManager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author lpl
 * @Date  2019/4/28 14:34
 *
 */
@Service(value = "managmentManager")

public class ManagementManagerImpl extends GenericTreeManagerImpl<Management, Long> implements ManagementManager{
   ManagementDao managmentDao;

    @Autowired
    public void setManagementDao(ManagementDao managmentDao) {
        this.managmentDao = managmentDao;
        this.treeDao = this.managmentDao;
        this.dao = this.treeDao;
    }
    @Override
    public List<Management> getAll() {
        List<Management> result = this.dao.findAll();
        return result;
    }


    @Override
    public Management findbyManagementId(Long id) {
       Management managment = null;
        List<Management> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getId().equals(id))
                managment=all.get(i);
        }
        return managment;
    }

    @Override
    public Management findbyManagementName(String name) {
       Management managment = null;
        List<Management> all=this.dao.findAll();
        for(int i=0;i<all.size();i++)
        {
            if (all.get(i).getName().equals(name))
                managment=all.get(i);
        }
        return managment;
    }
    @Override
    public Boolean deletebyManagementId(Long id) {
        Optional<Management> stuList=this.dao.findById(id);
        if(stuList.equals(null)) {
            return false;
        } else {
            this.dao.delete(stuList.get());
            return true;
        }
    }
    @Override
    public void reduce(Management managment){
        int x=managment.getGoodss().size();
        managment.setNumber(x);
        managment.setDateModified(new Date());
        this.dao.save(managment);
    }

    @Override
    public void updata(){
        System.out.println("!!!!");
        List<Management> managments=this.dao.findAll();
        for (int i=0;i<managments.size();i++){
            System.out.println(managments.get(i).getGoodss());
            this.reduce(managments.get(i));
        }
    }
    @Override
    public Boolean addManagement(Management managment) {
        this.save(managment);
        return true;
    }
    @Override
    public Boolean updateManagement(Management managment) {
       Management ma = this.findbyManagementId(managment.getId());
        ma.setName(managment.getName());
        ma.setNumber(managment.getNumber());
        ma.setNum(managment.getNum());
        ma.setGoodss(managment.getGoodss());
        ma.setDateModified(new Date());
        this.save(ma);
        return true;
    }
    @Override
    public Management search( String name) {
       Management managment = this.findbyManagementName(name);
        return managment;
    }

}

