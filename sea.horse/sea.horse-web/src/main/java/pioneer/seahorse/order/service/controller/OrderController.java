package pioneer.seahorse.order.service.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.order.service.OrderManager;
import pioneer.seahorse.orders.domain.ordrs;
import pioneer.seahorse.student.domain.Student;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController extends GenericController<ordrs, Long, OrderManager> {
  @Autowired
    OrderManager orderManager;

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
       this.manager = this.orderManager;
    }

    @RequestMapping("/index")
    public String index() {
        return "order/index";
    } //返回首页

    @ResponseBody
    //表示将生产xml格式的数据，此时根据请求头中的Accept进行匹配
    @GetMapping(value = "hello", produces = "application/json;charset=utf-8")
    public String hello() {
        return "Hello, This is order!";
    }


        @RequestMapping(value = "/ord",method = RequestMethod.GET)
        public String suc(){
            return "ord";
        }

        @ResponseBody//标识转换成JSON处理
        @GetMapping(value = "all",produces = "application/json;charset=utf-8")
        public List<ordrs> findAllStudent(){
            return  orderManager.getAll();
        }


        @ResponseBody//标识转换成JSON处理
        @RequestMapping(value = "deleteord",produces = "application/json;charset=utf-8")
        public void deleteStudent(@RequestBody Long num){
            //return this.manager.deleteStudentNum(num);
               orderManager.delete(num);
        }

        @ResponseBody//标识转换成JSON处理
        @RequestMapping(value = "addord",produces = "application/json;charset=utf-8")
        public Boolean addStudent(@RequestBody ordrs ord){
            orderManager.save(ord);
            return true;
        }

        @ResponseBody//标识转换成JSON处理
        @RequestMapping(value = "updateords",produces = "application/json;charset=utf-8")
        public Boolean updateStudent(@RequestBody  ordrs ord){
            /*ordrs ord1= orderManager.findById(455445);
            ord1.setProductName(ord.getProductName());
            ord1.setCurrentUnitPrice(ord.getCurrentUnitPrice());
            ord1.setOrderNo(ord.getOrderNo());
            //ord.getQuantity(ord.getProductId());
            ord1.setDateModified(new Date());
            this.manager.save(ord);*/
            return true;
        }

        @ResponseBody//标识转换成JSON处理
        @RequestMapping(value = "searchStudent",produces = "application/json;charset=utf-8")
        public Student search(@RequestBody String num) {
           // Student student=this.manager.findbyStudentnum(num);
            //return student;
            return null;
        }
    }





