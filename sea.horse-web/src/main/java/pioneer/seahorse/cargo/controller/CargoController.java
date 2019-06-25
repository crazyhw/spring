package pioneer.seahorse.cargo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping("/car")
    public String index() {
        return "cargo";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Cargo> findAllCargo(){
        return this.manager.getAll();
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteCargo",produces = "application/json;charset=utf-8")
    public Boolean deleteCargo(@RequestBody Long id){
        return this.cargoManager.DeleteCargo(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addCargo",produces = "application/json;charset=utf-8")
    public Boolean addCargo(@RequestBody Cargo cargo){
        return this.cargoManager.AddCargo(cargo);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateCargo",produces = "application/json;charset=utf-8")
    public Boolean updateCargo(@RequestBody Cargo cargo){
        return this.cargoManager.UpdataCargo(cargo);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchCargo",produces = "application/json;charset=utf-8")
    public Cargo search(@RequestBody String name) {
        return this.manager.findbyCargoName(name);
    }
}
