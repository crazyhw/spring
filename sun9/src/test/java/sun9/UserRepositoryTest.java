package sun9;

import org.junit.Test;

import dao.User;
import dao.UserRepository;
public class UserRepositoryTest
{

@Autowired
private UserRepository dao;
	
@Test//保存
	public void testSave(){
		User user = new User();
		user.setName("chhliu");
		user.setAccount("10000");
		user.setEmail("chhliu@.com");
		user.setPassword("123456");
		dao.save(user);
	}
	
	
	
	@Test//通过id列表来查询
	public void testFindUserByIds(){
		List<Integer> listIds = new ArrayList<Integer>();
		listIds.add(2);
		listIds.add(4);
		listIds.add(7);
		List<User> users = (List<User>) dao.findAll(listIds);
		System.out.println(JSON.toJSONString(users));
	}
}