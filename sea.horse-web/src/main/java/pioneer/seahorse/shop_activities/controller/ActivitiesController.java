package pioneer.seahorse.shop_activities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.pay.domain.Activities;
import pioneer.seahorse.pay.domain.Shop;
import pioneer.seahorse.pay.service.ActivitiesManager;
import pioneer.seahorse.pay.service.ShopManager;

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


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Activities> findAllActivities(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteActivities/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteActivities(@PathVariable(value = "id") Long id){
        return this.manager.deletebyActivitiesId(id);
    }

    @RequestMapping(value = "addActivities",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Activities addActivities( Activities activities){
        Shop shop=this.shopManager.findbyShopName(activities.getShop().getName());
        activities.setShop(shop);
        this.activitiesManager.save(activities);
        shop.getActivities().add(activities);
        return activities;
    }


   @RequestMapping(value = "updateActivities",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Activities updateActivities(@RequestBody Activities activities) {
         Shop shop=this.shopManager.findbyShopName(activities.getShop().getName());
         Activities ac = this.manager.findbyActivitiesId(activities.getId());
         ac.setNum(activities.getNum());
         ac.setType(activities.getType());
         ac.setContent(activities.getContent());
         ac.setDate(activities.getDate());
         ac.setShop(shop);
         ac.setDateModified(new Date());
         this.manager.save(ac);
         shop.getActivities().add(ac);
         return activities;
     }

    @ResponseBody
    @RequestMapping(value = "searchActivities",produces = "application/json;charset=utf-8")
    public List<Activities> search(@RequestBody String name) {
        return this.activitiesManager.findbyActivitiesNameList(name);
    }
}