package pioneer.seahorse.dealer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.dealer.domain.Market;
import pioneer.seahorse.dealer.service.MarketManager;

import java.util.Date;
import java.util.List;

 @Controller
 @RequestMapping("/market")
 public class MarketController extends GenericController<Market,Long, MarketManager> {
     @Autowired
     MarketManager marketManager;

     @Autowired
     public void setMarketManager(MarketManager marketManager) {
         this.marketManager = marketManager;
         this.manager = this.marketManager;
     }


     @ResponseBody
     @RequestMapping(value = "all", method = RequestMethod.GET,produces = "application/json;charset=utf-8")
     public List<Market> findAllMarket() {
         return this.manager.findAll();
     }


     @ResponseBody
     @RequestMapping(value = "deleteMarket/{id}", method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
     public Boolean deleteMarket(@PathVariable(value = "id") Long id) {
         return this.manager.deletebyMarketId(id);
     }

     @RequestMapping(value = "addMarket", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
     public @ResponseBody Market addMarket( Market market) {
         return this.marketManager.addMarket(market);
     }

     @RequestMapping(value = "updateMarket",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
     public @ResponseBody Market updateMarket(@RequestBody Market market) {
         return this.marketManager.updateMarket(market);
     }

     @ResponseBody
     @RequestMapping(value = "searchMarket", produces = "application/json;charset=utf-8")
     public Market search(@RequestBody String name) {
         return this.marketManager.findbyMarketName(name);
     }
 }

