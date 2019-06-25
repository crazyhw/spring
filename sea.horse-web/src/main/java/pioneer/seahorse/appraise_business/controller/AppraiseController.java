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

    @RequestMapping("/app")
    public String index() {
        return "appraise";
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Appraise> findAllAppraise(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteAppraise",produces = "application/json;charset=utf-8")
    public Boolean deleteAppraise(@RequestBody Long id){
        return this.manager.deletebyAppraiseId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addAppraise",produces = "application/json;charset=utf-8")
    public Boolean addAppraise(@RequestBody Appraise appraise){
        return this.appraiseManager.addAppraise(appraise);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateAppraise",produces = "application/json;charset=utf-8")
    public Boolean updateAppraise(@RequestBody Appraise appraise){
        return this.appraiseManager.updateAppraise(appraise);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchAppraise",produces = "application/json;charset=utf-8")
    public Appraise search(@RequestBody String name) {
        return this.manager.findbyAppraiseName(name);
    }
}