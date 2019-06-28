package pioneer.seahorse.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.order.damain.Orders;
import pioneer.seahorse.orders.service.OrdersManager;

import java.util.List;

/**
 * OrderssController 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:27
 */
@Controller
@RequestMapping("/orders")
public class OrdersController extends GenericController<Orders,Long, OrdersManager> {

    @Autowired
    OrdersManager ordersManager;

    @Autowired
    public void setOrdersManager(OrdersManager ordersManager) {
        this.ordersManager=ordersManager;
        this.manager=this.ordersManager;
    }


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Orders> findAllOrders(){
        return this.manager.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrders/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteOrders(@PathVariable(value = "id") Long id){
        return this.ordersManager.DeleteOrders(id);
    }

    @RequestMapping(path = "/addOrders",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Orders addOrders(Orders orders){
        this.ordersManager.AddOrders(orders);
        return orders;
    }

    @RequestMapping(path = "/updateOrders",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Orders updateOrders(@RequestBody Orders orders){
        System.out.println(orders);
        return this.ordersManager.UpdataOrders(orders);
    }

    @ResponseBody
    @RequestMapping(value = "searchOrders",produces = "application/json;charset=utf-8")
    public Orders search(@RequestBody String name) {
        return this.manager.findbyOrdersName(name);
    }
}
