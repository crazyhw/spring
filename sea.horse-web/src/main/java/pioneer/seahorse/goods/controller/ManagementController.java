package pioneer.seahorse.goods.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.goods.domain.Management;
import pioneer.seahorse.goods.service.ManagementManager;

import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagementController extends GenericController<Management,Long, ManagementManager>{
    @Autowired
    ManagementManager managementManager;

    @Autowired
    public void setManagementManager(ManagementManager managementManager) {
        this.managementManager = managementManager;
        this.manager = this.managementManager;
    }



    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Management> findAllManagement() {
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteManagement/{id}",method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Boolean deleteManagement(@PathVariable(value = "id") Long id) {
        return this.manager.deletebyManagementId(id);
    }

    @RequestMapping(value = "addManagement", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Management addManagement( Management management) {
        return this.managementManager.addManagement(management);
    }

    @RequestMapping(value = "updateManagement",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Management updateManagement(@RequestBody Management management) {
        return this.managementManager.updateManagement(management);
    }
    @ResponseBody
    @RequestMapping(value = "searchManagement", produces = "application/json;charset=utf-8")
    public Management search(@RequestBody String name) {
        return this.managementManager.search(name);
    }
}
