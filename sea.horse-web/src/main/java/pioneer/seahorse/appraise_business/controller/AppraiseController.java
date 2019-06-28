package pioneer.seahorse.appraise_business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.appraise_business.service.AppraiseManager;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.appraise_business.domain.Appraise;
import java.util.List;

@Controller
@RequestMapping("/appraise")
public class AppraiseController extends GenericController <Appraise,Long,AppraiseManager>{

    @Autowired
    AppraiseManager appraiseManager;

    @Autowired
    public void setAppraiseManager(AppraiseManager appraiseManager) {
        this.appraiseManager = appraiseManager;
        this.manager = this.appraiseManager;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Appraise> findAllAppraise(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteAppraise/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteAppraise(@PathVariable(value = "id") Long id){
        return this.manager.deletebyAppraiseId(id);
    }

    @RequestMapping(value = "addAppraise",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Appraise addAppraise( Appraise appraise){
        return this.appraiseManager.addAppraise(appraise);
    }

    @RequestMapping(value = "updateAppraise",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Appraise updateAppraise(@RequestBody Appraise appraise){
        return this.appraiseManager.updateAppraise(appraise);
    }

    @ResponseBody
    @RequestMapping(value = "searchAppraise",produces = "application/json;charset=utf-8")
    public Appraise search(@RequestBody String name) {
        return this.manager.findbyAppraiseName(name);
    }
}