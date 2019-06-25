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

    @RequestMapping(value = "/mer",method = RequestMethod.GET)
    public String suc(){
        return "merchant";
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Merchant> findAllMerchant(){
        return this.manager.findAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteMerchant",produces = "application/json;charset=utf-8")
    public Boolean deleteMerchant(@RequestBody Long id){
        return this.manager.deletebyMerchantId(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addMerchant",produces = "application/json;charset=utf-8")
    public Boolean addMerchant(@RequestBody Merchant merchant){
        this.manager.save(merchant);
        return true;
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateMerchant",produces = "application/json;charset=utf-8")
    public Boolean updateMerchant(@RequestBody Merchant merchant){
        return this.merchantManager.updateMerchant(merchant);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchMerchant",produces = "application/json;charset=utf-8")
    public Merchant search(@RequestBody String name) {
        return this.manager.findbyMerchantName(name);
    }
}
