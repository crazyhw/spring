package pioneer.seahorse.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.trade.domain.Merchant;
import pioneer.seahorse.trade.service.MerchantManager;

import java.util.Date;
import java.util.List;

/**
 * MerchantController 类
 *
 * @author 于靖鑫
 * @date 2019/6/4 12:00
 */

@Controller
@RequestMapping("/merchant")
public class MerchantController extends GenericController<Merchant, Long, MerchantManager> {
    @Autowired
    MerchantManager merchantManager;

    @Autowired
    public void setMerchantManager(MerchantManager merchantManager) {
        this.merchantManager=merchantManager;
        this.manager=this.merchantManager;
    }


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Merchant> findAllMerchant(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteMerchant/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteMerchant(@PathVariable(value = "id") Long id){
        return this.manager.deletebyMerchantId(id);
    }

    @RequestMapping(value = "addMerchant",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Merchant addMerchant( Merchant merchant){
        this.manager.save(merchant);
        return merchant;
    }

    @RequestMapping(value = "updateMerchant",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Merchant updateMerchant(@RequestBody Merchant merchant){
        return this.merchantManager.updateMerchant(merchant);
    }

    @ResponseBody
    @RequestMapping(value = "searchMerchant",produces = "application/json;charset=utf-8")
    public Merchant search(@RequestBody String name) {
        return this.manager.findbyMerchantName(name);
    }
}
