package pioneer.seahorse.shop_activities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.pay.domain.Shop;
import pioneer.seahorse.pay.service.ActivitiesManager;
import pioneer.seahorse.pay.service.ShopManager;

import java.util.Date;
import java.util.List;

/**
 * @author lvqingyv
 * @date 2019/6/23 20:43
 */
@Controller
@RequestMapping("/shop")
public class ShopController  extends GenericController <Shop,Long, ShopManager>{

    @Autowired
    ShopManager shopManager;
    ActivitiesManager activitiesManager;

    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager=shopManager;
        this.manager=this.shopManager;
    }

    @Autowired
    public void setActivitiesManager(ActivitiesManager activitiesManager) {
        this.activitiesManager=activitiesManager;
    }


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Shop> findAllShop(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteShop/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteShop(@PathVariable(value = "id") Long id){
        return this.manager.deletebyShopId(id);
    }

    @RequestMapping(value = "addShop",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Shop addShop( Shop shop){
        shop.setSale(0);
        shop.setAccount(0);
        this.manager.save(shop);
        return shop;
    }

    @RequestMapping(value = "updateShop",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Shop updateShop( Shop shop){
        Shop sh=this.manager.findbyShopId(shop.getId());
        sh.setName(shop.getName());
        sh.setDateModified(new Date());
        this.manager.save(sh);
        return shop;
    }

    @ResponseBody
    @RequestMapping(value = "searchShop",produces = "application/json;charset=utf-8")
    public Shop search(@RequestBody String name) {
        return this.manager.findbyShopName(name);
    }

}
