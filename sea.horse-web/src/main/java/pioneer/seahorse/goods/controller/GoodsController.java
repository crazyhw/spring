package pioneer.seahorse.goods.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.goods.domain.Goods;
import pioneer.seahorse.goods.service.GoodsManager;
import pioneer.seahorse.goods.service.ManagementManager;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController extends GenericController<Goods,Long, GoodsManager> {
    @Autowired
    GoodsManager goodsManager;
    ManagementManager marketManager;

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager=goodsManager;
        this.manager=this.goodsManager;
    }

    @Autowired
    public void setManagementManager(ManagementManager marketManager) {

        this.marketManager=marketManager;
    }

    @RequestMapping("/goo")
    public String index() {
        return "goods";
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Goods> findAllGoods(){
        return this.manager.getAll();
    }


    @ResponseBody
    @RequestMapping(value = "deleteGoods/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteGoods(@PathVariable(value = "id") Long id){
        return this.goodsManager.deleteGoods(id);
    }

    @RequestMapping(value = "addGoods",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Goods addGoods( Goods goods){
        return this.goodsManager.addGoods(goods);
    }

    @RequestMapping(value = "updateGoods",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Goods updateGoods(@RequestBody Goods goods){
        return this.goodsManager.updateGoods(goods);
    }

    @ResponseBody
    @RequestMapping(value = "searchGoods",produces = "application/json;charset=utf-8")
    public Goods search(@RequestBody String name) {
        Goods goods=this.manager.findbyGoodsName(name);
        return goods;
    }
}
