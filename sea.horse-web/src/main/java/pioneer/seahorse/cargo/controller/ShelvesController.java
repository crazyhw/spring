package pioneer.seahorse.cargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.cargo.domain.Shelves;
import pioneer.seahorse.cargo.service.ShelvesManager;

import java.util.Date;
import java.util.List;

/**
 * ShelvesController 类
 *
 * @author 任鑫意
 * @date 2019/6/21 19:17
 */
@Controller
@RequestMapping("/shelves")
public class ShelvesController extends GenericController<Shelves,Long, ShelvesManager> {
    @Autowired
    ShelvesManager shelvesManager;

    @Autowired
    public void setShelvesManager(ShelvesManager shelvesManager) {
        this.shelvesManager=shelvesManager;
        this.manager=this.shelvesManager;
    }


    @RequestMapping("/shelve")
    public String index() {
        return "shelves";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Shelves> findAllShelves(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteShelves",produces = "application/json;charset=utf-8")
    public Boolean deleteShelves(@RequestBody Long id){
        return this.manager.deletebyShelvesId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addShelves",produces = "application/json;charset=utf-8")
    public Boolean addShelves(@RequestBody Shelves shelves){
        return this.shelvesManager.addShelves(shelves);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateShelves",produces = "application/json;charset=utf-8")
    public Boolean updateShelves(@RequestBody Shelves shelves){
        return this.shelvesManager.UpdataShelves(shelves);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchShelves",produces = "application/json;charset=utf-8")
    public Shelves search(@RequestBody String name) {
        return this.manager.findbyShelvesName(name);
    }
}
