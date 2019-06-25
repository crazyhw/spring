package pioneer.seahorse.dealer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


     @RequestMapping("/market")
     public String index() {
         return "market";
     }

     @ResponseBody//标识转换成JSON处理
     @RequestMapping(value = "all", produces = "application/json;charset=utf-8")
     public List<Market> findAllMarket() {
         return this.manager.findAll();
     }


     @ResponseBody//标识转换成JSON处理
     @RequestMapping(value = "deleteMarket", produces = "application/json;charset=utf-8")
     public Boolean deleteMarket(@RequestBody Long id) {
         return this.manager.deletebyMarketId(id);
     }

     @ResponseBody//标识转换成JSON处理
     @RequestMapping(value = "addMarket", produces = "application/json;charset=utf-8")
     public Boolean addMarket(@RequestBody Market market) {
         return this.marketManager.addMarket(market);
     }
     @ResponseBody//标识转换成JSON处理
     @RequestMapping(value = "updateMarket", produces = "application/json;charset=utf-8")
     public Boolean updateMarket(@RequestBody Market market) {
         return this.marketManager.updateMarket(market);
     }
     @ResponseBody//标识转换成JSON处理
     @RequestMapping(value = "searchMarket", produces = "application/json;charset=utf-8")
     public Market search(@RequestBody String name) {
         return this.marketManager.findbyMarketName(name);
     }
 }

