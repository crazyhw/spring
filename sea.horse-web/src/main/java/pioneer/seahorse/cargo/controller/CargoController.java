package pioneer.seahorse.cargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.cargo.domain.Cargo;
import pioneer.seahorse.cargo.domain.Shelves;
import pioneer.seahorse.cargo.service.CargoManager;
import pioneer.seahorse.cargo.service.ShelvesManager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * CargoController 类
 *
 * @author 任鑫意
 * @date 2019/6/21 19:17
 */
@Controller
@RequestMapping("/cargo")
public class CargoController extends GenericController<Cargo,Long, CargoManager> {

    @Autowired
    CargoManager cargoManager;

    @Autowired
    public void setCargoManager(CargoManager cargoManager) {
        this.cargoManager=cargoManager;
        this.manager=this.cargoManager;
    }


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Cargo> findAllCargo(){
        return this.manager.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCargo/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteCargo(@PathVariable(value = "id") Long id){
        return this.cargoManager.DeleteCargo(id);
    }

    @RequestMapping(path = "/addCargo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Cargo addCargo(Cargo cargo){
        this.cargoManager.AddCargo(cargo);
        return cargo;
    }

    @RequestMapping(path = "/updateCargo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Cargo updateCargo(@RequestBody Cargo cargo){
        System.out.println(cargo);
        return this.cargoManager.UpdataCargo(cargo);
    }

    @ResponseBody
    @RequestMapping(value = "searchCargo",produces = "application/json;charset=utf-8")
    public Cargo search(@RequestBody String name) {
        return this.manager.findbyCargoName(name);
    }
}
