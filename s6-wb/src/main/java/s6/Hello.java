package s6;
/*定义控制器*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
public class Hello {

	@Controller
	public class HelloSpringController {
	    String message = "Welcome to Spring MVC!";
	 
	    @RequestMapping("Hello")
	    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
	 
	        ModelAndView mv = new ModelAndView("Hello");     //指定视图用于传递控制方法处理结果数据到结果页面，也就是说我们把需要在结果页面上需要的数据放到ModelAndView对象中
	      //向视图中添加所要展示或使用的内容，将在页面中使用
	        mv.addObject("message", message);                //添加模型数据用addObject;
	        mv.addObject("name", name);
	        return mv;
	    }
	}
}