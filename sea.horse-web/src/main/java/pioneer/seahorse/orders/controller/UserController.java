package pioneer.seahorse.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pioneer.seahorse.base.web.GenericController;
import pioneer.seahorse.order.damain.User;
import pioneer.seahorse.orders.service.UserManager;

import java.util.List;

/**
 * UserController 类
 *
 * @author 张国伟
 * @date 2019/6/27 16:27
 */
@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User,Long, UserManager> {
    @Autowired
    UserManager userManager;

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager=userManager;
        this.manager=this.userManager;
    }

    @ResponseBody
    @RequestMapping(value = "all",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public List<User> findAllUser(){
        return this.manager.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "deleteUser/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public Boolean deleteUser(@PathVariable(value = "id") Long id){
        return this.manager.deletebyUserId(id);
    }

    @RequestMapping(value = "addUser",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody User addUser( User user){
        return this.userManager.addUser(user);
    }

    @RequestMapping(value = "updateUser",produces = "application/json;charset=utf-8")
    public @ResponseBody User updateUser(@RequestBody User user){
        return this.userManager.UpdataUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "searchUser",produces = "application/json;charset=utf-8")
    public User search(@RequestBody String name) {
        return this.manager.findbyUserName(name);
    }
}
