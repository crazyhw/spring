package pioneer.seahorse.dealer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.dealer.domain.Dealer;
import pioneer.seahorse.dealer.domain.Market;
import pioneer.seahorse.dealer.service.DealerManager;
import pioneer.seahorse.dealer.service.MarketManager;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/dealer")
public class DealerController extends GenericController<Dealer,Long, DealerManager> {
    @Autowired
    DealerManager dealerManager;
    MarketManager marketManager;

    @Autowired
    public void setDealerManager(DealerManager dealerManager) {
        this.dealerManager=dealerManager;
        this.manager=this.dealerManager;
    }

    @Autowired
    public void setMarketManager(MarketManager marketManager) {
        this.marketManager=marketManager;
    }

    @RequestMapping("/dea")
    public String index() {
        return "dealer";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Dealer> findAllDealer(){
        return this.manager.getAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteDealer",produces = "application/json;charset=utf-8")
    public Boolean deleteDealer(@RequestBody Long id){
        return this.dealerManager.deleteDealer(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addDealer",produces = "application/json;charset=utf-8")
    public Boolean addDealer(@RequestBody Dealer dealer){
       return this.dealerManager.addDealer(dealer);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateDealer",produces = "application/json;charset=utf-8")
    public Boolean updateDealer(@RequestBody Dealer dealer){
        return this.dealerManager.updateDealer(dealer);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchDealer",produces = "application/json;charset=utf-8")
    public Dealer search(@RequestBody String name) {
        return this.manager.findbyDealerName(name);
    }
}
