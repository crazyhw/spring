package pioneer.seahorse.cargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Shelves> findAllShelves(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteShelves/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteShelves(@PathVariable(value = "id") Long id){
        return this.manager.deletebyShelvesId(id);
    }


    @RequestMapping(value = "addShelves",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Shelves addShelves( Shelves shelves){
        return this.shelvesManager.addShelves(shelves);
    }

    @RequestMapping(value = "updateShelves",produces = "application/json;charset=utf-8")
    public @ResponseBody Shelves updateShelves(@RequestBody Shelves shelves){
        return this.shelvesManager.UpdataShelves(shelves);
    }

    @ResponseBody
    @RequestMapping(value = "searchShelves",produces = "application/json;charset=utf-8")
    public Shelves search(@RequestBody String name) {
        return this.manager.findbyShelvesName(name);
    }
}
