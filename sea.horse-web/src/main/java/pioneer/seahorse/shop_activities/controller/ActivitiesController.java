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
 * @date 2019/6/21 20:25
 */

@Controller
@RequestMapping("/activities")
public class ActivitiesController extends GenericController<Activities,Long, ActivitiesManager> {
    @Autowired
    ActivitiesManager activitiesManager;
    ShopManager shopManager;

    @Autowired
    public void setActivitiesManager(ActivitiesManager activitiesManager) {
        this.activitiesManager=activitiesManager;
        this.manager=this.activitiesManager;
    }

    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager=shopManager;
    }

    @RequestMapping("/act")
    public String index() {
        return "activities";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Activities> findAllActivities(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteActivities",produces = "application/json;charset=utf-8")
    public Boolean deleteActivities(@RequestBody Long id){
        return this.manager.deletebyActivitiesId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addActivities",produces = "application/json;charset=utf-8")
    public Boolean addActivities(@RequestBody Activities activities){
        Shop shop=this.shopManager.findbyShopName(activities.getShop().getName());
        activities.setShop(shop);
        this.activitiesManager.save(activities);
        shop.getActivities().add(activities);
        return true;
    }

     @ResponseBody//标识转换成JSON处理
   @RequestMapping(value = "updateActivities",produces = "application/json;charset=utf-8")
    public Boolean updateActivities(@RequestBody Activities activities) {
         Shop shop=this.shopManager.findbyShopName(activities.getShop().getName());
         Activities ac = this.manager.findbyActivitiesId(activities.getId());
         ac.setNum(activities.getNum());
         ac.setType(activities.getType());
         ac.setContent(activities.getContent());
         ac.setDate(activities.getDate());
         ac.setShop(shop);
         ac.setDateModified(new Date());
         this.manager.save(ac);
         return shop.getActivities().add(ac);
     }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchActivities",produces = "application/json;charset=utf-8")
    public List<Activities> search(@RequestBody String name) {
        return this.activitiesManager.findbyActivitiesNameList(name);
    }
}