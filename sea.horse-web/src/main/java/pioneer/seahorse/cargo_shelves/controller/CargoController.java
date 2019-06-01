package pioneer.seahorse.cargo_shelves.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.cargo_shelves.domain.Cargo;
import pioneer.seahorse.cargo_shelves.service.CargoManager;

@Controller
@RequestMapping("/cargo")
public class CargoController extends GenericController<Cargo, Long, CargoManager> {

    CargoManager cargoManager;
    @Autowired
    public void setCargoManager(CargoManager cargoManager) {
        this.cargoManager = cargoManager;
        this.manager = this.cargoManager;
    }

    @RequestMapping("/index")
    public String index() {
        return "cargo/index";
    }

    @ResponseBody
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is Cargo!";
    }

}
