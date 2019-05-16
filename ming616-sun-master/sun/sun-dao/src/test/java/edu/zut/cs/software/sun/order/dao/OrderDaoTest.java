package edu.zut.cs.software.sun.order.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.sun.order.domain.Order;

public class OrderDaoTest extends GenericDaoTestCase<Long, Order, OrderDao> {

	OrderDao orderDao;

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
		this.dao = this.orderDao;
	}

	@Test
	public void testFindAll() {
		for (int i = 0; i < 10; i++) {
			Order order = new Order();
			order.setCode("Order_Code_" + i);
			Order newOrder = this.orderDao.save(order);
			assertNotNull(newOrder);
		}

		List<Order> result  = this.orderDao.findAll();
	}

}
