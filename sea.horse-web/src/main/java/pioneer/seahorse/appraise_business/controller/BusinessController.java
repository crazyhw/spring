package pioneer.seahorse.appraise_business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.appraise_business.domain.Business;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.appraise_business.service.AppraiseManager;
import pioneer.seahorse.appraise_business.service.BusinessManager;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/business")
public class BusinessController extends GenericController <Business,Long,BusinessManager>{
    @Autowired
    BusinessManager businessManager;

    @Autowired
    public void setBusinessManager(BusinessManager businessManager) {
        this.businessManager = businessManager;
        this.manager = this.businessManager;
    }

    @ResponseBody
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Business> findAllBusiness(){
        return this.manager.findAll();
    }


    @RequestMapping(value = "deleteBusiness/{id}",produces = "application/json;charset=utf-8")
    public Boolean deleteBusiness(@PathVariable(value = "id") Long id){
        return this.manager.deletebyBusinessId(id);
    }

    @RequestMapping(value = "addBusiness",produces = "application/json;charset=utf-8")
    public @ResponseBody Business addBusiness( Business business){
        this.manager.save(business);
        return business;
    }

    @RequestMapping(value = "updateBusiness",produces = "application/json;charset=utf-8")
    public @ResponseBody Business updateBusiness(@RequestBody Business business){
        return this.businessManager.updateBusiness(business);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchBusiness",produces = "application/json;charset=utf-8")
    public Business search(@RequestBody String name) {
        return this.manager.findbyBusinessName(name);
    }
}
