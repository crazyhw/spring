package s6;
/*���������*/
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
	 
	        ModelAndView mv = new ModelAndView("Hello");     //ָ����ͼ���ڴ��ݿ��Ʒ������������ݵ����ҳ�棬Ҳ����˵���ǰ���Ҫ�ڽ��ҳ������Ҫ�����ݷŵ�ModelAndView������
	      //����ͼ�������Ҫչʾ��ʹ�õ����ݣ�����ҳ����ʹ��
	        mv.addObject("message", message);                //���ģ��������addObject;
	        mv.addObject("name", name);
	        return mv;
	    }
	}
}