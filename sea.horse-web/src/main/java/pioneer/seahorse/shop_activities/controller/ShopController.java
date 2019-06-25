package pioneer.seahorse.shop_activities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.shop_activities.domain.Activities;
import pioneer.seahorse.shop_activities.domain.Shop;
import pioneer.seahorse.shop_activities.service.ActivitiesManager;
import pioneer.seahorse.shop_activities.service.ShopManager;

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

    @RequestMapping("/sho")
    public String index() {
        return "shop";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Shop> findAllShop(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteShop",produces = "application/json;charset=utf-8")
    public Boolean deleteShop(@RequestBody Long id){
        return this.manager.deletebyShopId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addShop",produces = "application/json;charset=utf-8")
    public Boolean addShop(@RequestBody Shop shop){
        shop.setSale(0);
        shop.setAccount(0);
        this.manager.save(shop);
        return true;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateShop",produces = "application/json;charset=utf-8")
    public Boolean updateShop(@RequestBody Shop shop){
        Shop sh=this.manager.findbyShopId(shop.getId());
        sh.setName(shop.getName());
        sh.setDateModified(new Date());
        this.manager.save(sh);
        return true;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchShop",produces = "application/json;charset=utf-8")
    public Shop search(@RequestBody String name) {
        return this.manager.findbyShopName(name);
    }

}
