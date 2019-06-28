package pioneer.seahorse.distribition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.distribition.domain.Deliveryclerk;
import pioneer.seahorse.distribition.service.DeliveryclerkManager;

import java.util.List;

/**
 * DeliveryclerkController 类
 *
 * @author 郭万江
 * @date 2019/6/27 15:19
 */
@Controller
@RequestMapping("/deliveryclerk")
public class DeliveryclerkController extends GenericController<Deliveryclerk,Long, DeliveryclerkManager> {
    @Autowired
    DeliveryclerkManager deliveryclerkManager;

    @Autowired
    public void setDeliveryclerkManager(DeliveryclerkManager deliveryclerkManager) {
        this.deliveryclerkManager=deliveryclerkManager;
        this.manager=this.deliveryclerkManager;
    }

    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Deliveryclerk> findAllDeliveryclerk(){
        return this.manager.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "deleteDeliveryclerk/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteDeliveryclerk(@PathVariable(value = "id") Long id){
        return this.manager.deletebyDeliveryclerkId(id);
    }

    @RequestMapping(value = "addDeliveryclerk",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Deliveryclerk addDeliveryclerk( Deliveryclerk deliveryclerk){
        return this.deliveryclerkManager.addDeliveryclerk(deliveryclerk);
    }

    @RequestMapping(value = "updateDeliveryclerk",produces = "application/json;charset=utf-8")
    public @ResponseBody Deliveryclerk updateDeliveryclerk(@RequestBody Deliveryclerk deliveryclerk){
        return this.deliveryclerkManager.UpdataDeliveryclerk(deliveryclerk);
    }

    @ResponseBody
    @RequestMapping(value = "searchDeliveryclerk",produces = "application/json;charset=utf-8")
    public Deliveryclerk search(@RequestBody String name) {
        return this.manager.findbyDeliveryclerkName(name);
    }
}
