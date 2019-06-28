package pioneer.seahorse.distribition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.distribition.domain.Order;
import pioneer.seahorse.distribition.service.OrderManager;

import java.util.List;

/**
 * OrderController 类
 *
 * @author 郭万江
 * @date 2019/6/27 15:19
 */
@Controller
@RequestMapping("/order")
public class OrderController extends GenericController<Order,Long, OrderManager> {

    @Autowired
    OrderManager orderManager;

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager=orderManager;
        this.manager=this.orderManager;
    }


    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<Order> findAllOrder(){
        return this.manager.getAll();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteOrder(@PathVariable(value = "id") Long id){
        return this.orderManager.DeleteOrder(id);
    }

    @RequestMapping(path = "/addOrder",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Order addOrder(Order order){
        this.orderManager.AddOrder(order);
        return order;
    }

    @RequestMapping(path = "/updateOrder",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Order updateOrder(@RequestBody Order order){
        System.out.println(order);
        return this.orderManager.UpdataOrder(order);
    }

    @ResponseBody
    @RequestMapping(value = "searchOrder",produces = "application/json;charset=utf-8")
    public Order search(@RequestBody String name) {
        return this.manager.findbyOrderName(name);
    }
}
