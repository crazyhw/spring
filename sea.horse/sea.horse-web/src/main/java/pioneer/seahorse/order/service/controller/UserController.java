package pioneer.seahorse.order.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pioneer.seahorse.order.service.OrderManager;
import pioneer.seahorse.orders.domain.ordrs;

@Controller
@CrossOrigin(origins="*")
@RequestMapping("/order")
public class UserController {

   @Autowired
    OrderManager ord;
    @Autowired
    private OrderManager userService;

    @RequestMapping("/order.do")
    @ResponseBody
    public ModelAndView say()
    {
        ordrs s= (ordrs) ord.getAll();
        ModelAndView s1=new ModelAndView("or");

        System.out.println("你好");
        return s1;
    }
    }

