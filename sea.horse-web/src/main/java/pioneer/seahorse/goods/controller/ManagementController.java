package pioneer.seahorse.goods.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


    @RequestMapping("/man")
    public String index() {
        return "management";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all", produces = "application/json;charset=utf-8")
    public List<Management> findAllManagement() {
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteManagement", produces = "application/json;charset=utf-8")
    public Boolean deleteManagement(@RequestBody Long id) {
        return this.manager.deletebyManagementId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addManagement", produces = "application/json;charset=utf-8")
    public Boolean addManagement(@RequestBody Management management) {
        return this.managementManager.addManagement(management);
    }
    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateManagement", produces = "application/json;charset=utf-8")
    public Boolean updateManagement(@RequestBody Management management) {
        return this.managementManager.updateManagement(management);
    }
    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchManagement", produces = "application/json;charset=utf-8")
    public Management search(@RequestBody String name) {
        return this.managementManager.search(name);
    }
}
