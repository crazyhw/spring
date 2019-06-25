package pioneer.seahorse.goods.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Goods> findAllGoods(){
        return this.manager.getAll();
    }


    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "deleteGoods",produces = "application/json;charset=utf-8")
    public Boolean deleteGoods(@RequestBody Long id){
        return this.goodsManager.deleteGoods(id);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "addGoods",produces = "application/json;charset=utf-8")
    public Boolean addGoods(@RequestBody Goods goods){
        return this.goodsManager.addGoods(goods);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "updateGoods",produces = "application/json;charset=utf-8")
    public Boolean updateGoods(@RequestBody Goods goods){
        return this.goodsManager.updateGoods(goods);
    }

    @ResponseBody//标识转换成JSON处理
    @RequestMapping(value = "searchGoods",produces = "application/json;charset=utf-8")
    public Goods search(@RequestBody String name) {
        Goods goods=this.manager.findbyGoodsName(name);
        return goods;
    }
}
