package pioneer.seahorse.dealer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Dealer> findAllDealer(){
        return this.manager.getAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteDealer/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteDealer(@PathVariable(value = "id") Long id){
        return this.dealerManager.deleteDealer(id);
    }


    @RequestMapping(value = "addDealer",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Dealer addDealer( Dealer dealer){
       return this.dealerManager.addDealer(dealer);
    }


    @RequestMapping(value = "updateDealer",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Dealer updateDealer(@RequestBody Dealer dealer){
        return this.dealerManager.updateDealer(dealer);
    }

    @ResponseBody
    @RequestMapping(value = "searchDealer",produces = "application/json;charset=utf-8")
    public Dealer search(@RequestBody String name) {
        return this.manager.findbyDealerName(name);
    }
}
