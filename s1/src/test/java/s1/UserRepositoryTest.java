package s1;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserRepositoryTest {
    
    @Autowired
    private UserRepositor userRepository;
    
    @Autowired
    @Test
    public void baseTest() throws Exception {
    	// ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
       ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = new User();
         ctx.getBean("UserDao");
        user.setName("Jay");
        user.setPassword("123456");
        user.setBirthday("2008-08-08");
        userRepository.findOne(2);
        
        userRepository.save(user);
   
//        userRepository.delete(user);
//        userRepository.findOne(1);*/
    

    
        //获取上下文
      
       // private UserRepositor userRepository1 = null;
       
         
        
    }
}