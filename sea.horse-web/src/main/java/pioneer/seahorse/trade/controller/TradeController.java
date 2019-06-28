package pioneer.seahorse.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.trade.domain.Trade;
import pioneer.seahorse.trade.service.TradeManager;

import java.util.Date;
import java.util.List;

/**
 * TradeController 类
 *
 * @author 于靖鑫
 * @date 2019/6/4 12:00
 */

@Controller
@RequestMapping("/trade")
public class TradeController extends GenericController<Trade, Long, TradeManager> {
    @Autowired
    TradeManager tradeManager;

    @Autowired
    public void setTradeManager(TradeManager tradeManager) {
        this.tradeManager=tradeManager;
        this.manager=this.tradeManager;
    }


    @ResponseBody
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Trade> findAllTrade(){
        return this.manager.findAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteTrade/{id}",produces = "application/json;charset=utf-8")
    public Boolean deleteTrade(@PathVariable(value = "id") Long id){
        return this.manager.deletebyTradeId(id);
    }

    @RequestMapping(value = "addTrade",produces = "application/json;charset=utf-8")
    public @ResponseBody Trade addTrade( Trade trade){
        this.manager.save(trade);
        return trade;
    }

    @RequestMapping(value = "updateTrade",produces = "application/json;charset=utf-8")
    public @ResponseBody Trade updateTrade(@RequestBody Trade trade){
        return this.tradeManager.updateTrade(trade);
    }

    @ResponseBody
    @RequestMapping(value = "searchTrade",produces = "application/json;charset=utf-8")
    public Trade search(@RequestBody String name) {
        return this.manager.findbyTradeName(name);
    }
}
